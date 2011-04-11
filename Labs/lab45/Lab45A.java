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

