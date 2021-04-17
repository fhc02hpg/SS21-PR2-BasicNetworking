package live.coding.pp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongClient {

  public static void main(String[] args) {

    System.out.println("starting ping pong client");

    try(Socket s = new Socket("localhost",3333);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        BufferedReader cli = new BufferedReader(new InputStreamReader(System.in));
    ) {
      System.out.println("connected to ping pong server");
      String cmd;
      while((cmd = cli.readLine())!=null) {
        if(cmd.equalsIgnoreCase("quit")) {
          System.out.println("user wants to exit");
          break;
        }
        //write command
        System.out.println(" <-- sending "+cmd);
        bw.write(cmd);
        bw.newLine();
        bw.flush();
        //read response
        String response = br.readLine();
        System.out.println(" --> received "+response);
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("exiting ping pong client");
  }

}
