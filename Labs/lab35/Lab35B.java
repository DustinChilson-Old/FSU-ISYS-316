import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab35B implements ActionListener {
  JFrame frame;
  JButton random;
  JButton clear;
  MyPanel panel;

  public static void main(String[] args) {
    Lab35B me = new Lab35B();
    me.go();
  }

  public void go() {
    frame = new JFrame("Color display");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);

    random = new JButton("Random color");
    random.addActionListener(this);
    frame.getContentPane().add(random, BorderLayout.NORTH);

    clear = new JButton("Clear");
    clear.addActionListener(this);
    frame.getContentPane().add(clear, BorderLayout.SOUTH);

    panel = new MyPanel();
    frame.getContentPane().add(panel);

    frame.setVisible(true);
  }

  class MyPanel extends JPanel {
    Color color = Color.white;

    public void paintComponent(Graphics g) {
      g.setColor(color);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void clear() {
      color = Color.white;
      repaint();
    }

    public void random() {
      int red = (int) (Math.random() * 250);
      int green = (int) (Math.random() * 250);
      int blue = (int) (Math.random() * 250);
      color = new Color(red, green, blue);
      repaint();
    }
  }

  // YOUR CODE GOES HERE
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(random)) {
            panel.random();
        }
        else if (e.getSource().equals(clear)) {
            panel.clear();
        }
    }

}

