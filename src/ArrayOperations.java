// Array operations: insert, delete, search and display
import java.util.Arrays;
import java.util.Random;

/** Fixed-capacity integer array with insert, delete, search and display. */
public class ArrayOperations {
    private final int[] data;
    private int size;

    public ArrayOperations(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }
    public int capacity() { return data.length; }

    /** Inserts at the end. O(1). */
    public boolean insert(int value) {
        if (isFull()) return false;
        data[size++] = value;
        return true;
    }

    /** Inserts at a given index, shifting elements right. O(n). */
    public boolean insertAt(int index, int value) {
        if (isFull() || index < 0 || index > size) return false;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Deletes the element at an index, shifting elements left. O(n). */
    public boolean deleteAt(int index) {
        if (index < 0 || index >= size) return false;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Deletes the first occurrence of a value. */
    public boolean deleteValue(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return deleteAt(i);
            }
        }
        return false;
    }

    /** Sorts the stored elements in ascending order. */
    public void sort() {
        Arrays.sort(data, 0, size);
    }

    /** Fills the array with random numbers (replaces existing content). */
    public void fillRandom(int count, int maxValue) {
        Random random = new Random();
        size = 0;
        for (int i = 0; i < count && i < data.length; i++) {
            data[size++] = random.nextInt(maxValue) + 1;
        }
    }

    /** Returns a copy containing only the used part of the array. */
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.println("Array (" + size + "/" + data.length + "): "
                + Arrays.toString(toArray()));
    }
}
