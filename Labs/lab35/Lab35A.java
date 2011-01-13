import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab35A implements ActionListener {
  JFrame frame;
  JButton button;
  JLabel message;

  public static void main(String[] args) {
    Lab35A me = new Lab35A();
    me.go();
  }

  public void go() {
    frame = new JFrame("Hidden message");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 200);

    message = new JLabel("Your message goes here...");
    message.setHorizontalAlignment(JLabel.CENTER);
    frame.getContentPane().add(message, BorderLayout.NORTH);

    button = new JButton("Click me");
    button.addActionListener(this);
    frame.getContentPane().add(button, BorderLayout.CENTER);
    
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    message.setText("Hello world!");
  }
}

