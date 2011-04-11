public class Lab45B {
  public static void main(String[] args) {
    ArrayBuilder t = new ArrayBuilder();
    t.start();                      // LAUNCH SUBTHREAD
    while (t.isAlive()) {           // LOOP WHILE SUBTHREAD LIVES
      System.out.println("Waiting...");
    }
    System.out.println("Resulting array contents: ");
    double[] result = t.getArray();    // GET GENERATED ARRAY
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
class ArrayBuilder extends Thread {
  double[] array = new double[10];
  public void run() {             // THREAD PROCESSING
    for (int i = 0; i < array.length; i++) {
      System.out.println("Loading array");
      array[i] = Math.random();
    }
  }
  public double[] getArray() {            // RETURN GENERATED ARRAY
    return array;
  }
}

