package scr.lab11;
import java.util.*;
import java.util.Scanner;

public class example28_6 {
    public static List<Integer> filterDivisible(int[] numbers, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers) {
            if (num != null && divisor != 0 && num % divisor == 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int length = in.nextInt();
        int[] nums = new int[length];

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            nums[i] = random.nextInt(100);
        }

        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(nums));
        System.out.print("Введите число для деления ");
        int divisor = in.nextInt();

        List<Integer> divisibleNumbers = filterDivisible(nums, divisor);

        System.out.println("Числа, делящиеся на " + divisor + " без остатка:");
        for (Integer num : divisibleNumbers) {
            System.out.println(num);
        }
    }
}
