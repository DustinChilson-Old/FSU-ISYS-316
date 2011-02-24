import java.util.*;
import java.lang.*;
public class Lab40A {
  public static void main(String[] args) {
    Set c = new HashSet();
    for (int i = 1; i <= 3; i++) {
      c.add(i);
    }
    Iterator p = c.iterator();
    int sum = 0;
    while (p.hasNext()) {
      sum += Integer.parseInt(p.next().toString());
    }
    System.out.println("Sum is " + sum);
  }
}

