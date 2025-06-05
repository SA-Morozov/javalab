package scr.lab12;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class example28_5 {
    static class MaxTask implements Callable<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public MaxTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }
    }

    public static int findMaxParallel(int[] array) throws InterruptedException, ExecutionException {
        int processors = Runtime.getRuntime().availableProcessors(); // количество ядер
        ExecutorService executor = Executors.newFixedThreadPool(processors);
        int length = array.length;
        int chunkSize = (int) Math.ceil((double) length / processors);
        Future<Integer>[] futures = new Future[processors];

        // Разделяем работу между потоками
        for (int t = 0; t < processors; t++) {
            int start = t * chunkSize;
            int end = Math.min(start + chunkSize, length);
            futures[t] = executor.submit(new MaxTask(array, start, end));
        }

        // Собираем результаты
        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int localMax = future.get();
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        executor.shutdown();
        return globalMax;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива ");
        int count = in.nextInt();
        int[] array = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            array[i] = random.nextInt(0,1000000);

        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(array));

        long startTime = System.currentTimeMillis();
        int max = findMaxParallel(array);
        long endTime = System.currentTimeMillis();

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }
}
