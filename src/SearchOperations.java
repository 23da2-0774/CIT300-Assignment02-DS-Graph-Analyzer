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

    /** Checks the array is sorted in ascending order. */
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    /** Linear search: checks elements one by one. O(n). */
    public static SearchResult linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                found = i;
                break;
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    /** Binary search: halves the search range each time. O(log n). Needs sorted data. */
    public static SearchResult binarySearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int low = 0;
        int high = arr.length - 1;
        int found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                found = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    public static void printResult(String name, int target, SearchResult r) {
        String outcome = (r.index >= 0) ? "FOUND at index " + r.index : "NOT FOUND";
        System.out.println(name + " for " + target + ": " + outcome
                + " | steps = " + r.steps + " | time = " + r.nanos + " ns");
    }
}
