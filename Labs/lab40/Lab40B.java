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

