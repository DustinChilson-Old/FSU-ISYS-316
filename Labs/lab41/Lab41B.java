import java.util.*;
public class Lab41B {
  public static void main(String[] args) {
    Map states = new HashMap();
    states.put("CT", "Connecticut");
    states.put("AZ", "Arizona");
    states.put("IA", "Iowa");
    states.put("NM", "New Mexico");
    states.remove("IA");                     // REMOVE IOWA
    Set stateCodes = states.keySet();   // GET THE KEY SET
    Iterator p = stateCodes.iterator();   // CREATE KEY SET ITERATOR
    while (p.hasNext()) {
      System.out.println(p.next());
    }
  }
}

