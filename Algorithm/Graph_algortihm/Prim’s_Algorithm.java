import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class PrimsAlgorithm {

    // Class to represent an edge with its weight
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Function to implement Prim's Algorithm
    public static void primsAlgorithm(int[][] graph) {
        int V = graph.length; // Number of vertices

        // Array to store the minimum weight edge to a vertex
        int[] minEdge = new int[V];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        // Array to keep track of vertices included in MST
        boolean[] inMST = new boolean[V];

        // Priority Queue to select the edge with the minimum weight
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from the first vertex
        minEdge[0] = 0;
        pq.add(new Edge(0, 0));

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            // Get the vertex with the minimum edge weight
            Edge currentEdge = pq.poll();
            int u = currentEdge.dest;

            if (inMST[u]) {
                continue; // Skip if the vertex is already included in MST
            }

            // Include the vertex in MST
            inMST[u] = true;
            totalWeight += currentEdge.weight;

            // Explore adjacent vertices
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < minEdge[v]) {
                    minEdge[v] = graph[u][v];
                    pq.add(new Edge(v, minEdge[v]));
                }
            }
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primsAlgorithm(graph);
    }
}
