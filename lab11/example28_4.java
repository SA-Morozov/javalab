package scr.lab11;
import java.util.*;

public class example28_4 {
    public static List<Integer> getSquareList(int[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num != null) {
                result.add(num * num);
            }
        }
        return result;
    }

    // Пример использования
    public static void main(String[] args) {
        int length = 10; // длина массива
        int[] nums = new int[length];

        Random random = new Random(); // создаем объект класса Random

        for (int i = 0; i < length; i++) {
            // заполняем каждый элемент случайным числом от 0 до 99
            nums[i] = random.nextInt(100);
        }

        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(nums));

        List<Integer> squared = getSquareList(nums);

        System.out.println("Квадраты чисел: " + squared);
    }

}
