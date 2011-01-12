//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
public class Lab32A {
  public static void main(String[] args) {
    String x = null;
    try {
        System.out.println("Length of string: " + x.length());
        System.out.println("Second character: " + x.charAt(1));
    }
    catch (Exception err){
        System.out.println("I can't do that.");
    }
    finally {
        System.out.println("The danger is passed.");
    }
  }
}

//==================================================================================
public class Lab32B {
  public static void main(String[] args) {
    try {
        String radiusAsString = "$1.75";
        double radius = Double.parseDouble(radiusAsString);
        double area = Math.PI * radius * radius;
        System.out.println("Area is " + area);
    }
    catch (NumberFormatException err){
        System.out.println("Not a Number");
    }
    catch (Exception err) {
        System.out.println("Uh...Something went wrong.");
    }
    finally {
        System.out.println("Bye-Bye");
    }
  }
}

//==================================================================================
public class Lab32C {
  public static void main(String[] args) throws Exception {
    System.out.println("I'll be back in 3 seconds...");
    Thread.sleep(3000);
    System.out.println("OK. I'm back!");
  }
}

//==================================================================================
