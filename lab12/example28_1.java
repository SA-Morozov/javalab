package scr.lab12;

public class example28_1 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new TimePrinter("Поток-1"));
        thread1.start();


        Thread thread2 = new Thread(new TimePrinter("Поток-2"));
        thread2.start();
    }

    static class TimePrinter implements Runnable {
        private final String name;
        private final long durationMillis = 10_000; // 10 секунд

        public TimePrinter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            long endTime = System.currentTimeMillis() + durationMillis;

            while (System.currentTimeMillis() < endTime) {
                System.out.println(name + " | Текущее время: " + new java.util.Date());

                try {
                    // Задержка в 1 секунду
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " был прерван.");
                    return;
                }
            }

            System.out.println(name + " завершил работу.");
        }
    }
}
