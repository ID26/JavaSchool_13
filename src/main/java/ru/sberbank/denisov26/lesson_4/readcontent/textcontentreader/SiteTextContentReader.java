package ru.sberbank.denisov26.lesson_4.readcontent.textcontentreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SiteTextContentReader {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isUrlCorrect = true;
            while (isUrlCorrect) {
                try {
                    System.out.println("Enter url: ");
                    URL url = new URL(reader.readLine());
                    readContent(url);
                    isUrlCorrect = false;
                } catch (MalformedURLException e) {
                    System.out.println("Incorrect url. ");
                } catch (IOException e) {
                    System.out.println("Unavailable url. ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readContent(URL url) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(url.openConnection().getInputStream(), "UTF8"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
