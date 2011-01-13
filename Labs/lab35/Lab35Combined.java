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

//==================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab35B implements ActionListener {
  JFrame frame;
  JButton random;
  JButton clear;
  MyPanel panel;

  public static void main(String[] args) {
    Lab35B me = new Lab35B();
    me.go();
  }

  public void go() {
    frame = new JFrame("Color display");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);

    random = new JButton("Random color");
    random.addActionListener(this);
    frame.getContentPane().add(random, BorderLayout.NORTH);

    clear = new JButton("Clear");
    clear.addActionListener(this);
    frame.getContentPane().add(clear, BorderLayout.SOUTH);

    panel = new MyPanel();
    frame.getContentPane().add(panel);

    frame.setVisible(true);
  }

  class MyPanel extends JPanel {
    Color color = Color.white;

    public void paintComponent(Graphics g) {
      g.setColor(color);
      g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void clear() {
      color = Color.white;
      repaint();
    }

    public void random() {
      int red = (int) (Math.random() * 250);
      int green = (int) (Math.random() * 250);
      int blue = (int) (Math.random() * 250);
      color = new Color(red, green, blue);
      repaint();
    }
  }

  // YOUR CODE GOES HERE
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(random)) {
            panel.random();
        }
        else if (e.getSource().equals(clear)) {
            panel.clear();
        }
    }

}

//==================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Lab35C {
  JFrame frame;
  JButton green;
  JButton red;
  Dot dot;
  public static void main(String[] args) {
    Lab35C me = new Lab35C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Watch the dot");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    green = new JButton("Green dot");

    // REGISTER LISTENER
    // ADD TO TOP OF FRAME
    green.addActionListener(new GreenListener());
    frame.getContentPane().add(green, BorderLayout.NORTH);

    red = new JButton("Red dot");

    // REGISTER LISTENER
    // ADD TO BOTTOM OF FRAME
    red.addActionListener(new RedListener());
    frame.getContentPane().add(red, BorderLayout.SOUTH);

    dot = new Dot();
    frame.getContentPane().add(dot);
    frame.setVisible(true);
    while (true) {
      dot.repaint();
      try {
        Thread.sleep(50);
      }
      catch (Exception err) {}
    }
  }
  class Dot extends JPanel {
    Color color = Color.blue;
    public void paintComponent(Graphics g) {
      int height = this.getHeight();
      int width = this.getWidth();
      g.setColor(Color.white);
      g.fillRect(0, 0, width, height);
      g.setColor(color);
      int randomX = (int) (Math.random() * width);
      int randomY = (int) (Math.random() * height);
      g.fillOval(randomX, randomY, 30, 30);
    }
    public void changeColor(Color nColor) {
      color = nColor;
    }
  }
  class GreenListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      dot.changeColor(Color.green);
    }
  }
  class RedListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      dot.changeColor(Color.red);
    }
  }
}

//==================================================================================
