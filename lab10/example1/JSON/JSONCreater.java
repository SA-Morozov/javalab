package scr.lab10.example1.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JSONCreater {
    public static void main(String[] args) {
        JSONObject library = new JSONObject();
        JSONArray books = new JSONArray();

        JSONObject bookOne = new JSONObject();
        bookOne.put("title","Война и мир");
        bookOne.put("author","Лев Толстой");
        bookOne.put("year","1869");

        JSONObject bookTwo = new JSONObject();
        bookTwo.put("title","Мёртвые души");
        bookTwo.put("author","Николай Васильевич Гоголь");
        bookTwo.put("year","1842");

        books.add(bookOne);
        books.add(bookTwo);
        library.put("books", books);

        try(FileWriter file = new FileWriter("scr/lab10/example1/JSON/example.json")){
            file.write(library.toJSONString());
            System.out.println("Json успешно создан!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}