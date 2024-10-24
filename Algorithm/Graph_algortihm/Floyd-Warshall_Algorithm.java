public class FloydWarshall {

    // Define infinity as a large number
    private static final int INF = Integer.MAX_VALUE;

    // Function to implement the Floyd-Warshall algorithm
    public static void floydWarshall(int[][] graph) {
        int V = graph.length; // Number of vertices

        // Initialize distance matrix with the given graph weights
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Main Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the resulting shortest distance matrix
        printSolution(dist);
    }

    // Function to print the shortest distance matrix
    private static void printSolution(int[][] dist) {
        int V = dist.length;
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Main method to test the Floyd-Warshall algorithm
    public static void main(String[] args) {
        // Example graph (adjacency matrix)
        // INF indicates no direct edge between the nodes
        int[][] graph = {
            {0, 3, INF, INF, INF, INF},
            {INF, 0, INF, 7, INF, INF},
            {INF, INF, 0, INF, INF, 2},
            {INF, INF, INF, 0, 2, INF},
            {INF, INF, INF, INF, 0, 1},
            {INF, INF, INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}

