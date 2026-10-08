import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/** Undirected graph stored as an adjacency list, with BFS and DFS. */
public class Graph {

    /** Outcome of one traversal. */
    public static class TraversalResult {
        public final List<String> order;
        public final int steps; // vertices visited + edges examined
        public final long nanos;

        public TraversalResult(List<String> order, int steps, long nanos) {
            this.order = order;
            this.steps = steps;
            this.nanos = nanos;
        }
    }

    private final Map<String, List<String>> adjacency = new LinkedHashMap<>();

    public boolean isEmpty() { return adjacency.isEmpty(); }
    public boolean hasVertex(String v) { return adjacency.containsKey(v); }
    public int vertexCount() { return adjacency.size(); }

    public int edgeCount() {
        int total = 0;
        for (List<String> neighbours : adjacency.values()) {
            total += neighbours.size();
        }
        return total / 2;
    }

    /** Adds a vertex. Returns false if it already exists. */
    public boolean addVertex(String v) {
        if (v == null || v.isBlank() || adjacency.containsKey(v)) return false;
        adjacency.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge. Returns false for unknown vertices, self loops or duplicates. */
    public boolean addEdge(String a, String b) {
        if (!adjacency.containsKey(a) || !adjacency.containsKey(b)) return false;
        if (a.equals(b) || adjacency.get(a).contains(b)) return false;
        adjacency.get(a).add(b);
        adjacency.get(b).add(a);
        return true;
    }

    public String firstVertex() {
        return adjacency.keySet().iterator().next();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Graph is empty.");
            return;
        }
        System.out.println("Graph (" + vertexCount() + " vertices, " + edgeCount() + " edges):");
        for (Map.Entry<String, List<String>> entry : adjacency.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    /** Breadth-first search using a queue. O(V + E). */
    public TraversalResult bfs(String start) {
        long begin = System.nanoTime();
        int steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            steps++;
            for (String neighbour : adjacency.get(current)) {
                steps++;
                if (visited.add(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - begin);
    }

    /** Depth-first search using a stack (iterative, safe for large graphs). O(V + E). */
    public TraversalResult dfs(String start) {
        long begin = System.nanoTime();
        int steps = 0;
        List<String> order = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.add(current)) continue;
            order.add(current);
            steps++;
            List<String> neighbours = adjacency.get(current);
            // Push in reverse so the first neighbour is explored first.
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                steps++;
                if (!visited.contains(neighbours.get(i))) {
                    stack.push(neighbours.get(i));
                }
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - begin);
    }

    /** Builds a connected sample graph with n vertices (V0, V1, ...) for performance tests. */
    public static Graph generateSample(int n) {
        Graph g = new Graph();
        java.util.Random random = new java.util.Random(42);
        for (int i = 0; i < n; i++) {
            g.addVertex("V" + i);
        }
        for (int i = 0; i < n - 1; i++) {      // chain keeps the graph connected
            g.addEdge("V" + i, "V" + (i + 1));
        }
        for (int i = 0; i < n; i++) {          // extra random edges
            g.addEdge("V" + random.nextInt(n), "V" + random.nextInt(n));
        }
        return g;
    }
}
