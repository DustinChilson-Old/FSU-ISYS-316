public class Lab47B {
  public static void main(String[] args) {
    Bit theBit = new Bit();
    Flipper f1 = new Flipper(theBit);
    Flipper f2 = new Flipper(theBit);
    f1.start();
    f2.start();
    System.out.println("Please wait for one second...");
    try {
      Thread.sleep(1000);
    }
    catch (InterruptedException e) {}
    f1.kill();
    f2.kill();
    System.out.println("Final bit value: " + theBit.getValue());
  }
}
class Flipper extends Thread {
  private Bit theBit;
  boolean isAlive;
  public Flipper(Bit bit) {
    theBit = bit;
    isAlive = true;
  }
  public void run() {
    while (isAlive) {
      theBit.flip();
    }
  }
  public void kill() {
    isAlive = false;
  }
}
class Bit {
  private int value;
  public void flip() {
    if (value == 0)
      value += 1;
    else
      value -= 1;
  }
  public synchronized int getValue() {
    return value;
  }
}

