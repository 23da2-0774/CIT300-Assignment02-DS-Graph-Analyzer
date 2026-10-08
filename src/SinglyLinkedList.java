/** Singly linked list of integers. */
public class SinglyLinkedList {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }

    /** Inserts at the beginning. O(1). */
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    /** Inserts at the end. O(n). */
    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    /** Inserts at a 1-based position (1 = first). O(n). */
    public boolean insertAt(int position, int value) {
        if (position < 1 || position > size + 1) return false;
        if (position == 1) {
            insertFirst(value);
            return true;
        }
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        size++;
        return true;
    }

    /** Deletes the first node holding the value. O(n). */
    public boolean deleteValue(int value) {
        if (head == null) return false;
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        size--;
        return true;
    }

    /** Linear search. Returns {position (1-based, -1 if missing), steps}. O(n). */
    public int[] search(int value) {
        Node current = head;
        int position = 1;
        int steps = 0;
        while (current != null) {
            steps++;
            if (current.value == value) {
                return new int[]{position, steps};
            }
            current = current.next;
            position++;
        }
        return new int[]{-1, steps};
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Linked List: ");
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb);
    }
}
