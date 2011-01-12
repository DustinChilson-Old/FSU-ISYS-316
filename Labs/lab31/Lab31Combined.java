//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
public class Lab31A {
  public static void main(String[] args) {
    String[] strings = new String[3];
    strings[0] = "Ferris";
    strings[1] = "State";
    try {
        showLengths(strings);
    }
    catch (Exception err) {
        System.out.println(err.getMessage());
    }
    System.out.println("Processing complete");
  }

  public static void showLengths(String[] array) throws Exception {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
            throw new Exception("Varable is Null");
        }

        System.out.println(array[i].length() + " characters in string " + (i+1));
      }
    }
}

//==================================================================================
import java.io.*;
public class Lab31B {
  public static void main(String[] args) {
    int x = 0;
    while (x != 999) {
      System.out.print("Enter an integer value or 999 to exit: ");
      try {
        x = readInt();
        if (x != 999) {
            System.out.println("You entered: " + x);
        } else {
            System.out.println("Goodbye...");
        }
      } 
      catch (Exception err) {
        System.out.println("Invalid Input");
      }
    }
  }

  public static int readInt() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(br.readLine());
  }
}

//==================================================================================
public class Lab31C {
  public static void main(String[] args) {
    double radius = -2.5;
    try {
      System.out.println("Perimeter: " + perimeter(radius));
    }
    catch (Exception err) {
      System.out.println(err.getMessage());
    }
    System.out.println("Processing complete");
  }

  public static double perimeter(double r) throws Exception{
    if (r <= 0) {
        throw new Exception("You've GOT to be kidding!");
    }
    return 2 * Math.PI * r;
  }
}

//==================================================================================
