import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab34B {
  JFrame frame;
  MyPanel panel;
  public static void main(String[] args) {
    Lab34B me = new Lab34B();
    me.go();
  }
  public void go() {
    frame = new JFrame("My umbrella");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
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
    g.setColor(Color.lightGray);
    g.fillRect(0, 0, width, height);
    g.setColor(Color.red);
    g.fillArc(0, 0, width, height, 0, 180);
    g.setColor(Color.black);
    g.drawLine(midX, midY, midX, height-1);
  }
}

