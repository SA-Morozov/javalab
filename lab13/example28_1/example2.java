package scr.lab13.example28_1;

public class example2 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            System.out.println("1");
            throw new RuntimeException("Непроверяемая ошибка");

        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
