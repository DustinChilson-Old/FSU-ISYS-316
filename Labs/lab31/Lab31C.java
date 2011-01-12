public class Lab31C {
  public static void main(String[] args) {
    double radius = -2.5;
    try {
      System.out.println("Perimeter: " + perimeter(radius));
    }
    catch (Exception err) {
      System.out.println(err.getMessage());
    }
    System.out.println("Processing complete");
  }

  public static double perimeter(double r) throws Exception{
    if (r <= 0) {
        throw new Exception("You've GOT to be kidding!");
    }
    return 2 * Math.PI * r;
  }
}

