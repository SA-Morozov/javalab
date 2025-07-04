package scr.lab10.example1.EXCEL;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workBook = new XSSFWorkbook();
        XSSFSheet sheet = workBook.createSheet("Товары");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(1);
        dataRow1 .createCell(0).setCellValue("Книга");
        dataRow1 .createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
        dataRow1 .createCell(2).setCellValue(500.0);

        Row dataRow2 = sheet.createRow(2);
        dataRow2.createCell(0).setCellValue("Компьютер");
        dataRow2.createCell(1).setCellValue("Процессор Intel Core i5");
        dataRow2.createCell(2).setCellValue(25000.0);

        String filePath = "scr/lab10/example1/EXCEL/example.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workBook.write(outputStream);
        workBook.close();
        outputStream.close();

        System.out.println("Данные записаны!");
    }
}