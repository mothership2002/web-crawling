package com.temp.temp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

@SpringBootApplication
public class TempApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(TempApplication.class, args);
//    }

    public static void main(String[] args) {
        String urlPath = "https://finance.yahoo.com/currencies";
        String pageContents;
        StringBuffer contents = new StringBuffer();

        try {

            URL url = new URL(urlPath);
            URLConnection con = (URLConnection) url.openConnection();
            InputStreamReader reader = new InputStreamReader(con.getInputStream(), "utf-8");

            BufferedReader buff = new BufferedReader(reader);

            while ((pageContents = buff.readLine()) != null) {
                contents.append(pageContents);
                contents.append("\r\n");
            }

            buff.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(contents.toString());

        Elements div = doc.getElementsByTag("tbody");

        Elements symbolList = div.first().getElementsByClass("Va(m) Ta(start) Px(10px) Fz(s)");
        Elements priceList = div.first().getElementsByAttributeValue("data-field", "regularMarketPrice");
        Elements changePrice = div.first().getElementsByAttributeValue("data-field", "regularMarketChange");
        Elements changePercent = div.first().getElementsByAttributeValue("data-field", "regularMarketChangePercent");

        for (Element e : symbolList) {

        }

        for (Element e : priceList) {
            e.val();
        }

        for (Element e : changePrice) {
            e.val();
        }

        for (Element e : changePercent) {
            e.val();
        }
    }
}
