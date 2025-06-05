package scr.lab9;
import java.util.Scanner;
import java.util.HashMap;

public class example28_6 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int product = 1;
        for (int i = 0; i <= 8; i++) {
            System.out.print("Введите строку: ");
            String stroka = in.nextLine();
            map.put(i, stroka);
        }

        System.out.print("Строка(и) с ключом = 0: ");
        if (map.containsKey(0)) {
            System.out.println(map.get(0));
        } else {
            System.out.println("Отсутствует");
        }

        System.out.println("Строки с ключами > 5:");
        for (Integer key : map.keySet()) {
            if (key > 5) {
                System.out.println("Ключ: " + key + ", Строка: " + map.get(key));
            }
        }

        boolean hasValidKey = false;

        for (HashMap.Entry<Integer, String> item : map.entrySet()) {
            int key = item.getKey();
            String values = item.getValue();
            if (values.length() > 5 & key != 0) {
                product = product * key;
                hasValidKey = true;
            }
        }
        if (hasValidKey) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("Нет строк с длиной > 5 для вычисления произведения.");
        }
    }
}