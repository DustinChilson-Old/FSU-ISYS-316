//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
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

//==================================================================================
import java.util.*;
public class Lab40B {
  public static void main(String[] args) {
    SortedSet mySet = new TreeSet();
    mySet.add(new String("One"));
    mySet.add(new String("Two"));
    mySet.add(new String("Three"));
    System.out.println("There are " + mySet.size() + " objects as follows:");
    Iterator p = mySet.iterator();
    while (p.hasNext()) {
      System.out.println(p.next());
    }
  }
}

//==================================================================================
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

//==================================================================================
