import java.util.*;

public class TestSortedSet {
    private static final int SIZE = 19_000_000;
    private static final long FIND_OPERATIONS = 19_000_000_000L;

    public static void main(String[] args) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        System.out.println("Заполнение TreeSet " + SIZE + " элементами...");
        for (int i = 0; i < SIZE; i++) {
            sortedSet.add(i);
        }

        System.out.println("Добавление в начало: " + testAddFirst(sortedSet) + " мс");
        System.out.println("Добавление в конец: " + testAddLast(sortedSet) + " мс");
        System.out.println("Добавление в середину: " + testAddMiddle(sortedSet) + " мс");
        System.out.println("Удаление из начала: " + testRemoveFirst(sortedSet) + " мс");
        System.out.println("Удаление из конца: " + testRemoveLast(sortedSet) + " мс");
        System.out.println("Удаление из середины: " + testRemoveMiddle(sortedSet) + " мс");
        System.out.println("Итерация по элементам: " + testIteration(sortedSet) + " мс");
    }

    private static long testAddFirst(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        long start = System.nanoTime();
        testSet.add(-1);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testAddLast(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        long start = System.nanoTime();
        testSet.add(SIZE);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testAddMiddle(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        long start = System.nanoTime();
        testSet.add(SIZE / 2);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testRemoveFirst(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        long start = System.nanoTime();
        testSet.remove(testSet.first());
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testRemoveLast(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        long start = System.nanoTime();
        testSet.remove(testSet.last());
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testRemoveMiddle(SortedSet<Integer> set) {
        SortedSet<Integer> testSet = new TreeSet<>(set);
        Integer middleValue = getMiddleElement(testSet);
        long start = System.nanoTime();
        testSet.remove(middleValue);
        return (System.nanoTime() - start) / 1_000_000;
    }

    private static long testIteration(SortedSet<Integer> set) {
        long start = System.currentTimeMillis();
        long operations = 0;
        
        while (operations < FIND_OPERATIONS) {
            for (Integer value : set) {
                operations++;
                if (operations >= FIND_OPERATIONS) break;
            }
        }
        
        return System.currentTimeMillis() - start;
    }

    private static Integer getMiddleElement(SortedSet<Integer> set) {
        int middle = set.size() / 2;
        Iterator<Integer> it = set.iterator();
        for (int i = 0; i < middle && it.hasNext(); i++) {
            it.next();
        }
        return it.hasNext() ? it.next() : null;
    }
}