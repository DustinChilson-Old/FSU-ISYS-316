//==================================================================================
//
//   Dustin Chilson
//   Ferris State University
//   ISYS-316-VL1
//
//==================================================================================
import java.io.*;
import java.net.*;
public class Lab44A {
  public static void main(String[] args) {
    int port = 7000;
    try {
      Socket s = new Socket("localhost", port);
      System.out.println("Connected to server");
      InputStreamReader is = new InputStreamReader(s.getInputStream());
      BufferedReader fromServer = new BufferedReader(is);
      PrintWriter toServer = new PrintWriter(s.getOutputStream());
      toServer.println("FSU");
      toServer.flush();
      System.out.println(fromServer.readLine());
      System.out.println(fromServer.readLine());
      System.out.println(fromServer.readLine());
      fromServer.close();
      toServer.close();
      System.out.println("Connection is closed");
    }
    catch(IOException err) {
      System.out.println(err.getMessage());
    }
  }
}

//==================================================================================
import java.io.*;
import java.net.*;
import java.text.*;
public class Lab44B {
  public static void main(String[] args) {
    int port = 4567;
    try {
      ServerSocket ss = new ServerSocket(port);
      System.out.println("Server active");)
      System.out.println("Address: " + InetAddress.getLocalHost());
      System.out.println("Port: " + port);
      while (true) {
        Socket s = ss.accept();
        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader fromClient = new BufferedReader(is);
        PrintWriter toClient = new PrintWriter(s.getOutputStream());
        System.out.println("Client connection in progress");
        String reply;
        do {
          double number = Math.random();
          toClient.println(number);
          toClient.flush();
          System.out.println("Sent: " + number);
          reply = fromClient.readLine();
        } while(!reply.equalsIgnoreCase("STOP"));
        fromClient.close();
        toClient.close();
        System.out.println("Client connection closed");
      }
    }
    catch(IOException err) {
      System.out.println(err.getMessage());
    }
  }
}

//==================================================================================
import java.io.*;
import java.net.*;
import javax.swing.*;
public class Lab44C {
  public static void main(String[] args) {
    int port = 7000;
    try {
      Socket s = new Socket("localhost", port);
      ObjectInputStream fromServer = new InputStreamReader(s.getInputStream());
      System.out.println("Connected to server");
      JFrame frame = (JFrame) fromServer.readObject();
      System.out.println("Frame received from server");
      frame.setVisible(true);
      fromServer.close();
      System.out.println("Connection is closed");
    }
    catch(Exception err) {
      System.out.println(err.getMessage());
    }
  }
}

//==================================================================================
