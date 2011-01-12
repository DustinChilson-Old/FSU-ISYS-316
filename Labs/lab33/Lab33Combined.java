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

//==================================================================================
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

//==================================================================================
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

//==================================================================================
