//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
//    _________             __ 
//   / ____/ (_)___  ____  / /_
//  / /   / / // _ \/ __ \/ __/
// / /___/ / //  __/ / / / /_  
// \____/_/_/ \___/_/ /_/\__/  
//==================================================================================
import java.io.*;
import java.net.*;
public class Project3C {
  public static void main(String[] args) {
    int port = 7000;
    int input = 0;
    String output;
    boolean cleanUp = false;
    boolean done = false;

    try {
      while(done == false) {
          Socket s = new Socket("localhost", port);
          if (input == 0) {
              System.out.println("Connected to server");
          }
          InputStreamReader is = new InputStreamReader(s.getInputStream());
          BufferedReader fromServer = new BufferedReader(is);
          PrintWriter toServer = new PrintWriter(s.getOutputStream());

          if (cleanUp == true) {
            input = -1;
            done = true;
            
            toServer.println(input);
            toServer.flush();
            fromServer.close();
            toServer.close();
            System.out.println("Connection is closed");
            System.exit(0);
          } else {
            System.out.println("Enter a number:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = Integer.parseInt(br.readLine());
          
            toServer.println(input);
            toServer.flush();
          
            output = fromServer.readLine();
            System.out.println(output);

            output = fromServer.readLine();
            System.out.println(output);
            
            if (output.equals("Goodbye!")) {
              cleanUp = true;
            }
          }
       }
    }
    catch(IOException err) {
      System.out.println(err.getMessage());
    }
  }
}
