import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab33C implements ActionListener {
  JFrame frame;
  JButton button;
  int count;
  public static void main(String[] args) {
    Lab33C me = new Lab33C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Click count: " + count);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    button = new JButton("Click to increment counter");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    count++;
    frame.setTitle("Click count: " + count);
  }
}

