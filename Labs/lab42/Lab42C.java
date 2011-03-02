import java.io.*;
public class Lab42C {
  public static void main(String[] args) {
    // String path = "c:/temp/Lab42C.dat";
    String path = "/Users/dustinchilson/tmp/Lab42C.dat"; // fixed to work on a mac
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream os = new ObjectOutputStream(fos);
      os.writeObject(new String("Java is fun"));
      os.writeObject(new String("Serialization is cool"));
      System.out.println("Objects written to: " + path);
      os.close();
      System.out.println("Closed for output");
      FileInputStream fis = new FileInputStream(path);
      ObjectInputStream is = new ObjectInputStream(fis);
      while (true) {
        System.out.println(is.readObject());
      }
    }
    catch (EOFException err) {
        System.out.println("Closed for input");
    }
    catch (Exception err) {
      System.out.println(err.getMessage());
    }
  }
}

