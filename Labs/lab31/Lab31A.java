//==================================================================================

public class Lab31A {
  public static void main(String[] args) {
    String[] strings = new String[3];
    strings[0] = "Ferris";
    strings[1] = "State";
    try {
        showLengths(strings);
    }
    catch (Exception err) {
        System.out.println(err.getMessage());
    }
    System.out.println("Processing complete");
  }

  public static void showLengths(String[] array) throws Exception {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
            throw new Exception("Varable is Null");
        }

        System.out.println(array[i].length() + " characters in string " + (i+1));
      }
    }
}

