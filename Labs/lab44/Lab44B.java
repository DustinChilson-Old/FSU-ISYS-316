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

