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

