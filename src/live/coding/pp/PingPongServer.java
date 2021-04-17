package live.coding.pp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

  public static void main(String[] args) {

    System.out.println("starting server on port 3333");

    try(ServerSocket serverSocket = new ServerSocket(3333)) {
      while(true) {
        System.out.println("waiting for next client...");
        Socket s = serverSocket.accept();
        Thread clientThread = new Thread(new PingPongHandler(s));
        System.out.println("  - starting client thread");
        clientThread.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
