package scr.lab9;
import java.util.Scanner;
public class example28_2 {
    public static void main(String[] args) {
        System.out.print("Введите целое число для перевода: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print("Результат: " + Translation(n));
    }

    public static String Translation(int x){
        int result;
        if(x == 0){
            return "";
        }else{
            result = x % 2;
            x = x / 2;
        }
        return Translation(x) + String.valueOf(result);
    }
}
