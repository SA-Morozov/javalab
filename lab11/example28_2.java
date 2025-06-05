package scr.lab11;
import java.util.*;

public class example28_2 {
    public static int[] getCommonElements(int[] arr1, int[] arr2) {
        // Используем HashSet для хранения элементов первого массива
        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        // Используем другое множество для хранения общих элементов
        Set<Integer> commonSet = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                commonSet.add(num);
            }
        }

        // Преобразуем результат в массив
        int[] result = new int[commonSet.size()];
        int i = 0;
        for (int num : commonSet) {
            result[i++] = num;
        }

        return result;
    }

    // Пример использования
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер первого массива ");
        int count = in.nextInt();
        int[] arr1 = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            arr1[i] = random.nextInt(0,10);

        }
        System.out.println(Arrays.toString(arr1));

        System.out.print("Введите размер второго массива ");
        int count1 = in.nextInt();
        int[] arr2 = new int[count];
        Random random2 = new Random();
        for(int i = 0; i < count; i++){
            arr2[i] = random.nextInt(0,10);

        }
        System.out.println(Arrays.toString(arr2));
        int[] result = getCommonElements(arr1, arr2);

        System.out.print("Общие элементы: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
