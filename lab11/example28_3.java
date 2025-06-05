package scr.lab11;
import java.util.*;

public class example28_3 {
    public static List<String> filterCapitalized(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str != null && !str.isEmpty() && Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Напишите функцию, которая принимает на вход список чисел и\n" +
                "возвращает новый список, содержащий квадраты этих чисел.",
                "функцию, которая принимает на вход список строк", "Напишите функцию, которая принимает на вход список строк",
                "(без цифр и символов).", "новый список,", "Q123qwe");

        List<String> capitalized = filterCapitalized(input);

        System.out.println("Строки, начинающиеся с заглавной буквы:");
        for (String s : capitalized) {
            System.out.println(s);
        }
    }
}