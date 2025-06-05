package scr.lab10.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class JSON {
    private static final String FILE_PATH = "scr/lab10/JSON/example.json";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Показать все книги");
                System.out.println("2 - Добавить новую книгу");
                System.out.println("3 - Найти книги по автору");
                System.out.println("4 - Удалить книгу по названию");
                System.out.println("5 - Выход");
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        printAllBooks();
                        break;
                    case 2:
                        addBook(scanner);
                        break;
                    case 3:
                        search(scanner);
                        break;
                    case 4:
                        deleteBook(scanner);
                        break;
                    case 5:
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный выбор!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Чтение и вывод книг
    private static void printAllBooks() throws Exception {
        JSONObject jsonObject = readJSONFile();
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

        System.out.println("Корневой элемент: books");

        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            System.out.println("\nТекущий элемент: book");
            System.out.println("Название книги: " + book.get("title"));
            System.out.println("Автор: " + book.get("author"));
            System.out.println("Год издания: " + book.get("year"));
        }
    }

    private static void search(Scanner scanner) throws Exception {
        System.out.print("Введите имя автора: ");
        String authorToFind = scanner.nextLine();

        JSONObject jsonObject = readJSONFile();
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

        boolean found = false;

        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            String author = (String) book.get("author");

            if (author != null && author.equalsIgnoreCase(authorToFind)) {
                found = true;
                System.out.println("\nНайденная книга:");
                System.out.println("Название: " + book.get("title"));
                System.out.println("Автор: " + book.get("author"));
                System.out.println("Год: " + book.get("year"));
            }
        }

        if (!found) {
            System.out.println("Книги данного автора не найдены.");
        }
    }

    private static void addBook(Scanner scanner) throws Exception {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите год издания: ");
        String year = scanner.nextLine();

        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("author", author);
        newBook.put("year", year);

        JSONObject jsonObject = readJSONFile();
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");
        jsonArray.add(newBook);

        writeJSONToFile(jsonObject);

        System.out.println("Книга успешно добавлена.");
    }

    private static void deleteBook(Scanner scanner) throws Exception {
        System.out.print("Введите название книги для удаления: ");
        String titleToDelete = scanner.nextLine();

        JSONObject jsonObject = readJSONFile();
        JSONArray jsonArray = (JSONArray) jsonObject.get("books");

        boolean deleted = false;
        JSONArray newArray = new JSONArray();

        for (Object o : jsonArray) {
            JSONObject book = (JSONObject) o;
            String title = (String) book.get("title");

            if (title != null && !title.equalsIgnoreCase(titleToDelete)) {
                newArray.add(book);
            } else {
                deleted = true;
            }
        }

        if (deleted) {
            jsonObject.put("books", newArray);
            writeJSONToFile(jsonObject);
            System.out.println("Книга удалена.");
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    private static JSONObject readJSONFile() throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(FILE_PATH));
        return (JSONObject) obj;
    }

    // Запись JSON
    private static void writeJSONToFile(JSONObject jsonObject) throws Exception {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        }
    }
}
