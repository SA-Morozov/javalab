package scr.lab9.example28_7;
import java.util.ArrayList;
import java.util.Scanner;

public class testArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество людей: ");
        int N = in.nextInt();

        ArrayList<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        long start = System.currentTimeMillis();
        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
        long end = System.currentTimeMillis();
        System.out.println("Остался номер: " + people.get(0));
        System.out.println("Время выполнения: " + (end - start) + " мс");
    }
}
