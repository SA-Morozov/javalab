package scr.lab10.example1.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import java.io.File;

public class CreateXMLFile {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Создание корня
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            //Добавление элемента
            Element bookOne = doc.createElement("book");
            rootElement.appendChild(bookOne);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война и мир"));
            bookOne.appendChild(title1);

            Element authorOne = doc.createElement("author");
            authorOne.appendChild(doc.createTextNode("Лев Толстой"));
            bookOne.appendChild(authorOne);

            Element yearOne = doc.createElement("year");
            yearOne.appendChild(doc.createTextNode("1869"));
            bookOne.appendChild(yearOne);

            //Добавление второго элемента
            Element bookTwo = doc.createElement("book");
            rootElement.appendChild(bookTwo);

            Element title2 = doc.createElement("title");
            title2.appendChild(doc.createTextNode("Мастер и Маргарита"));
            bookTwo.appendChild(title2);

            Element authorTwo = doc.createElement("author");
            authorTwo.appendChild(doc.createTextNode("Михаил Булгаков"));
            bookTwo.appendChild(authorTwo);

            Element yearTwo = doc.createElement("year");
            yearTwo .appendChild(doc.createTextNode("1967"));
            bookTwo.appendChild(yearTwo);

            //Запись xml-файла
            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(new File("scr/lab10/example1/XML/example.xml"));
            transformer.transform(source, result);

            System.out.println("Файл xml успешно сохранён!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}