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

