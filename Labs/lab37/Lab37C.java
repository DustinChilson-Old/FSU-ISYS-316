import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class Lab37C {
  JFrame frame;
  JPanel panel;
  JComboBox selection;
  JLabel message;
  String[] doors = {"Door 1", "Door 2", "Door 3"};
  int prizeIndex;
  public static void main(String[] args) {
    Lab37C me = new Lab37C();
    me.go();
  }
  public void go() {
    frame = new JFrame("Pick door - win prize");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    hidePrize();
    panel = new JPanel();
    panel.add(new JLabel("Selection"));
    selection = new JComboBox(doors);
    selection.setSelectedIndex(0);
    selection.addActionListener(new SelectionListener());
    selection.setBackground(Color.white);
    panel.add(selection);
    frame.getContentPane().add(panel, BorderLayout.NORTH);
    message = new JLabel("Pick a door");
    message.setForeground(Color.red);
    message.setFont(new Font("Serif", Font.PLAIN, 18));
    message.setHorizontalAlignment(JLabel.CENTER);
    frame.getContentPane().add(message);
    frame.setVisible(true);
  }
  private void hidePrize() {
    prizeIndex = (int)((Math.random() * 10) % 3);
  }
  public class SelectionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (selection.getSelectedIndex() == prizeIndex) {
        message.setText("You WIN a MONKEY!! Game over.");
        selection.setEnabled(false);
      }
      else {
        selection.insertItemAt("Empty", selection.getSelectedIndex());
        selection.removeItemAt(selection.getSelectedIndex());
        message.setText("Sorry, you lose. Try again.");
      }
    }
  }
}

