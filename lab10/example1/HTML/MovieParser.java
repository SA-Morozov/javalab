package scr.lab10.example1.HTML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MovieParser {
    public static void main(String[] args) {
        String outputFile = "top_movies.txt";
        
        try {
            // 1. Подключение с улучшенными настройками
            Document doc = Jsoup.connect("https://www.imdb.com/chart/top/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .timeout(15000)
                    .get();

            // 2. Используем современные селекторы IMDb
            Elements movieRows = doc.select("li.ipc-metadata-list-summary-item");
            
            if (movieRows.isEmpty()) {
                System.out.println("Фильмы не найдены! Проверьте селекторы.");
                return;
            }

            // 3. Запись в файл
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFile, StandardCharsets.UTF_8))) {
                
                for (int i = 0; i < Math.min(10, movieRows.size()); i++) {
                    Element movie = movieRows.get(i);
                    
                    // 4. Более надежные селекторы
                    String title = movie.select("h3.ipc-title__text").text();
                    String year = movie.select("span.sc-14dd939d-6").first() != null ? 
                            movie.select("span.sc-14dd939d-6").first().text() : "N/A";
                    String rating = movie.select("span.ipc-rating-star").text();
                    String url = "https://www.imdb.com" + movie.select("a.ipc-title-link-wrapper").attr("href");

                    // 5. Запись в файл и вывод в консоль
                    String movieInfo = String.format(
                        "%d. %s (%s)\nРейтинг: %s\nСсылка: %s\n----------------------------------\n",
                        i+1, title, year, rating, url
                    );
                    
                    writer.write(movieInfo);
                    System.out.print(movieInfo);
                }
                
                System.out.println("\nДанные сохранены в файл: " + new java.io.File(outputFile).getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}