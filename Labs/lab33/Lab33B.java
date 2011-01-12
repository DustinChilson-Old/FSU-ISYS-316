import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab33B implements ActionListener {
  JFrame frame;
  JButton button;
  public static void main(String[] args) {
    Lab33B me = new Lab33B();
    me.go();
  }
  public void go() {
    frame = new JFrame("Reverse button text");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    button = new JButton("Click to reverse");
    button.addActionListener(this);
    frame.getContentPane().add(button);
    frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
    button.setText(new StringBuffer(button.getText()).reverse().toString());
  }
}

