import java.util.Arrays;

/** Entry point: main menu and all submenus (integration of every component). */
public class Main {

    private static final ArrayOperations array = new ArrayOperations(20);
    private static final MyStack stack = new MyStack(5);
    private static final MyQueue queue = new MyQueue(5);
    private static final SinglyLinkedList list = new SinglyLinkedList();
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: ResultLog.displayAll(); break;
                case 9:
                    System.out.println("Thank you for using the analyzer. Goodbye!");
                    running = false;
                    break;
                default: System.out.println("Invalid choice. Please select 1-9.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------------------------------------------------------------- ARRAY
    private static void arrayMenu() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at End");
            System.out.println("2. Insert at Index");
            System.out.println("3. Delete by Index");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search (Linear)");
            System.out.println("6. Sort Array");
            System.out.println("7. Fill with Random Numbers");
            System.out.println("8. Display Array");
            System.out.println("9. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value: ");
                    System.out.println(array.insert(value) ? "Inserted." : "Array is full.");
                    break;
                }
                case 2: {
                    int index = InputHelper.readInt("Enter index: ");
                    int value = InputHelper.readInt("Enter value: ");
                    System.out.println(array.insertAt(index, value) ? "Inserted."
                            : "Cannot insert (invalid index or array full).");
                    break;
                }
                case 3: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int index = InputHelper.readInt("Enter index to delete: ");
                    System.out.println(array.deleteAt(index) ? "Deleted." : "Invalid index.");
                    break;
                }
                case 4: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int value = InputHelper.readInt("Enter value to delete: ");
                    System.out.println(array.deleteValue(value) ? "Deleted." : "Value not found.");
                    break;
                }
                case 5: {
                    if (array.isEmpty()) { System.out.println("Array is empty."); break; }
                    int target = InputHelper.readInt("Enter value to search: ");
                    SearchOperations.SearchResult r = SearchOperations.linearSearch(array.toArray(), target);
                    SearchOperations.printResult("Linear Search", target, r);
                    ResultLog.add("Array linear search for " + target + ": index=" + r.index + ", steps=" + r.steps);
                    break;
                }
                case 6:
                    array.sort();
                    System.out.println("Array sorted.");
                    break;
                case 7: {
                    int count = InputHelper.readIntInRange("How many numbers (1-" + array.capacity() + ")? ",
                            1, array.capacity());
                    array.fillRandom(count, 100);
                    System.out.println("Array filled with " + count + " random numbers (1-100).");
                    break;
                }
                case 8: array.display(); break;
                case 9: return;
                default: System.out.println("Invalid choice. Please select 1-9.");
            }
        }
    }

    // ---------------------------------------------------------------- STACK
    private static void stackMenu() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS (capacity 5) ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value to push: ");
                    if (stack.push(value)) System.out.println("Pushed " + value);
                    break;
                }
                case 2: {
                    Integer popped = stack.pop();
                    if (popped != null) {
                        System.out.println("Popped " + popped);
                        ResultLog.add("Stack pop returned " + popped);
                    }
                    break;
                }
                case 3: {
                    Integer top = stack.peek();
                    if (top != null) System.out.println("Top element: " + top);
                    break;
                }
                case 4: stack.display(); break;
                case 5: return;
                default: System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    // ---------------------------------------------------------------- QUEUE
    private static void queueMenu() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS (capacity 5) ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    int value = InputHelper.readInt("Enter value to enqueue: ");
                    if (queue.enqueue(value)) System.out.println("Enqueued " + value);
                    break;
                }
                case 2: {
                    Integer removed = queue.dequeue();
                    if (removed != null) {
                        System.out.println("Dequeued " + removed);
                        ResultLog.add("Queue dequeue returned " + removed);
                    }
                    break;
                }
                case 3: {
                    Integer front = queue.peek();
                    if (front != null) System.out.println("Front element: " + front);
                    break;
                }
                case 4: queue.display(); break;
                case 5: return;
                default: System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }

    // ---------------------------------------------------------- LINKED LIST
    private static void linkedListMenu() {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete by Value");
            System.out.println("5. Search");
            System.out.println("6. Display");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    list.insertFirst(InputHelper.readInt("Enter value: "));
                    System.out.println("Inserted at beginning.");
                    break;
                }
                case 2: {
                    list.insertLast(InputHelper.readInt("Enter value: "));
                    System.out.println("Inserted at end.");
                    break;
                }
                case 3: {
                    int position = InputHelper.readInt("Enter position (1-" + (list.size() + 1) + "): ");
                    int value = InputHelper.readInt("Enter value: ");
                    System.out.println(list.insertAt(position, value) ? "Inserted." : "Invalid position.");
                    break;
                }
                case 4: {
                    if (list.isEmpty()) { System.out.println("Linked list is empty."); break; }
                    int value = InputHelper.readInt("Enter value to delete: ");
                    System.out.println(list.deleteValue(value) ? "Deleted." : "Value not found.");
                    break;
                }
                case 5: {
                    if (list.isEmpty()) { System.out.println("Linked list is empty."); break; }
                    int value = InputHelper.readInt("Enter value to search: ");
                    int[] result = list.search(value);
                    if (result[0] > 0) {
                        System.out.println("Found at position " + result[0] + " (steps = " + result[1] + ")");
                    } else {
                        System.out.println("Not found (steps = " + result[1] + ")");
                    }
                    ResultLog.add("Linked list search for " + value + ": position=" + result[0]
                            + ", steps=" + result[1]);
                    break;
                }
                case 6: list.display(); break;
                case 7: return;
                default: System.out.println("Invalid choice. Please select 1-7.");
            }
        }
    }

    // ------------------------------------------------------------ SEARCHING
    private static void searchingMenu() {
        while (true) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("(Searches work on the array from the Array menu)");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search (array must be sorted)");
            System.out.println("3. Compare Linear vs Binary");
            System.out.println("4. Display Array");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            if (choice == 5) return;
            if (choice == 4) { array.display(); continue; }
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please select 1-5.");
                continue;
            }
            if (array.isEmpty()) {
                System.out.println("Array is empty. Add elements in the Array menu first.");
                continue;
            }
            int[] data = array.toArray();
            int target = InputHelper.readInt("Enter value to search: ");
            if (choice == 1) {
                SearchOperations.SearchResult r = SearchOperations.linearSearch(data, target);
                SearchOperations.printResult("Linear Search", target, r);
                ResultLog.add("Linear search for " + target + ": index=" + r.index + ", steps=" + r.steps);
            } else if (choice == 2) {
                if (!SearchOperations.isSorted(data)) {
                    System.out.println("Array is not sorted. Sort it first (Array menu option 6).");
                    continue;
                }
                SearchOperations.SearchResult r = SearchOperations.binarySearch(data, target);
                SearchOperations.printResult("Binary Search", target, r);
                ResultLog.add("Binary search for " + target + ": index=" + r.index + ", steps=" + r.steps);
            } else {
                int[] sorted = Arrays.copyOf(data, data.length);
                Arrays.sort(sorted); // binary search runs on a sorted copy
                SearchOperations.SearchResult linear = SearchOperations.linearSearch(data, target);
                SearchOperations.SearchResult binary = SearchOperations.binarySearch(sorted, target);
                SearchOperations.printResult("Linear Search", target, linear);
                SearchOperations.printResult("Binary Search (sorted copy)", target, binary);
                ResultLog.add("Compare search for " + target + ": Linear steps=" + linear.steps
                        + ", Binary steps=" + binary.steps);
            }
        }
    }

    // ---------------------------------------------------------------- GRAPH
    private static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    String v = InputHelper.readText("Enter vertex name: ");
                    System.out.println(graph.addVertex(v) ? "Vertex added." : "Vertex already exists.");
                    break;
                }
                case 2: {
                    if (graph.vertexCount() < 2) {
                        System.out.println("Add at least 2 vertices first.");
                        break;
                    }
                    String a = InputHelper.readText("Enter first vertex: ");
                    String b = InputHelper.readText("Enter second vertex: ");
                    System.out.println(graph.addEdge(a, b) ? "Edge added."
                            : "Cannot add edge (unknown vertex, same vertex, or edge exists).");
                    break;
                }
                case 3: graph.display(); break;
                case 4: traverse(true); break;
                case 5: traverse(false); break;
                case 6: {
                    String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"C", "D"}, {"D", "E"}, {"C", "F"}};
                    for (String v : new String[]{"A", "B", "C", "D", "E", "F"}) graph.addVertex(v);
                    for (String[] e : edges) graph.addEdge(e[0], e[1]);
                    System.out.println("Sample graph loaded (A-F).");
                    break;
                }
                case 7: return;
                default: System.out.println("Invalid choice. Please select 1-7.");
            }
        }
    }

    private static void traverse(boolean useBfs) {
        if (graph.isEmpty()) {
            System.out.println("Graph is empty. Add vertices first.");
            return;
        }
        String start = InputHelper.readText("Enter start vertex: ");
        if (!graph.hasVertex(start)) {
            System.out.println("Vertex '" + start + "' does not exist.");
            return;
        }
        String name = useBfs ? "BFS" : "DFS";
        Graph.TraversalResult r = useBfs ? graph.bfs(start) : graph.dfs(start);
        System.out.println(name + " order: " + String.join(" -> ", r.order));
        System.out.println("Steps = " + r.steps + " | time = " + r.nanos + " ns");
        ResultLog.add(name + " from " + start + ": " + String.join(" -> ", r.order)
                + " (steps=" + r.steps + ")");
    }

    // ---------------------------------------------------------- PERFORMANCE
    private static void performanceMenu() {
        int n = InputHelper.readIntInRange("Enter input size n (10 - 1000000): ", 10, 1000000);
        PerformanceAnalyzer.run(n);
    }
}
