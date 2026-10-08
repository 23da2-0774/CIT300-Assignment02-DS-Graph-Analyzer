/** Array-based stack (LIFO) with a fixed capacity. */
public class MyStack {
    private final int[] items;
    private int top; // index of the top element, -1 when empty

    public MyStack(int capacity) {
        items = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == items.length - 1; }

    /** Adds an element on top. O(1). */
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow: the stack is full.");
            return false;
        }
        items[++top] = value;
        return true;
    }

    /** Removes and returns the top element. O(1). */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow: cannot pop from an empty stack.");
            return null;
        }
        return items[top--];
    }

    /** Returns the top element without removing it. O(1). */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty: nothing to peek.");
            return null;
        }
        return items[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
