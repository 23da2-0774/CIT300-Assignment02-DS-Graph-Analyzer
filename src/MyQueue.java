/** Circular array-based queue (FIFO) with a fixed capacity. */
public class MyQueue {
    private final int[] items;
    private int front;
    private int count;

    public MyQueue(int capacity) {
        items = new int[capacity];
        front = 0;
        count = 0;
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == items.length; }

    /** Adds an element at the rear. O(1). */
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue overflow: the queue is full.");
            return false;
        }
        int rear = (front + count) % items.length;
        items[rear] = value;
        count++;
        return true;
    }

    /** Removes and returns the front element. O(1). */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow: cannot dequeue from an empty queue.");
            return null;
        }
        int value = items[front];
        front = (front + 1) % items.length;
        count--;
        return value;
    }

    /** Returns the front element without removing it. O(1). */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty: nothing at the front.");
            return null;
        }
        return items[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Queue (front -> rear): ");
        for (int i = 0; i < count; i++) {
            sb.append(items[(front + i) % items.length]);
            if (i < count - 1) sb.append(" <- ");
        }
        System.out.println(sb);
    }
}
