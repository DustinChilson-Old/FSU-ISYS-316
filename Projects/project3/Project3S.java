//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
//    _____                          
//   / ___/___  ______   _____  _____
//   \__ \/ _ \/ ___/ | / / _ \/ ___/
//  ___/ /  __/ /   | |/ /  __/ /    
// /____/\___/_/    |___/\___/_/     
//==================================================================================
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
import java.lang.*;
public class Project3S {
  public static void main(String[] args) {
    int port = 7000;
    int endNum = 0;
    int count = 0;

    try {
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Server active");
      System.out.println("Address: " + InetAddress.getLocalHost());
      System.out.println("Port: " + port);
      while (true) {
        Socket s = ss.accept();
        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader fromClient = new BufferedReader(is);
        PrintWriter toClient = new PrintWriter(s.getOutputStream());
        System.out.println("Client connection in progress");
        int input = Integer.parseInt(fromClient.readLine());
        endNum += input;
        count ++;
        System.out.println("Client Sent: " + input);
        
        if (input == -1) {
            endNum = 0;
            count = 0;
            System.out.println("Reset Values!");
        } else {
            if (input % 2 == 0) {
                toClient.println("Thanks for the Positive Number!");
                toClient.flush();
                toClient.println(" ");
                toClient.flush();
            }
            else {
                double avg = endNum / count;
                System.out.println("The Average is: " + avg);
                toClient.println("The Average is: " + avg);
                toClient.flush();
                toClient.println("Goodbye!");
                toClient.flush();
                
                fromClient.close();
                toClient.close();
            }
        }
      }
    }
    catch(IOException err) {
      System.out.println(err.getMessage());
    }
  }
}
