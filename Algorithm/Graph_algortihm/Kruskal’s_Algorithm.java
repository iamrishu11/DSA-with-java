import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class UnionFind {
    private int[] parent, rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); // Path compression
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }
}

public class KruskalAlgorithm {
    public static void kruskal(int vertices, List<Edge> edges) {
        Collections.sort(edges); // Sort edges based on weight
        UnionFind uf = new UnionFind(vertices);

        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int root1 = uf.find(edge.source);
            int root2 = uf.find(edge.destination);

            if (root1 != root2) {
                mst.add(edge);
                uf.union(root1, root2);
            }
        }

        // Print the MST
        int totalWeight = 0;
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int vertices = 4;
        List<Edge> edges = new ArrayList<>();
        
        // Add edges: (source, destination, weight)
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        
        kruskal(vertices, edges);
    }
}
