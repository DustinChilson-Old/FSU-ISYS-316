//=========================================================================

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
        System.out.println(err.getMessage());
      }
    }
  }

  public static int readInt() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(br.readLine());
  }
}

