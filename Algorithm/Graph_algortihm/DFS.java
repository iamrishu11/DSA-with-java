import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> adjList;

    public DFS(int vertices) {
        adjList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(start, visited);
    }

    private void dfsUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");
        for (int neighbor : adjList.get(v)) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal (starting from vertex 2):");
        graph.dfs(2);
    }
}
