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

