//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.io.*;
import java.util.*;

public class Project2B {
  public static void main(String[] args) {
    // private String path = "c:/temp/grades.txt";
    String path = "/Users/dustinchilson/tmp/grades.txt"; // fixed for mac
    String className;
    int honor;
    int totalCredits = 0;
    int totalHonor = 0;
    int credits;
    int classGPA;
    int totalGPA;
    String grade;
    String hr = "-----------------------------------------------------------------------------------------";
   
    try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      
      // Create Header for table
      Project2B.header(hr);
      
      while (line != null) {
        StringTokenizer parser = new StringTokenizer(line, "/");
        ArrayList fields = new ArrayList();
        while (parser.hasMoreTokens()) {
          fields.add(parser.nextToken());
        }

        // Pull Tokens into Variables - Easier to read
        className = (String)fields.get(0);
        credits = Integer.parseInt((String)fields.get(1));
        grade = ((String)fields.get(2)).toLowerCase();
        
        // Calculate the honor points for this row
        honor = Project2B.honorCalc(credits, grade);

        // Calculate the GPA for this row
        classGPA = Project2B.GPA(credits, honor);
        
        // Create totals for cumulative calculation
        totalCredits = totalCredits + credits;
        totalHonor = totalHonor + honor;
        
        // Print Info for each Class
        Project2B.printRow(className, grade, credits, honor, classGPA);

        line = br.readLine();
      }

      // Calculate Cumulative GPA
      totalGPA = Project2B.GPA(totalCredits, totalHonor );
      
      // Create Footer for table
      Project2B.footer(hr, totalCredits, totalHonor, totalGPA);

      br.close();
    }
    catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
  // Caluclates Honor Points
  // TODO: Convert this to use doubles to handle partial grades (ex. A+,C-)
  public static int honorCalc(int credits, String grade) {
    int honor = 0;
    if (grade.equals("a")) {
      honor = 4 * credits; 
    } else 
    if (grade.equals("b")) {
      honor = 3 * credits; 
    } else 
    if (grade.equals("c")) {
      honor = 2 * credits; 
    } else 
    if (grade.equals("d")) {
      honor = 1 * credits; 
    } else 
    if (grade.equals("e")) {
      honor = 0 * credits; 
    }
    return honor;
  }
  // Calculates GPA
  // TODO: Convert this to use doubles to handle partial grades (ex. A+,C-)
  public static int GPA(int credits, int honor) {
    int GPA = honor / credits;
    return GPA;
  }
  // Print Table Row
  public static void printRow(String className, String grade, int credits, int honor, int classGPA) {
    System.out.println("\t|\t" +
        className + "\t|\t" + 
        grade.toUpperCase() + "\t|\t" +
        credits + "\t|\t" + 
        honor + "\t|\t" +
        classGPA + "\t|\t"
    );
  }
  // Prints a header for the table
  public static void header(String line) {
    System.out.println("\t" + line);
    System.out.println("\t" +
      "|\t Class\t\t|     Grade\t|    Credits\t|   Honor Pts\t|      GPA\t|"
    );
    System.out.println("\t" + line);
  }
  // Prints the Cumulative figures and a footer for the table
  public static void footer(String line, int totalCredits, int totalHonor, int totalGPA) {
    System.out.println("\t" + line);
    System.out.println("\t" +
        "|\t\t\t\tTotal\t|\t"+ 
        totalCredits + "\t|\t" +
        totalHonor + "\t|\t" + 
        totalGPA + "\t|\t");
    System.out.println("\t" + line);
  }
}

