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

