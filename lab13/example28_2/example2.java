package scr.lab13.example28_2;
import java.util.*;

public class example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = null;

        try {
            System.out.print("Введите количество строк: ");
            int rows = scanner.nextInt();

            System.out.print("Введите количество столбцов: ");
            int cols = scanner.nextInt();

            matrix = new int[rows][cols];
            Random rnd = new Random();
            // Ввод матрицы
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i] [j] = (int) (Math.random() * 10);
                    System.out.println("matrix[" + i + "][" + j + "] = "+ matrix[i] [j]);
                }
            }

            System.out.print("Введите номер столбца для вывода: ");
            int colNumber = scanner.nextInt();

            if (colNumber < 0 || colNumber >= cols) {
                throw new ArrayIndexOutOfBoundsException("Столбца с номером " + colNumber + " не существует.");
            }

            System.out.println("Столбец №" + colNumber + ":");
            for (int i = 0; i < rows; i++) {
                System.out.println(matrix[i][colNumber]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не целое число.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[Ошибка индекса] " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Размеры матрицы не могут быть отрицательными.");
        } finally {
            System.out.println("Программа завершила выполнение.");
            scanner.close();
        }
    }
}
