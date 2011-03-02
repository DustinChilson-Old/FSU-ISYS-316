//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.util.*;
public class Lab41A {
  public static void main(String[] args) {
    Map states = new HashMap();
    states.put("CT", "Connecticut");
    states.put("AZ", "Arizona");
    states.put("IA", "Iowa");
    states.put("NM", "New Mexico");
    String stateCode = "CT";
    if (states.containsKey(stateCode)) {
      String stateName = (String) states.get(stateCode);
      System.out.println(stateCode + " - " + stateName);
    }
    else {
      System.out.println("Invalid state code: " + stateCode);
    }
  }
}

//==================================================================================
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

//==================================================================================
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
//==================================================================================
