//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.io.*;
public class Lab42A {
  public static void main(String[] args) {
    // String path = "c:/temp/Lab42A.dat";
    String path = "/Users/dustinchilson/tmp/Lab42A.dat"; // fixed to work on a mac
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream os = new ObjectOutputStream(fos);
      os.writeObject(new Hello());
      System.out.println("Object written to: " + path);
      os.close();
      System.out.println("Closed for output");
    }
    catch (IOException err) {
      System.out.println("An I/O error has occurred");
    }
  }
}
class Hello implements Serializable {
    public String Hello(){
        return "Hello World!";
    }
}

//==================================================================================
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

//==================================================================================
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

//==================================================================================
