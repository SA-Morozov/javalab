import java.util.ArrayDeque;
import java.util.Deque;

public class TestArrayDeque {
    private static final int SIZE = 19_000_000;
    private static final long FIND_OPERATIONS = 19_000_000_000L;

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(SIZE);
                for (int i = 0; i < SIZE; i++) {
            deque.addLast(i);
        }

        System.out.println("Тестирование ArrayDeque с " + SIZE + " элементами");
        System.out.println("Время добавления в начало: " + addStart(deque) + " мс");
        System.out.println("Время добавления в конец: " + addEnd(deque) + " мс");
        System.out.println("Время добавления в середину: " + addMiddle(deque) + " мс");
        System.out.println("Время удаления из начала: " + removeStart(deque) + " мс");
        System.out.println("Время удаления из конца: " + removeEnd(deque) + " мс");
        System.out.println("Время удаления из середины: " + removeMiddle(deque) + " мс");
        System.out.println("Время получения элементов: " + find(deque) + " мс");
    }
    private static long addStart(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            deque.addFirst(Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }
    private static long addEnd(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            deque.addLast(Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }
    private static long addMiddle(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        ArrayDeque<Integer> temp = new ArrayDeque<>(SIZE + 1000);
        int middle = deque.size() / 2;
                for (int i = 0; i < middle; i++) {
            temp.addLast(deque.removeFirst());
        }
                for (int i = 0; i < 1000; i++) {
            temp.addLast(Integer.MAX_VALUE);
        }
                while (!deque.isEmpty()) {
            temp.addLast(deque.removeFirst());
        }
        while (!temp.isEmpty()) {
            deque.addLast(temp.removeFirst());
        }
        
        return System.currentTimeMillis() - start;
    }
    private static long removeStart(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            deque.removeFirst();
        }
        return System.currentTimeMillis() - start;
    }
    private static long removeEnd(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            deque.removeLast();
        }
        return System.currentTimeMillis() - start;
    }
    private static long removeMiddle(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        ArrayDeque<Integer> temp = new ArrayDeque<>(SIZE);
        int middle = deque.size() / 2;
        for (int i = 0; i < middle - 500; i++) {
            temp.addLast(deque.removeFirst());
        }
             for (int i = 0; i < 1000; i++) {
            deque.removeFirst();
        }

        while (!deque.isEmpty()) {
            temp.addLast(deque.removeFirst());
        }

        while (!temp.isEmpty()) {
            deque.addLast(temp.removeFirst());
        }
        
        return System.currentTimeMillis() - start;
    }

    private static long find(Deque<Integer> deque) {
        long start = System.currentTimeMillis();
        long operations = 0;
        
        while (operations < FIND_OPERATIONS) {
            for (Integer value : deque) {
                int val = value; 
                operations++;
                if (operations >= FIND_OPERATIONS) break;
            }
        }
        
        return System.currentTimeMillis() - start;
    }
}