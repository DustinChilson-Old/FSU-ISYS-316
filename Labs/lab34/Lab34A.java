import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab34A {
  JFrame frame;
  MyPanel panel;
  public static void main(String[] args) {
    Lab34A me = new Lab34A();
    me.go();
  }
  public void go() {
    frame = new JFrame("My line");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(250, 250);
    panel = new MyPanel();
    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }
}
class MyPanel extends JPanel {
  public void paintComponent(Graphics g) {
    int height = this.getHeight();
    int width = this.getWidth();
    int midX = width/2;
    int midY = height/2;
    g.setColor(Color.white);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.red);
    g.drawLine(0, 
               height-1, 
               width-1, 
               0);
  }
}

