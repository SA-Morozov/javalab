package scr.lab13.example28_1;

public class example9 {
    public static int m() {
        try {
            System.out.println("0");
            return 55; // выход из метода
        } finally {
            System.out.println("1");
        }
    }
    public static void main(String[] args) {
        System.out.println(m());
    }
}
