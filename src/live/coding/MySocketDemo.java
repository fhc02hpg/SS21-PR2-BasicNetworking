package live.coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocketFactory;

public class MySocketDemo {

  public static void main(String[] args) {

    try(Socket s = SSLSocketFactory
              .getDefault().createSocket("news.orf.at", 443);
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(s.getOutputStream()));
        BufferedReader br = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        ) {

        bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n");
        bw.flush(); //!!!!

      String html;
      while((html = br.readLine())!=null) {
        System.out.println(html);
      }

    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}
