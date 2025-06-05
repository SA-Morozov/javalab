package scr.lab12;

public class example28_2 {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberPrinter());
        numberThread.start();
    }

    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
