package scr.lab10.XML;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XML {
    private static final String FILE_PATH = "scr/lab10/XML/example.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Document doc = loadDocument();

            while (true) {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Показать все книги");
                System.out.println("2 - Добавить новую книгу");
                System.out.println("3 - Найти книги по автору");
                System.out.println("4 - Найти книги по году");
                System.out.println("5 - Удалить книгу по названию");
                System.out.println("6 - Выход");
                System.out.print("Ваш выбор: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        printAllBooks(doc);
                        break;
                    case 2:
                        addBook(doc, scanner);
                        saveDocument(doc);
                        break;
                    case 3:
                        search(doc, scanner);
                        break;
                    case 4:
                        searchByYear(doc, scanner);
                        break;
                    case 5:
                        deleteBook(doc, scanner);
                        saveDocument(doc);
                        break;
                    case 6:
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

    private static Document loadDocument() throws Exception {
        File inputFile = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(inputFile);
    }

    private static void saveDocument(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
        System.out.println("Файл успешно сохранён.");
    }

    private static void printAllBooks(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("\nКнига:");
                System.out.println("Название: " + getTextContent(element, "title"));
                System.out.println("Автор: " + getTextContent(element, "author"));
                System.out.println("Год: " + getTextContent(element, "year"));
            }
        }
    }

    private static String getTextContent(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent();
    }

    private static void addBook(Document doc, Scanner scanner) {
        Element newBook = doc.createElement("book");

        System.out.print("Введите название книги: ");
        Element title = doc.createElement("title");
        title.setTextContent(scanner.nextLine());
        newBook.appendChild(title);

        System.out.print("Введите автора книги: ");
        Element author = doc.createElement("author");
        author.setTextContent(scanner.nextLine());
        newBook.appendChild(author);

        System.out.print("Введите год издания: ");
        Element year = doc.createElement("year");
        year.setTextContent(scanner.nextLine());
        newBook.appendChild(year);

        doc.getDocumentElement().appendChild(newBook);
        System.out.println("Книга добавлена.");
    }

    private static void search(Document doc, Scanner scanner) {
        System.out.print("Введите имя автора: ");
        String authorToFind = scanner.nextLine();

        NodeList list = doc.getElementsByTagName("book");
        boolean found = false;

        for (int i = 0; i < list.getLength(); i++) {
            Element book = (Element) list.item(i);
            String author = getTextContent(book, "author");

            if (author.equalsIgnoreCase(authorToFind)) {
                found = true;
                System.out.println("\nКнига:");
                System.out.println("Название: " + getTextContent(book, "title"));
                System.out.println("Автор: " + author);
                System.out.println("Год: " + getTextContent(book, "year"));
            }
        }

        if (!found) {
            System.out.println("Книги данного автора не найдены.");
        }
    }

    private static void searchByYear(Document doc, Scanner scanner) {
        System.out.print("Введите год издания: ");
        String yearToFind = scanner.nextLine();

        NodeList list = doc.getElementsByTagName("book");
        boolean found = false;

        for (int i = 0; i < list.getLength(); i++) {
            Element book = (Element) list.item(i);
            String year = getTextContent(book, "year");

            if (year.equals(yearToFind)) {
                found = true;
                System.out.println("\nКнига:");
                System.out.println("Название: " + getTextContent(book, "title"));
                System.out.println("Автор: " + getTextContent(book, "author"));
                System.out.println("Год: " + year);
            }
        }

        if (!found) {
            System.out.println("Книги этого года не найдены.");
        }
    }

    private static void deleteBook(Document doc, Scanner scanner) {
        System.out.print("Введите название книги для удаления: ");
        String titleToDelete = scanner.nextLine();

        NodeList list = doc.getElementsByTagName("book");
        boolean deleted = false;

        for (int i = 0; i < list.getLength(); i++) {
            Element book = (Element) list.item(i);
            String title = getTextContent(book, "title");

            if (title.equalsIgnoreCase(titleToDelete)) {
                Node parent = book.getParentNode();
                parent.removeChild(book);
                deleted = true;
                System.out.println("Книга удалена.");
                break;
            }
        }

        if (!deleted) {
            System.out.println("Книга не найдена.");
        }
    }
}