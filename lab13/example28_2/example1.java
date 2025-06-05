package scr.lab13.example28_2;
import java.util.*;

public class example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;

        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();
            array = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.print("Введите элемент [" + i + "]: ");
                array[i] = scanner.nextInt(); // Может выбросить InputMismatchException
            }

            int sum = 0;
            int count = 0;

            for (int num : array) {
                if (num > 0) {
                    sum += num;
                    count++;
                }
            }

            double average = (double) sum / count; // Может выбросить ArithmeticException,а может и нет)
            System.out.println("Среднее значение положительных элементов: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не целое число.");
        } catch (ArithmeticException e) {
            System.out.println("Нет положительных элементов для вычисления среднего значения.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Размер массива не может быть отрицательным.");
        } finally {
            System.out.println("Программа завершила выполнение.");
            scanner.close();
        }
    }
}
