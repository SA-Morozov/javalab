package scr.lab12;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class example28_6 {
    static class SumTask implements Callable<Long> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Long call() {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
    }

    public static long parallelSum(int[] array) throws InterruptedException, ExecutionException {
        int numProcessors = Runtime.getRuntime().availableProcessors(); // число ядер
        ExecutorService executor = Executors.newFixedThreadPool(numProcessors);
        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / numProcessors);
        Future<Long>[] futures = new Future[numProcessors];

        // Распределяем задачи между потоками
        for (int t = 0; t < numProcessors; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, length);
            futures[t] = executor.submit(new SumTask(array, start, end));
        }

        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }
        executor.shutdown();
        return totalSum;
    }


    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int count = in.nextInt();
        int[] array = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            array[i] = random.nextInt(0,100);

        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(array));

        long startTime = System.currentTimeMillis();
        long sum = parallelSum(array);
        long endTime = System.currentTimeMillis();

        System.out.println("Сумма всех элементов: " + sum);
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
