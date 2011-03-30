import java.io.*;
public class Lab43A {
  public static void main(String[] args) {
    // String path = "c:/temp/cities.txt";
    String path = "/Users/dustinchilson/tmp/cities.txt"; // fixed for mac
    try {
      FileWriter f = new FileWriter(path);
      BufferedWriter b = new BufferedWriter(f);
      b.write("Big Rapids/MI/10,849\n");
      b.write("Fort Collins/CO/118,652\n");
      b.write("Hendersonville/NC/10,420\n");
      b.write("Concord/NH/40,687\n");
      b.write("Chicago/IL/2,896,016\n");
      b.close();
    }
    catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
}

