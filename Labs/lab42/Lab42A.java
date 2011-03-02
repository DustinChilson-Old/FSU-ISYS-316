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

