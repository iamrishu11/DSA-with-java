import java.util.Arrays;

class Graph {
    private int vertices; 
    private Edge[] edges;

    // Inner class to represent an edge
    class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    Graph(int vertices, int edgesCount) {
        this.vertices = vertices;
        edges = new Edge[edgesCount];
    }

    // Method to add an edge to the graph
    void addEdge(int index, int src, int dest, int weight) {
        edges[index] = new Edge(src, dest, weight);
    }

    // Method to implement Bellman-Ford algorithm
    void bellmanFord(int startVertex) {
        int V = vertices;
        int E = edges.length;

        // Step 1: Initialize distances from startVertex to all other vertices as INFINITE
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        // Step 2: Relax all edges |V| - 1 times
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (distances[u] != Integer.MAX_VALUE && distances[u] + weight < distances[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the distance array
        printSolution(distances);
    }

    // Method to print the solution
    private void printSolution(int[] distances) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;  // Number of vertices
        int E = 8;  // Number of edges

        Graph graph = new Graph(V, E);

        // Adding edges (src, dest, weight)
        graph.addEdge(0, 0, 1, -1);
        graph.addEdge(1, 0, 2, 4);
        graph.addEdge(2, 1, 3, 2);
        graph.addEdge(3, 1, 4, 1);
        graph.addEdge(4, 1, 2, 5);
        graph.addEdge(5, 3, 2, 5);
        graph.addEdge(6, 4, 3, 5);
        graph.addEdge(7, 4, 0, 2);

        int startVertex = 0;
        graph.bellmanFord(startVertex);
    }
}
