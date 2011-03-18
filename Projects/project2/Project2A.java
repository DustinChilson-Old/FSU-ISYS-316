//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.io.*;
public class Project2A {
  public static void main(String[] args) {
    // String path = "c:/temp/grades.txt";
    String path = "/Users/dustinchilson/tmp/grades.txt"; // fixed for mac
    try {
      FileWriter f = new FileWriter(path);
      BufferedWriter b = new BufferedWriter(f);
      b.write("ISYS-216/3/B\n");
      b.write("ISYS-316/3/A\n");
      b.write("ENGL-150/3/D\n");
      b.write("BIOL-103/4/B\n");
      b.write("FSUS-100/1/C\n");
      b.write("MATH-110/4/B\n");
      b.write("ISYS-491/6/B\n");
      b.write("COMM-121/3/A\n");
      b.write("FINC-322/3/B\n");
      b.write("ENGL-325/3/A\n");
      
      b.close();
    }
    catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
}

