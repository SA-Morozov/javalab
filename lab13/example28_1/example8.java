package scr.lab13.example28_1;

public class example8 {
        public static int m() {
            try {
                System.out.println("0");
                throw new RuntimeException();
            } finally {
                System.out.println("1");
            }
        }
        public static void main(String[] args) {
            System.out.println(m());
        }

}
