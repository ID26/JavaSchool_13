package ru.sberbank.denisov26.lesson_4.readcontent;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class SiteTextContentReader {
    private URL url;

    public SiteTextContentReader(URL url) {
        this.url = url;
    }

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            BufferedReader bufferedReader = null;
            try  {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                URL url = new URL(bufferedReader.readLine());
                if (readContent(url) == 1) {
                    bufferedReader.close();
                    loop = false;
                }
                return;
            } catch (FileNotFoundException ignore) {
                System.out.println("Try enter url again!");
            } catch (MalformedURLException ignore)  {
                System.out.println("Try enter url again!");
            } catch (IOException e) {
                continue;
            } finally {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                continue;
            }
        }
    }

    public static int readContent(URL url) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(url.openConnection().getInputStream(), "UTF8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            return 1;

//            StringBuilder builder = new StringBuilder();
//            int byteRead;
//            while ((byteRead = bufferedReader.read()) != -1) {
//                builder.append((char) byteRead);
//                System.out.println(byteRead);
//            }
//            String text = builder.toString();
//            //System.out.println(text.length());
//
//            String[] arrayWeb=text.split(" ");
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
