public class Lesson45A {
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    for (int i = 1; i <= 100; i++) {
      System.out.println("Main Thread: Running");
    }
  }
}
class MyThread extends Thread {
  public void run() {
    for (int i = 1; i <= 100; i++) {
      System.out.println("Sub Thread: " + i);
    }
  }
}
