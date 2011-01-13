import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab35C {
  JFrame frame;
  JButton green;
  JButton red;
  Dot dot;
  public static void main(String[] args) {
    Lab35C me = new Lab35C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Watch the dot");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    green = new JButton("Green dot");

    // REGISTER LISTENER
    // ADD TO TOP OF FRAME
    green.addActionListener(new GreenListener());
    frame.getContentPane().add(green, BorderLayout.NORTH);

    red = new JButton("Red dot");

    // REGISTER LISTENER
    // ADD TO BOTTOM OF FRAME
    red.addActionListener(new RedListener());
    frame.getContentPane().add(red, BorderLayout.SOUTH);

    dot = new Dot();
    frame.getContentPane().add(dot);
    frame.setVisible(true);
    while (true) {
      dot.repaint();
      try {
        Thread.sleep(50);
      }
      catch (Exception err) {}
    }
  }
  class Dot extends JPanel {
    Color color = Color.blue;
    public void paintComponent(Graphics g) {
      int height = this.getHeight();
      int width = this.getWidth();
      g.setColor(Color.white);
      g.fillRect(0, 0, width, height);
      g.setColor(color);
      int randomX = (int) (Math.random() * width);
      int randomY = (int) (Math.random() * height);
      g.fillOval(randomX, randomY, 30, 30);
    }
    public void changeColor(Color nColor) {
      color = nColor;
    }
  }
  class GreenListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      dot.changeColor(Color.green);
    }
  }
  class RedListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      dot.changeColor(Color.red);
    }
  }
}

