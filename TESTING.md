# Test Report: Graph, Main, InputHelper, ResultLog

Tester: M.S.M. Aakkil (23DA2-0939)
Tested with: JDK 26, run via `java -cp out Main`

## Graph and Main menu
| Test | Result |
|---|---|
| Compile all files | Pass |
| Load Sample Graph, Display Graph | Pass |
| BFS from A: A -> B -> C -> D -> F -> E (steps=18) | Pass |
| DFS from A: A -> B -> D -> C -> F -> E (steps=18) | Pass |
| Traversal with unknown vertex (Z) | Pass: "Vertex 'Z' does not exist." |
| Invalid menu input (abc, 99) | Pass: no crash |

## InputHelper and ResultLog
| Test | Result |
|---|---|
| Non-numeric input | Pass: asks again |
| Display All Results after BFS and DFS | Pass: both entries listed |
| Display All Results with no results | Pass: "No results recorded yet." |