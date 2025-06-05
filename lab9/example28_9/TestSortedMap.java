import java.util.SortedMap;
import java.util.TreeMap;

public class TestSortedMap {
    private static final int SIZE = 19 * 1_000_000;
    private static final int GET_OPERATION_SIZE = 19 * 1_000_000_000;

    public static void main(String[] args) {
        SortedMap<Integer, Integer> treeMap = new TreeMap<>();
             long fillStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            treeMap.put(i, i);
        }
        long fillEnd = System.currentTimeMillis();
        System.out.println("Время заполнения коллекции: " + (fillEnd - fillStart) + " мс");
              System.out.println("Время добавления в начало: " + addStart(treeMap) + " мс");
        System.out.println("Время добавления в конец: " + addEnd(treeMap) + " мс");
        System.out.println("Время добавления в середину: " + addMiddle(treeMap) + " мс");
        System.out.println("Время удаления из начала: " + removeStart(treeMap) + " мс");
        System.out.println("Время удаления из конца: " + removeEnd(treeMap) + " мс");
        System.out.println("Время удаления из середины: " + removeMiddle(treeMap) + " мс");
        System.out.println("Время получения элементов: " + find(treeMap) + " мс");
    }
    private static long addStart(SortedMap<Integer, Integer> map) {
        long start = System.currentTimeMillis();
        map.put(-1, -1); 
        long end = System.currentTimeMillis();
        map.remove(-1); 
        return end - start;
    }

    private static long addEnd(SortedMap<Integer, Integer> map) {
        long start = System.currentTimeMillis();
        int lastKey = map.isEmpty() ? 0 : map.lastKey() + 1;
        map.put(lastKey, lastKey);
        long end = System.currentTimeMillis();
        map.remove(lastKey);
        return end - start;
    }

    private static long addMiddle(SortedMap<Integer, Integer> map) {
        long start = System.currentTimeMillis();
        if (!map.isEmpty()) {
            int middleKey = (map.firstKey() + map.lastKey()) / 2;
            map.put(middleKey, middleKey);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long removeStart(SortedMap<Integer, Integer> map) {
        if (map.isEmpty()) return 0;
        int firstKey = map.firstKey();
        long start = System.currentTimeMillis();
        map.remove(firstKey);
        long end = System.currentTimeMillis();
        map.put(firstKey, firstKey);
        return end - start;
    }

    private static long removeEnd(SortedMap<Integer, Integer> map) {
        if (map.isEmpty()) return 0;
        int lastKey = map.lastKey();
        long start = System.currentTimeMillis();
        map.remove(lastKey);
        long end = System.currentTimeMillis();
        map.put(lastKey, lastKey);
        return end - start;
    }

    private static long removeMiddle(SortedMap<Integer, Integer> map) {
        if (map.isEmpty()) return 0;
        int middleKey = (map.firstKey() + map.lastKey()) / 2;
        long start = System.currentTimeMillis();
        map.remove(middleKey);
        long end = System.currentTimeMillis();
        map.put(middleKey, middleKey);
        return end - start;
    }

    private static long find(SortedMap<Integer, Integer> map) {
        if (map.isEmpty()) return 0;
        int keyToGet = map.lastKey();
        long start = System.nanoTime();
        for (int i = 0; i < GET_OPERATION_SIZE / SIZE; i++) {
            map.get(keyToGet);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }
}