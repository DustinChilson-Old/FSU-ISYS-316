//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
public class Lab45A {
  public static void main(String[] args) {
    Countdown t = new Countdown();
    t.start();
    while (t.isAlive()) {
      System.out.println("Waiting...");
    }
    System.out.println("We have lift-off!");
  }
}
class Countdown extends Thread {
  public void run() {
    for (int i = 10; i > 0; i--) {
      System.out.println(i);
    }
    System.out.println("ZERO!!!");
  }
}

//==================================================================================
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

//==================================================================================
public class Lab45C {
  public static void main(String[] args) {
    System.out.println("Press ENTER to start displaying garbage");
    System.out.println("Press ENTER again to stop");
    waitForEnter();
    GarbageOut g = new GarbageOut();  // CREATE SUBTHREAD
    g.start();                        // START SUBTHREAD
    waitForEnter();
    g.kill();                        // KILL SUBTHREAD
    System.out.println("\n" + "DONE");
  }
  public static void waitForEnter() {
    try {
      System.in.read();
      System.in.skip(System.in.available());
    }
    catch (Exception err) {}
  }
}
class GarbageOut extends Thread {
  private String alphabet = "abcdefghijklmnopqrstuvwxyz";
  private boolean alive;
  public void run() {             // THREAD PROCESSING
    alive = true;
    while (alive) {
      int wordLength = (int)(Math.random()*10);
      for (int i = 1; i <= wordLength; i++) {
        int index = ((int)(Math.random()*100000)) % 26;
        System.out.print(alphabet.charAt(index));
      }
      System.out.println("");
    }
  }
  public void kill() {                    // KILL THREAD PROCESSING
    alive = false;
  }
}

//==================================================================================
