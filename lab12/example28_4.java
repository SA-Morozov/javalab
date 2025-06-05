package scr.lab12;

public class example28_4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;

            Thread thread = new Thread(() -> {
                System.out.println("Поток №" + threadNumber);
            });

            thread.start();
        }
    }
}