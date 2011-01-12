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

