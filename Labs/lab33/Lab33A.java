import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab33A implements ActionListener {
  JFrame frame;
  JButton button;
  public static void main(String[] args) {
    Lab33A me = new Lab33A();
    me.go();
  }
  public void go() {
    frame = new JFrame("Hide the button");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    button = new JButton("Click to hide");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    button.setVisible(false);
  }
}

