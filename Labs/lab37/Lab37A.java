import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Lab37A {
  JFrame frame;
  JCheckBox size;
  JLabel message;
  public static void main(String[] args) {
    Lab37A me = new Lab37A();
    me.go();
  }
  public void go() {
    frame = new JFrame("Change text size");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    size = new JCheckBox("Large text");
    size.addItemListener(new SizeListener());
    frame.getContentPane().add(size, BorderLayout.NORTH);
    message = new JLabel("Hello World!", JLabel.CENTER);
    message.setFont(new Font("Serif", Font.PLAIN, 12));
    frame.getContentPane().add(message);
    frame.setVisible(true);
  }
  class SizeListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
      if (size.isSelected()) {
        message.setFont(new Font("Serif", Font.PLAIN, 36));
      }
      else {
        message.setFont(new Font("Serif", Font.PLAIN, 12));
      }
    }
  }
}

