public class Lab46C {
  public static void main(String[] args) {
    Sub t1 = new Sub();
    t1.start();
    for (int i = 1; i <= 1000; i++) {
      t1.setPriority(Thread.MAX_PRIORITY); // YOUR CODE GOES HERE
    }
    System.out.println("Main is done");
  }
}
class Sub extends Thread {
  public void run() {
    for (int i = 1; i <= 1000; i++) {
    }
    System.out.println("Sub is done");
  }
}

