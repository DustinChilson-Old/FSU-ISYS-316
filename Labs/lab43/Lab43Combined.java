//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
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

//==================================================================================
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

//==================================================================================
import java.io.*;
public class Lab43C {
  public static void main(String[] args) {
    // String path = "C:/temp/"
    String path = "/Users/dustinchilson/tmp/"; // fixed for mac
    FileReader fd1 = new FileReader(path+"cities.txt");
    FileWriter fd2 = new FileWriter(path+"cities2.txt");
    System.out.println(fd1.getName() + " has " + fd1.length() + " bytes");
    fd1.renameTo(fd2);
    System.out.println("Pathname is now: " + fd2.getPath());
  }
}

//==================================================================================
