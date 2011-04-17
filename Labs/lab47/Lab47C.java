public class Lab47C {
  public static void main(String[] args) {
    Paper thePaper = new Paper();
    Pen thePen = new Pen();
    Student s1 = new Student("George", thePaper, thePen);
    Student s2 = new Student("Laura", thePaper, thePen);
    s1.start();
    s2.start();
    while (s1.isAlive() || s2.isAlive()) {}
    System.out.println("DONE");
  }
}
class Student extends Thread {
  private String me;
  private Paper paper;
  private Pen pen;
  public Student(String myName, Paper thePaper, Pen thePen) {
    me = myName;
    paper = thePaper;
    pen = thePen;
  }
  public void run() {
    for (int i = 1; i <= 5; i++) {
      if (Math.random() > .5) {       // Sometimes they grab for the pen first
        while (!pen.getOwner().equals(me)) {
          pen.obtainFor(me);
        }
        while (!paper.getOwner().equals(me)) {
          paper.obtainFor(me);

          if (!paper.getOwner().equals(me)) {
              pen.release(); // YOUR STATEMENTS GO HERE
          }

        }
      }
      else {                          // Sometimes they grab for the paper first
        while (!paper.getOwner().equals(me)) {
          paper.obtainFor(me);
        }
        while (!pen.getOwner().equals(me)) {
          pen.obtainFor(me);
        }
      }
      System.out.println("Written by: " + me);
      pen.release();
      paper.release();
    }
  }
}
class Paper {
  String owner;
  public Paper() {
    owner = "none";
  }
  public void obtainFor(String name) {
    if (owner.equals("none")) {
      owner = name;
    }
  }
  public void release() {
    owner = "none";
  }
  public String getOwner() {
    return owner;
  }
}
class Pen {
  String owner;
  public Pen() {
    owner = "none";
  }
  public void obtainFor(String name) {
    if (owner.equals("none")) {
      owner = name;
    }
  }
  public void release() {
    owner = "none";
  }
  public String getOwner() {
    return owner;
  }
}

