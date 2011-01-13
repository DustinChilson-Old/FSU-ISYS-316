//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab36A {
  JFrame frame;
  JButton inner;
  JButton outer;
  JLabel message;
  public static void main(String[] args) {
    Lab36A me = new Lab36A();
    me.go();
  }
  public void go() {
    frame = new JFrame("A button in a button");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    outer = new JButton("Outer");
    outer.setBackground(Color.black);
    outer.setForeground(Color.white);
    outer.addActionListener(new OuterListener());
    outer.setLayout(new FlowLayout());
    inner = new JButton("Inner");
    inner.setBackground(Color.red);
    inner.addActionListener(new InnerListener());
    outer.add(inner, BorderLayout.SOUTH);
    frame.getContentPane().add(outer, BorderLayout.CENTER);
    message = new JLabel("Click a button...");
    message.setHorizontalAlignment(JLabel.CENTER);
    frame.getContentPane().add(message, BorderLayout.SOUTH);
    frame.setVisible(true);
  }
  class OuterListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      message.setText("Outer button clicked");
    }
  }
  class InnerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      message.setText("Inner button clicked");
    }
  }
}

//==================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab36B implements ActionListener {
  JFrame frame;
  JButton b1;
  JButton b2;
  JPanel panel;
  JLabel message;
  public static void main(String[] args) {
    Lab36B me = new Lab36B();
    me.go();
  }
  public void go() {
    frame = new JFrame("2 Buttons");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 150);
    frame.setResizable(false);
    message = new JLabel("Click a button...");
    message.setHorizontalAlignment(JLabel.CENTER);
    frame.getContentPane().add(message, BorderLayout.CENTER);
    panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    b1 = new JButton("Button 1");
    b2 = new JButton("Button 2");
    b1.addActionListener(this);
    b2.addActionListener(this);
    panel.add(b1);
    panel.add(b2);
    frame.getContentPane().add(panel, BorderLayout.SOUTH);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    message.setText("You clicked: " + ((JButton)e.getSource()).getText());
  }
}

//==================================================================================
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

//==================================================================================
