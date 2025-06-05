package scr.lab10.EXCEL;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class NExcel {
        public static void main(String[] args) {
            String filePath = "scr/lab10/example1/EXCEL/example.xlsx";

            if (!isValidExcelFile(filePath)) {
                System.err.println("Ошибка: необходимо выбрать файл формата .xls или .xlsx");
                return;
            }

            try (FileInputStream inputStream = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(inputStream)) {

                Sheet sheet = workbook.getSheet("Товары");

                if (sheet == null) {
                    throw new IOException("Не найдена страница с названием \"Товары\"");
                }

                System.out.println("Содержимое листа \"Товары\":\n");

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }

            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Произошла неизвестная ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private static boolean isValidExcelFile(String filePath) {
            if (filePath == null || !filePath.contains(".")) {
                return false;
            }

            String fileExtension = filePath.substring(filePath.lastIndexOf(".") + 1).toLowerCase();
            return fileExtension.equals("xls") || fileExtension.equals("xlsx");
        }
    }