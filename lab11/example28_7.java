package scr.lab11;
import java.util.*;
import java.util.Scanner;

public class example28_7 {
    public static List<String> find(List<String> strings, int length) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str != null && str.length() > length) {
                result.add(str);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  input = "Напишите функцию, которая принимает на вход список чисел и " +
                "возвращает новый список, содержащий квадраты этих чисел. "+
                "функцию, которая принимает на вход список строк "+ "Напишите функцию, которая принимает на вход список строк "+
                "(без цифр и символов) "+ "новый список "+ "Q123qwe";
        List<String> strings = List.of(input.split(" "));
        System.out.print("Введите число для фильтрации строк:");
        int poisk = in.nextInt();

        List<String> result = find(strings,poisk);
        System.out.println("Строки после поиска: \n");
        for(String e : result){
            System.out.println(e);
        }
    }
}
