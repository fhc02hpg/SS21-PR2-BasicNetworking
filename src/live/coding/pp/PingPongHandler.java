package live.coding.pp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class PingPongHandler implements Runnable {

  private Socket client;

  public PingPongHandler(Socket client) {
    this.client = client;
  }

  @Override
  public void run() {
    processClient();
  }

  private void processClient() {
    try(
        BufferedReader br = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(client.getOutputStream()));
    ) {
      String line;
      while((line = br.readLine())!=null) {
        System.out.println(" --> received: "+line);
        switch (line) {
          case "ping":
            System.out.println(" <-- sending pong");
            bw.write("pong");
            break;
          case "pong":
            System.out.println(" <-- sending ping");
            bw.write("ping");
            break;
          default:
            System.out.println(" <-- sending error");
            bw.write("error");
        }
        bw.newLine();
        bw.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
