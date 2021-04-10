package live.coding;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

  public static void main(String[] args) {

    System.out.println("server starting on port 1111");
    try(ServerSocket ss = new ServerSocket(1111)) {
      while(true) {
        System.out.println("waiting for clients...");
        try(Socket client = ss.accept();
            BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream())
            )
        ) {
          LocalDateTime ldt = LocalDateTime.now();
          System.out.println("sending date time to client "+ldt.toString());
          bw.write(ldt.toString());
          bw.newLine(); //!!!
          bw.flush(); //!!!
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
