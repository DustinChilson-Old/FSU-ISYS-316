import java.util.*;
public class Lab40C {
  public static void main(String[] args) {
    List myList = new LinkedList();
    myList.add("One");
    myList.add("Two");
    myList.add("Three");
    for (int i = myList.size() - 1; i >= 0; i--) {
      System.out.println(myList.get(i));
    }
  }
}

