import java.util.*;
import java.lang.*;
public class Lab41C {
  public static void main(String[] args) {
    SortedMap data = new TreeMap();      // CONSTRUCT COLLECTION
    data.put(new Integer(49801), "Iron Mountain");
    data.put(new Integer(49307), "Big Rapids");
    data.put(new Integer(49464), "Zeeland");
    System.out.println("In zip code order:");
    Set zips = data.keySet();       // REFERENCE KEY SET
    Iterator p = zips.iterator();   // CREATE ITERATOR OVER KEY SET
    while (p.hasNext()) {
      int zip = ((Integer)data.get(p.next())).intValue();              // GET ZIP CODE
      String city = (String)data.get(new Integer(zip));  // FIND CITY
      System.out.println(zip + " - " + city);
    }
  }
}
