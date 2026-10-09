// Search operations: linear search and binary search with step counting
// Author: T.Fathima Afriha (23DA2-0774) - Array and Searching module

/** Linear and binary search that also count the steps and measure the time. */
public class SearchOperations {

    /** Holds the outcome of one search. */
    public static class SearchResult {
        public final int index;   // -1 if not found
        public final int steps;   // number of comparisons
        public final long nanos;  // execution time in nanoseconds

        public SearchResult(int index, int steps, long nanos) {
            this.index = index;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    /** Checks the array is sorted in ascending order (required for binary search). */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    /**
     * Linear search: checks elements one by one from the start.
     * Best case O(1), worst case O(n). Works on unsorted data.
     */
    public static SearchResult linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++; // one comparison per element
            if (arr[i] == target) {
                found = i;
                break;
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    /**
     * Binary search: halves the search range each time. O(log n).
     * The array MUST be sorted in ascending order.
     */
    public static SearchResult binarySearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int low = 0;
        int high = arr.length - 1;
        int found = -1;
        while (low <= high) {
            steps++; // one comparison with the middle element
            int mid = low + (high - low) / 2; // avoids integer overflow
            if (arr[mid] == target) {
                found = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;   // target is in the right half
            } else {
                high = mid - 1;  // target is in the left half
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    /** Prints a search result in a readable one-line format. */
    public static void printResult(String name, int target, SearchResult r) {
        String outcome = (r.index >= 0) ? "FOUND at index " + r.index : "NOT FOUND";
        System.out.println(name + " for " + target + ": " + outcome
                + " | steps = " + r.steps + " | time = " + r.nanos + " ns");
    }
}