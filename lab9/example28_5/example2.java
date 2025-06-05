package scr.lab9.example28_5;
public class example2 {
    public static void printList(Node node) {
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print(node.value + " ");
        printList(node.next);
    }
    public static void main(String[] args) {
        Node head = new Node(0, null);
        Node current = head;

        for (int i = 1; i < 10; i++) {
            Node newNode = new Node(i, null);
            current.next = newNode;
            current = newNode;
        }
        System.out.println("Список, построенный с головы:");
        printList(head);
    }
}