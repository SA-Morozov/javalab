package scr.lab9.example28_8;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        int[] arr=  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("=== Создание с головы (цикл) ===");
        list.createHead(arr);
        System.out.println(list.toString());
        System.out.println("=== Создание с хвоста (цикл) ===");
        list.createTail(arr);
        System.out.println(list.toString());

        System.out.println("\n=== Добавление в начало и конец ===");
        list.addFirst(0);
        list.addLast(99);
        System.out.println(list.toString());

        System.out.println("\n=== Удаление первого и последнего ===");
        list.removeFirst();
        list.removeLast();
        System.out.println(list.toString());

        System.out.println("\n=== Вставка по индексу ===");
        list.insert(5, 555);
        System.out.println(list.toString());

        System.out.println("\n=== Удаление по индексу ===");
        list.remove(5);
        System.out.println(list.toString());

        System.out.println("\n=== Создание с хвоста (рекурсия) ===");
        SingleLinkedList recList = new SingleLinkedList();
        recList.createTailRec(arr);
        System.out.println(recList.toStringRec());

        System.out.println("\n=== Создание с головы (рекурсия) ===");
        SingleLinkedList list2 = new SingleLinkedList();
        list2.createHeadRec(arr);
        System.out.println(list2.toStringRec());
    }
}