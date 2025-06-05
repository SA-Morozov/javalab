package scr.lab11;
import java.util.*;

public class example28_9 {
    public static List<String> patternStr(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str != null && !str.isEmpty() && str.matches("[a-zA-Zа-яА-ЯёЁ[\\s]]+")) {
                result.add(str);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        list.add("Хорошая строка");
        list.add("2 ой ой цифра");
        list.add("Goodnessss");
        list.add("Это восклицательный знак!");
        System.out.println("Исходные строки:");
        for(String e : list){
            System.out.println(e);
        }
        System.out.println("Строки после преобразования:");
        List<String> resultList = patternStr(list);
        for(String e : resultList){
            System.out.println(e);
        }
    }
}
