# Data Structure and Graph Performance Analyzer

**Module:** CIT300 Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 (Week 12)
**Institution:** Sri Lanka Technology Campus (SLTC)

## Project Description

A Java-based, console-driven application that demonstrates the practical use of core data structures (Array, Stack, Queue, Linked List, Graph), searching algorithms (Linear Search, Binary Search) and graph traversals (BFS, DFS). The program also compares the performance of these algorithms by recording the number of steps and the execution time, and relates the results to algorithmic complexity.

## Team Members

### Member 1
- **Student Name:** T. Fathima Afriha
- **Student ID:** 23DA2-0774
- **Assigned Responsibility:** Array and Searching
- **Individual Contribution:**
  - Implemented the Array class (insert, delete, search, display)
  - Implemented Linear Search and Binary Search
  - Added step counting for both search algorithms
  - Added input validation and empty-array handling
  - Tested and integrated the module with the main application

### Member 2
- **Student Name:** A. M. Zulfa Begum
- **Student ID:** 23DA2-0496
- **Assigned Responsibility:** Stack and Queue
- **Individual Contribution:**
  - Implemented the Stack class (push, pop, peek, display)
  - Implemented the Queue class (enqueue, dequeue, peek/front, display)
  - Handled pop from an empty stack and dequeue from an empty queue
  - Tested and integrated the module with the main application

### Member 3
- **Student Name:** A. W. Abdul Rahman
- **Student ID:** 23DA2-0878
- **Assigned Responsibility:** Linked List and Performance Comparison
- **Individual Contribution:**
  - Implemented the Linked List class (insert, delete, search, display)
  - Implemented the Performance Comparison module (steps and execution time)
  - Implemented the "Display All Results" feature
  - Tested and integrated the modules with the main application

### Member 4
- **Student Name:** M. S. Aakil
- **Student ID:** 23DA2-0939
- **Assigned Responsibility:** Graph Component, Main Menu and Integration
- **Individual Contribution:**
  - Implemented the Graph class (add vertex, add edge, display graph)
  - Implemented BFS and DFS traversals
  - Built the main menu and all submenus
  - Integrated all modules into one application and performed system testing

## Technologies Used

- Java (JDK 17 or later recommended)
- Git and GitHub (branches, commits, pull requests)
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or the command line

## Main System Features

- Array operations: insert, delete, search, display
- Stack operations: push, pop, peek, display
- Queue operations: enqueue, dequeue, peek/front, display
- Linked List operations: insert, delete, search, display
- Searching: Linear Search vs Binary Search
- Graph operations: add vertex, add edge, display, BFS, DFS
- Performance comparison table (operation, algorithm, steps, execution time)
- Input validation and handling of empty data structures
- Menu-driven console interface

## Main Menu

```
=============================================
 DATA STRUCTURE & GRAPH ANALYZER
=============================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
```

## Complexity Summary

| Operation | Algorithm | Time Complexity |
|---|---|---|
| Search | Linear Search | O(n) |
| Search | Binary Search (sorted data) | O(log n) |
| Graph Traversal | BFS | O(V + E) |
| Graph Traversal | DFS | O(V + E) |

## How to Run

1. Clone the repository:
   ```
   git clone <repository-url>
   cd <repository-folder>
   ```
2. Compile:
   ```
   mkdir out
   javac -d out src/*.java
   ```
3. Run:
   ```
   java -cp out Main
   ```

Or simply open the `src` folder in IntelliJ IDEA / Eclipse / VS Code and run `Main.java`.

## Project Structure

```
src/
  Main.java                 Main menu, submenus, integration
  ArrayOperations.java      Array (insert, delete, search, display)
  MyStack.java              Stack (push, pop, peek, display)
  MyQueue.java              Queue (enqueue, dequeue, peek, display)
  SinglyLinkedList.java     Linked list
  SearchOperations.java     Linear and binary search
  Graph.java                Graph, BFS, DFS
  PerformanceAnalyzer.java  Performance comparison
  ResultLog.java            Stores results for "Display All Results"
  InputHelper.java          Input validation
```

## Repository Collaboration

Each member worked on an individual branch, made meaningful commits, and merged changes into the main branch through pull requests.
