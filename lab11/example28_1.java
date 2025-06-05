package scr.lab11;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class example28_1 {
    public static int[] search_even_numbers(int[] arr){
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int count = in.nextInt();
        int[] arr = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            arr[i] = random.nextInt(0,1000);

        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        int[] arrrez = search_even_numbers(arr);
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arrrez));
    }
}