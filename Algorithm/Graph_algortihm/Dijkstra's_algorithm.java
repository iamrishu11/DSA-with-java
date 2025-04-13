import java.util.Arrays;
import java.util.PriorityQueue;
 
public class DijkstraAlgorithm {

    // A utility class to represent a node and its distance
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
 
        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Function to perform Dijkstra's algorithm
    public static void dijkstra(int[][] graph, int startVertex) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        // Initialize distances with infinity and visited array with false
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        // Priority queue to select the node with the minimum distance
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            // Get the vertex with the smallest distance
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;

            // If already visited, skip
            if (visited[currentVertex]) continue;

            // Mark the vertex as visited
            visited[currentVertex] = true;

            // Update distances to adjacent vertices
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (graph[currentVertex][neighbor] > 0 && !visited[neighbor]) {
                    int newDist = distances[currentVertex] + graph[currentVertex][neighbor];
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        priorityQueue.add(new Node(neighbor, newDist));
                    }
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable.");
            } else {
                System.out.println("Distance to vertex " + i + ": " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 7, 9, 0, 0, 14},
            {7, 0, 10, 15, 0, 0},
            {9, 10, 0, 11, 0, 2},
            {0, 15, 11, 0, 6, 0},
            {0, 0, 0, 6, 0, 9},
            {14, 0, 2, 0, 9, 0}
        };

        dijkstra(graph, 0); // Find shortest paths from vertex 0
    }
}
