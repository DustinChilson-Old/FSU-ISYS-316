import java.io.*;
public class Lab42B {
  public static void main(String[] args) {
    // String path = "c:/temp/Lab42B.dat";
    String path = "/Users/dustinchilson/tmp/Lab42B.dat"; // fixed to work on a mac
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream os = new ObjectOutputStream(fos); // ObjectOutputStream
      os.writeObject(new String("Java Rules"));
      os.writeObject(new StringBuffer(".NET Drools"));
      os.writeObject(new Double("201.79"));
      System.out.println("Objects written to: " + path);
      os.close();
      System.out.println("Closed for output");
      FileInputStream fis = new FileInputStream(path); // FileInputStream
      ObjectInputStream is = new ObjectInputStream(fis);
      String s = (String)is.readObject();
      System.out.println(s);
      StringBuffer sb = (StringBuffer)is.readObject();
      System.out.println(sb.toString());
      Double d = (Double)is.readObject();
      System.out.println(d.doubleValue());
      is.close();
      System.out.println("Closed for input");
    }
    catch (Exception err) {                          // Catch ALL Exceptions
      System.out.println(err.getMessage());
    }
  }
}

