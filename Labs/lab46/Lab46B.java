import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab46B {
  JFrame myFrame;
  JLabel message;
  MyButton b;
  Thread t;
  public static void main(String[] args) {
    Lab46B me = new Lab46B();
    me.go();
  }
  public void go() {
    myFrame = new JFrame("A colorful button");
    myFrame.setSize(300, 200);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    message = new JLabel("Click the button to stop its flashing");
    message.setHorizontalAlignment(JLabel.CENTER);
    myFrame.getContentPane().add(message);
    b = new MyButton("Colorful button");
    myFrame.getContentPane().add(b, BorderLayout.SOUTH);
    b.addActionListener(new ButtonListener());
    t = new Thread(b);
    t.start();
    myFrame.setVisible(true);
  }
  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      MyButton theButton = (MyButton)e.getSource();
      theButton.stop();
      message.setText(theButton.getText() + " is stopped");
    }
  }
}
class MyButton extends JButton implements Runnable {
  boolean alive;
  Color background;
  public MyButton(String text) {
    super(text);
  }
  public void run() {
    alive = true;
    while (alive) {
      try {
        Thread.sleep(250);
      }
      catch (InterruptedException e) {}
      setBackground(randomColor());
    }
  }
  public void stop() {
    alive = false;
  }
  public Color randomColor() {
    int red = ((int)(Math.random()*1000000)) % 256;
    int green = ((int)(Math.random()*1000000)) % 256;
    int blue = ((int)(Math.random()*1000000)) % 256;
    return new Color(red, green, blue);
  }
}
