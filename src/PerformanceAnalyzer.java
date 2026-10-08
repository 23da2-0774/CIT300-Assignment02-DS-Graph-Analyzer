/** Runs the search and graph traversal comparisons and prints a results table. */
public class PerformanceAnalyzer {

    private static final String LINE = "-------------------------------------------------------------------------";

    public static void run(int n) {
        // Sorted dataset of even numbers: 0, 2, 4, ...
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i * 2;
        }
        int lastTarget = data[n - 1];        // worst case for linear search
        int middleTarget = data[n / 2];
        int missingTarget = -1;              // never present

        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON  (input size n = " + n + ")");
        System.out.println("=============================================");
        System.out.printf("%-24s %-16s %-12s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println(LINE);

        searchRow("Search (last element)", data, lastTarget);
        searchRow("Search (middle element)", data, middleTarget);
        searchRow("Search (not found)", data, missingTarget);

        Graph g = Graph.generateSample(n);
        Graph.TraversalResult bfs = g.bfs("V0");
        Graph.TraversalResult dfs = g.dfs("V0");
        graphRow("Graph Traversal", "BFS", bfs);
        graphRow("Graph Traversal", "DFS", dfs);
        System.out.println(LINE);

        System.out.println("Graph used: " + g.vertexCount() + " vertices, " + g.edgeCount() + " edges.");
        System.out.println("Explanation:");
        System.out.println("  * Linear Search is O(n): in the worst case it checks every element.");
        System.out.println("  * Binary Search is O(log n): it halves the range each step (needs sorted data).");
        System.out.println("  * BFS and DFS are both O(V + E): each vertex and edge is processed once,");
        System.out.println("    so their step counts are similar; only the visiting order differs.");
        System.out.println("  * Time values vary between runs (JVM warm-up, CPU); step counts are exact.");
    }

    private static void searchRow(String label, int[] data, int target) {
        SearchOperations.SearchResult linear = SearchOperations.linearSearch(data, target);
        SearchOperations.SearchResult binary = SearchOperations.binarySearch(data, target);
        System.out.printf("%-24s %-16s %-12d %-12d%n", label, "Linear Search", linear.steps, linear.nanos);
        System.out.printf("%-24s %-16s %-12d %-12d%n", label, "Binary Search", binary.steps, binary.nanos);
        ResultLog.add("Performance [n=" + data.length + "] " + label + ": Linear steps=" + linear.steps
                + ", Binary steps=" + binary.steps);
    }

    private static void graphRow(String label, String name, Graph.TraversalResult r) {
        System.out.printf("%-24s %-16s %-12d %-12d%n", label, name, r.steps, r.nanos);
        ResultLog.add("Performance " + name + " traversal: steps=" + r.steps + ", time=" + r.nanos + " ns");
    }
}
