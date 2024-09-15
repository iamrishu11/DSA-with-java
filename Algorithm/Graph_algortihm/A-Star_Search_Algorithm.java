import java.util.*;

class Node {
    public final String name;
    public final int gCost; // Cost from start node to this node
    public final int hCost; // Heuristic cost from this node to the goal
    public final Node parent;

    public Node(String name, int gCost, int hCost, Node parent) {
        this.name = name;
        this.gCost = gCost;
        this.hCost = hCost;
        this.parent = parent;
    }

    public int fCost() {
        return gCost + hCost;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Graph {
    private final Map<String, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String name) {
        adjacencyList.putIfAbsent(name, new ArrayList<>());
    }

    public void addEdge(String from, String to, int cost, int heuristic) {
        addNode(from);
        addNode(to);
        adjacencyList.get(from).add(new Node(to, cost, heuristic, null));
    }

    public List<Node> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, new ArrayList<>());
    }

    public int getHeuristic(String node, String goal) {
        // In a real scenario, you would calculate heuristic here
        // For simplicity, we are using heuristic passed in addEdge
        return 0; // You should adjust this to use your heuristic function
    }
}

public class AStarSearch {

    public static List<String> aStarSearch(Graph graph, String start, String goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::fCost));
        Set<String> closedSet = new HashSet<>();
        Map<String, Node> allNodes = new HashMap<>();

        Node startNode = new Node(start, 0, graph.getHeuristic(start, goal), null);
        openSet.add(startNode);
        allNodes.put(start, startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.name.equals(goal)) {
                return reconstructPath(current);
            }

            closedSet.add(current.name);

            for (Node neighbor : graph.getNeighbors(current.name)) {
                if (closedSet.contains(neighbor.name)) continue;

                int tentativeGCost = current.gCost + neighbor.gCost;
                Node neighborNode = allNodes.get(neighbor.name);

                if (neighborNode == null || tentativeGCost < neighborNode.gCost) {
                    neighborNode = new Node(neighbor.name, tentativeGCost, graph.getHeuristic(neighbor.name, goal), current);
                    allNodes.put(neighbor.name, neighborNode);
                    openSet.add(neighborNode);
                }
            }
        }

        return Collections.emptyList(); // Path not found
    }

    private static List<String> reconstructPath(Node goalNode) {
        List<String> path = new ArrayList<>();
        for (Node node = goalNode; node != null; node = node.parent) {
            path.add(node.name);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 1, 2);
        graph.addEdge("A", "C", 4, 1);
        graph.addEdge("B", "C", 2, 1);
        graph.addEdge("B", "D", 5, 0);
        graph.addEdge("C", "D", 1, 0);

        List<String> path = aStarSearch(graph, "A", "D");
        System.out.println("Path: " + path);
    }
}
