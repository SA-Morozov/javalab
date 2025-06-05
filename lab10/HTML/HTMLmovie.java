package scr.lab10.HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HTMLmovie {
    public static void main(String[] args) throws IOException {
        String url = "https://www.imdb.com/chart/top/";
        BufferedWriter bufWriter = null;
        String path = SetNewFile("src/lw10/HTML/top_movies.txt");
        
        try {
            bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
            try {
                Document doc = connectToURL(url);
                Elements movieList = doc.select("tbody.lister-list tr");
                
                for (Element movie : movieList) {
                    String title = movie.select("td.titleColumn a").text();
                    String year = movie.select("td.titleColumn span.secondaryInfo").text()
                                       .replace("(", "").replace(")", "");
                    String rating = movie.select("td.ratingColumn strong").text();
                    String crew = movie.select("td.titleColumn a").attr("title");
                    
                    System.out.println("Рейтинг: " + rating);
                    System.out.println("Название: " + title);
                    System.out.println("Год: " + year);
                    System.out.println("Создатели: " + crew + "\n");
                    
                    bufWriter.write("Рейтинг: " + rating + "\n");
                    bufWriter.write("Название: " + title + "\n");
                    bufWriter.write("Год: " + year + "\n");
                    bufWriter.write("Создатели: " + crew + "\n\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Ошибка - " + e);
        } finally {
            if (bufWriter != null) {
                bufWriter.flush();
                bufWriter.close();
            }
        }
    }

    public static String SetNewFile(String path) {
        try {
            File fileOne = new File(path);
            fileOne.createNewFile();
            System.out.println("Создан файл по пути: " + fileOne.getAbsolutePath());
            return fileOne.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Ошибка создания файла - " + e);
            return path;
        }
    }

    public static Document connectToURL(String url) {
        try {
            return Jsoup.connect(url)
                      .userAgent("Mozilla/5.0")
                      .timeout(10000)
                      .get();
        } catch (IOException e) {
            System.out.print("Ошибка подключения к сайту, попытка подключиться ещё раз\n");
            return connectToURL(url, 1);
        }
    }

    public static Document connectToURL(String url, int countReplay) {
        countReplay++;
        if (countReplay >= 3) {
            return null;
        }
        
        try {
            return Jsoup.connect(url)
                      .userAgent("Mozilla/5.0")
                      .timeout(10000)
                      .get();
        } catch (IOException e) {
            System.out.print("Ошибка подключения к сайту, попытка подключиться ещё раз\n");
            return connectToURL(url, countReplay);
        }
    }
}