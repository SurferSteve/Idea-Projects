package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Steve on 20.05.2016.
 */
public class Main4 {
    public static void main(String[] args) throws IOException {
        String site = "https://yandex.ru";
//        String site = "http://yandex.ru/asdgsklgksldgm";

        URL url = new URL(site);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        int responseCode = urlConnection.getResponseCode();
        System.out.println(responseCode);

//        urlConnection.getInputStream(); // побайтовый поток информации + символы UTF имеют несколько символов
//        new InputStreamReader(urlConnection.getInputStream()); // читаем уже построчно, а не побайтово
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); // буферизируем и получаем кусками, а не построчно

        StringBuilder result = new StringBuilder();
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            result.append(input).append("\n\n");
        }

        System.out.println(result);

    }
}
