package live.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

  public static void main(String[] args) {

    System.out.println("connecting to server localhost:1111");
    try(Socket s = new Socket("localhost",1111);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()))
    ) {

      String datetime = br.readLine();
      System.out.println(datetime);

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("time client exiting");

  }

}
