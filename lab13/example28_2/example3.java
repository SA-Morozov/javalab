package scr.lab13.example28_2;
import java.util.*;

public class example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            if (size < 0) {
                throw new NegativeArraySizeException();
            }

            byte[] array = new byte[size];
            long sum = 0;

            for (int i = 0; i < size; i++) {
                System.out.print("Введите элемент [" + i + "]: ");
                String input = scanner.next();

                int value = Integer.parseInt(input); // Может вызвать NumberFormatException

                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    throw new ClassCastException("Значение выходит за пределы типа byte (-128..127).");
                }

                array[i] = (byte) value;
                sum += array[i];
            }

            System.out.println("Сумма элементов: " + sum);

        } catch (InputMismatchException e) {
            System.out.println(" Вы ввели не целое число.");
        } catch (NumberFormatException e) {
            System.out.println("Введенная строка не является числом.");
        } catch (ClassCastException e) {
            System.out.println("[Ошибка диапазона] " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println(" Размер массива не может быть отрицательным.");
        } finally {
            System.out.println("Программа завершила выполнение.");
            scanner.close();
        }
    }
}

