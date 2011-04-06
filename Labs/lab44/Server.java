import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;
public class Server {
  public static void main(String[] args) {
    int port = 7000;
    int loginNum = 0;
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
        String login = fromClient.readLine();
        if (login.equalsIgnoreCase("FSU")) {
          loginNum++;
          System.out.println("Client login " + loginNum + " accepted");
          toClient.println("Welcome to the date/time server!");
          toClient.flush();
          toClient.println("Your login number is: " + loginNum);
          toClient.flush();
          DateFormat df = DateFormat.getDateTimeInstance();
          Date now = new Date(System.currentTimeMillis());
          toClient.println("Current date/time is: " + df.format(now));
          toClient.flush();
          System.out.println("Client data transmitted");
        }
        else {
          toClient.println("Invalid login");
          toClient.flush();
          System.out.println("Client login rejected");
        }
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

