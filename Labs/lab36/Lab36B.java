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

