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

//==================================================================================
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

//==================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab34C {
  JFrame frame;
  MyPanel panel;
  public static void main(String[] args) {
    Lab34C me = new Lab34C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Sunrise");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(375, 275);
    panel = new MyPanel();
    frame.getContentPane().add(panel);
    frame.setVisible(true);
  }
}
class MyPanel extends JPanel {
  public void paintComponent(Graphics g) {
    Image sunrise = new ImageIcon("Sunrise.JPG").getImage();
    g.drawImage(sunrise,0,0,this);

    // SET THE PEN COLOR TO RED
    g.setColor(Color.red);
    // SET THE FONT TO 12 POINT, BOLD, SANSSERIF
    g.setFont(new Font("sansserif", Font.BOLD, 12));
    // DRAW THE STRING "GOOD MORNING"
    g.drawString("GOOD MORNING",155,165);

  }
}

//==================================================================================
