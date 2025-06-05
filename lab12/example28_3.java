package scr.lab12;

public class example28_3 {
    public static void main(String[] args) {
        Thread potok1 = new Thread(new PrintEvenNumbers());
        potok1.setName("Первый поток");

        Thread potok2 = new Thread(new PrintOddNumbers());
        potok2.setName("Всторой поток");

        potok1.start();
        potok2.start();
    }
    // четные
    static class PrintEvenNumbers implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " прерван.");
                }
            }
            System.out.println(Thread.currentThread().getName() + " завершил работу.");
        }
    }
    // нечетные
    static class PrintOddNumbers implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " прерван.");
                }
            }
            System.out.println(Thread.currentThread().getName() + " завершил работу.");
        }
    }
}