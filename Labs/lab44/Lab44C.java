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

