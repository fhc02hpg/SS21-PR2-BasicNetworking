package live.coding;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServerSocket {

  public static void main(String[] args) {

    try {
      System.out.println("starting server on port 2345");
      ServerSocket serverSocket = new ServerSocket(2345);
      while(true) {
        System.out.println("waiting for clients...");
        Socket clientConnection = serverSocket.accept();
        //mit einem client kommunizieren

        //fertig mit diesem client!
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
