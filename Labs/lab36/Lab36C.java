import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab36C {
  JFrame frame;
  JPanel panel;
  Rectangle x;
  Circle y;
  public static void main(String[] args) {
    Lab36C me = new Lab36C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Shapes");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 450);
    frame.setResizable(false);
    panel = new JPanel();
    panel.setBackground(Color.black);
    panel.setLayout(new FlowLayout());
    x = new Rectangle();
    panel.add(x);
    y = new Circle();
    panel.add(y);
    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }
  class Rectangle extends JPanel {
    public Rectangle() {
      this.setPreferredSize(new Dimension(50, 200));
    }
    public void paintComponent(Graphics g) {
      g.setColor(Color.green);
      g.fillRect(0, 0, 50, 200);
    }
  }
  class Circle extends JPanel {
    public Circle() {
      this.setPreferredSize(new Dimension(200, 200));
    }
    public void paintComponent(Graphics g) {
      g.setColor(Color.red);
      g.fillOval(0, 0, 200, 200);
    }
  }
}

