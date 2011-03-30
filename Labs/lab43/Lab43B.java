import java.io.*;
import java.util.*;
public class Lab43B {
  public static void main(String[] args) {
    // String path = "c:/temp/cities.txt";
    String path = "/Users/dustinchilson/tmp/cities.txt"; // fixed for mac
    try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        StringTokenizer parser = new StringTokenizer(line, "/");
        ArrayList fields = new ArrayList();
        while (parser.hasMoreTokens()) {
          fields.add(parser.nextToken());
        }
        System.out.println(fields.get(0) + ": " + fields.get(2));
        line = br.readLine();
      }
      br.close();
    }
    catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
}

