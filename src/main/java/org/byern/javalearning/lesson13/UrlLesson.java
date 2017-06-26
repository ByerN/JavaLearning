package org.byern.javalearning.lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ByerN on 21.05.2017.
 */
public class UrlLesson {

    public static final String ENDPOINT = "https://pl.wikipedia.org/wiki/Java";

    public static void main(String[] args) throws IOException {
        URLConnection connection = new URL(ENDPOINT).openConnection();
        String line;
        try(BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            while ((line = inputStream.readLine()) != null)
                System.out.println(line);
        }
    }
}
