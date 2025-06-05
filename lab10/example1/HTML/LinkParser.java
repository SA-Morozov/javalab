package scr.lab10.example1.HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkParser {
    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        try{
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("new");
            for (Element link : links){
                System.out.println(link.attr("nov:new"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}