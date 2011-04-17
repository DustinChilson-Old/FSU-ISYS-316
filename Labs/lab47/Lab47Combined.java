//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
public class Lab47A {
  public static void main(String[] args) {
    Alphabet alpha = new Alphabet();
    Speller s1 = new Speller(alpha);
    Speller s2 = new Speller(alpha);
    s1.start();
    s2.start();
    while (s1.isAlive() || s2.isAlive()) {
    }
    System.out.println("Alphabet: " + alpha.getText());
  }
}
class Speller extends Thread {
  Alphabet alpha;
  public Speller(Alphabet a) {
    alpha = a;
  }
  public void run() {
    while (alpha.getLastChar() < 'z') {
      alpha.setNextChar();
    }
  }
}
class Alphabet {
  StringBuffer text;
  public Alphabet() {
    text = new StringBuffer("a");
  }
  public char getLastChar() {
    return text.charAt(text.length() - 1);
  }
  public void setNextChar() {
    char last = getLastChar();
    if (last != 'z') {
      char next = (char)(last + 1);
      System.out.println("Storing: " + next);
      text.append(next);
    }
  }
  public synchronized String getText() {
    return text.toString();
  }
}

//==================================================================================
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

//==================================================================================
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

//==================================================================================
