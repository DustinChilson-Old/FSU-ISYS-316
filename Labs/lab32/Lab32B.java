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

