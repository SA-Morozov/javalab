package scr.lab9.example28_8;

public class SingleLinkedList {
    private Node head;

    // Ввод с головы
    public void createHead(int[] values) {
        if (values == null || values.length == 0) return;
        for (int i = 0; i < values.length; i++) {
            head = new Node(values[i], head);
        }
    }

    // Ввод с хвоста
    public void createTail(int[] values) {
        if (values == null || values.length == 0) return;

        Node newNode = new Node(values[0]); // первый узел
        head = newNode;

        Node current = head;

        for (int i = 1; i < values.length; i++) {
            newNode = new Node(values[i]);
            current.next = newNode;
            current = newNode;
        }
    }

    // Вывод списка в виде строки
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 4); // удалить последний " -> "
        return sb.toString();
    }

    // Добавление элемента в начало
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    // Добавление элемента в конец
    public void addLast(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    // Вставка по индексу
    public void insert(int index, int value) {
        if (index < 0) return;
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null) return;
        current.next = new Node(value, current.next);
    }

    // Удаление первого элемента
    public void removeFirst() {
        if (head != null) head = head.next;
    }

    // Удаление последнего элемента
    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Удаление по индексу
    public void remove(int index) {
        if (index < 0 || head == null) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) return;
        current.next = current.next.next;
    }

    public void createHeadRec(int[] values) {
        if (values == null || values.length == 0) return;
        createHeadRec(values, values.length - 1);
    }

    private void createHeadRec(int[] values, int index) {
        if (index < 0) return;
        head = new Node(values[index], head);
        createHeadRec(values, index - 1);
    }


    // Рекурсивное создание с хвоста
    private Node createTailRec(Node node, int[] values, int index) {
        if (index >= values.length) return null;
        node = new Node(values[index]);
        node.next = createTailRec(node.next, values, index + 1);
        return node;
    }

    public void createTailRec(int[] values) {
        head = createTailRec(head, values, 0);
    }

    public String toStringRec() {
        return toStringRec(head);
    }

    private String toStringRec(Node node) {
        if (node == null) return "";
        if (node.next == null) return Integer.toString(node.value);
        return node.value + " -> " + toStringRec(node.next);
    }


}