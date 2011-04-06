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

