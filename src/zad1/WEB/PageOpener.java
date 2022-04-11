package zad1.WEB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PageOpener {

    public String getContent(String url) {

        URL page = null;
        try {
            page = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();


        if (page != null) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(page.openStream(), StandardCharsets.UTF_8))) {
                String line;

                while((line = in.readLine()) != null)
                    sb.append(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


}