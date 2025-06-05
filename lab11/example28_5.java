package scr.lab11;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class example28_5 {
    public static List<String> Poisk(List<String> list, String poisk){
        return list.stream()
                .filter(s -> s.contains(poisk))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  input = "Напишите функцию, которая принимает на вход список чисел и " +
                        "возвращает новый список, содержащий квадраты этих чисел."+
                "функцию, которая принимает на вход список строк "+ "Напишите функцию, которая принимает на вход список строк "+
                "(без цифр и символов) "+ "новый список "+ "Q123qwe";
        List<String> strings = List.of(input.split(" "));
        System.out.print("Введите подстроку для поиска:");
        String poisk = in.nextLine();

        List<String> result = Poisk(strings,poisk);
        System.out.println("Строки после поиска: \n");
        for(String e : result){
            System.out.println(e);
        }
    }
}