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

