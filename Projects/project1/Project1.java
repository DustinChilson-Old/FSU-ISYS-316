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
import javax.swing.event.*;
import java.text.DecimalFormat;

public class Project1 {
  JFrame frame;
  JRadioButton priceP, priceS, priceM, priceL, priceN; 
  JCheckBox pepperoni, sausage, cheese;
  JLabel sizes, topping, blank, totalL, totalT, multiL;
  JPanel sizeGrid, toppingGrid, multiGrid, mainGrid, finalGrid, totalGrid;
  JSlider multiS;
  
  int multiple;
  double endTotal;
  DecimalFormat df = new DecimalFormat("$#.##");
  ButtonGroup prices;

  public static void main(String[] args) {
    Project1 me = new Project1();
    me.go();
  }
  public void go() {
    frame = new JFrame("Pizza Order Form");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    
    // =======================================
    // Checkboxes for sizes
    // =======================================
    // Pizza Sizes
    sizes = new JLabel("Pizza Sizes");
    // None
    priceN = new JRadioButton("  $0.00 - None", true);
    priceN.addItemListener(new SizeListener());
    // Pan Size
    priceP = new JRadioButton("  $9.99 - Pan");
    priceP.addItemListener(new SizeListener());
    // Small Size
    priceS = new JRadioButton("  $5.99 - Small");
    priceS.addItemListener(new SizeListener());
    // Medium Size
    priceM = new JRadioButton("  $8.99 - Medium");
    priceM.addItemListener(new SizeListener());
    // Large Size
    priceL = new JRadioButton("$10.99 - Large");
    priceL.addItemListener(new SizeListener());
    // Grid layout to show sizes
    sizeGrid = new JPanel (new GridLayout (6, 1));
    sizeGrid.add(sizes);
    sizeGrid.add(priceN);
    sizeGrid.add(priceP);
    sizeGrid.add(priceS);
    sizeGrid.add(priceM);
    sizeGrid.add(priceL);
    // Group radiobuttons
    prices = new ButtonGroup();
    prices.add(priceN);
    prices.add(priceP);
    prices.add(priceS);
    prices.add(priceM);
    prices.add(priceL);
    // ========================================
    
    // ========================================
    // Toppings
    // ========================================
    // Label
    topping = new JLabel("Toppings");
    // Pepperoni
    pepperoni = new JCheckBox("$.75 - Pepperoni");
    pepperoni.addItemListener(new SizeListener());
    // Sausage
    sausage = new JCheckBox("$.75 - Sausage");
    sausage.addItemListener(new SizeListener());
    // Extra Cheese
    cheese = new JCheckBox("$.75 - Extra Cheese");
    cheese.addItemListener(new SizeListener());
    // Blank Space
    blank = new JLabel(" ");
    // Topping Grid
    toppingGrid = new JPanel (new GridLayout (5, 1));
    toppingGrid.add(topping);
    toppingGrid.add(pepperoni);
    toppingGrid.add(sausage);
    toppingGrid.add(cheese);
    toppingGrid.add(blank);
    // ========================================

    // ========================================
    // Total Display 
    // ========================================
    // Total Label
    totalL = new JLabel("Total: ", JLabel.RIGHT);
    totalL.setFont(new Font("Serif", Font.PLAIN, 24));
    // Total TextBox
    totalT = new JLabel("$0", JLabel.LEFT);
    totalT.setFont(new Font("Serif", Font.PLAIN, 24));
    totalT.setForeground(Color.red);
    // ========================================
    
    // ========================================
    // Multiplier
    // ========================================
    // Lable
    multiL = new JLabel("Number of Pizzas: ", JLabel.LEFT);
    // Slider
    multiS = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
    multiS.addChangeListener(new multiChangeListener());
    multiS.setMajorTickSpacing(10);
    multiS.setMinorTickSpacing(1);
    multiS.setPaintTicks(true);
    multiS.setPaintLabels(true);
    // Grid
    multiGrid = new JPanel (new GridLayout (2, 1));
    multiGrid.add(multiL);
    multiGrid.add(multiS);
    // ========================================
    
    // ========================================
    // Main grid
    // ========================================
    mainGrid = new JPanel (new GridLayout (1, 2));
    mainGrid.add(sizeGrid);
    mainGrid.add(toppingGrid);
    // ========================================
   
    // ========================================
    // Total grid
    // ========================================
    totalGrid = new JPanel (new GridLayout (1, 2));
    totalGrid.add(totalL);
    totalGrid.add(totalT);
    // ========================================
    
    // ========================================
    // Final grid
    // ========================================
    finalGrid = new JPanel (new GridLayout(2,1));
    finalGrid.add(mainGrid);
    finalGrid.add(multiGrid);
    // ========================================

    // ========================================
    // Create Interface
    // ========================================
    frame.getContentPane().add(finalGrid, BorderLayout.CENTER);
    frame.getContentPane().add(totalGrid, BorderLayout.SOUTH);
    frame.setVisible(true);
    // ========================================
  }
  
  public void calc(){
        // ========================================
        // Changes the Total
        // ========================================
        endTotal = 0;
        multiple = multiS.getValue();

        if (priceP.isSelected()) {
            endTotal = endTotal + 9.99;
        } else if (priceS.isSelected()) {
            endTotal = endTotal + 5.99;
        } else if (priceM.isSelected()) {
            endTotal = endTotal + 8.99;
        } else if (priceL.isSelected()) {
            endTotal = endTotal + 10.99;
        } else if (priceN.isSelected()) {
            endTotal = endTotal + 0.00;
        }
        
        if (pepperoni.isSelected()) {
            endTotal = endTotal + .75;
        }
        if (sausage.isSelected()) {
            endTotal = endTotal + .75;
        }
        if (cheese.isSelected()) {
            endTotal = endTotal + .75;
        }

        endTotal = (endTotal*multiple) * 1.06;
        totalT.setText(String.valueOf(df.format(endTotal)));

  }
  class SizeListener implements ItemListener {
    public void itemStateChanged(ItemEvent e) {
        calc();
    }
  }
  class multiChangeListener implements ChangeListener {
    public synchronized void stateChanged(ChangeEvent e) {
      calc();
    }
  }
  
}

