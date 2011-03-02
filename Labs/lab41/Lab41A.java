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

