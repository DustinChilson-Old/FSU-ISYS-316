import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Lab37B {
  JFrame frame;
  JList size;
  JLabel message;
  String[] sizes = {"Small", "Medium", "Large"};
  public static void main(String[] args) {
    Lab37B me = new Lab37B();
    me.go();
  }
  public void go() {
    frame = new JFrame("Change text size");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    size = new JList(sizes);
    size.setSelectedIndex(0);
    size.addListSelectionListener(new SizeListener());
    frame.getContentPane().add(size, BorderLayout.WEST);
    message = new JLabel("Hello World!", JLabel.CENTER);
    message.setFont(new Font("Serif", Font.PLAIN, 12));
    frame.getContentPane().add(message);
    frame.setVisible(true);
  }
  class SizeListener implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      int i = size.getSelectedIndex();
      int ptSize = 12 + (12 * i);
      message.setFont(new Font("Serif", Font.PLAIN, ptSize));
    }
  }
}

