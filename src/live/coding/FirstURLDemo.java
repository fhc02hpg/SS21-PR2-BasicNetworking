package live.coding;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstURLDemo {

  public static void main(String[] args) {

    try {
      URL myUrl = new URL("https://en.wikipedia.org/wiki/Secretary_of_State_for_Protestant_Affairs");

      try (BufferedReader br =
          new BufferedReader(
            new InputStreamReader(myUrl.openStream()));
          PrintWriter pw = new PrintWriter(new FileWriter("data/lv/wikidemopage.html"))
      ) {
          String html;
          while((html = br.readLine())!=null) {
            //System.out.println(html);
            pw.println(html);
          }
          pw.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }


  }

}
