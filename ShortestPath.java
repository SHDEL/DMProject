import java.util.*;

public class ShortestPath {
    private static final int INF = Integer.MAX_VALUE;
    
    public ShortestPath() {
        Scanner scanner = new Scanner(System.in);
        
        // ใส่จำนวนจุด
        System.out.print("Enter the number of Vertex: ");
        int n = scanner.nextInt();
        
        // ใส่ชื่อจุด
        String[] nodeNames = new String[n];
        System.out.println("Enter the name of each vertex: ");
        for (int i = 0; i < n; i++) {
            nodeNames[i] = scanner.next();
        }
        
        // ใส่กราฟ ด้วย matrix
        int[][] graph = new int[n][n];
        System.out.println("Enter the distance between vertex (metrix): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        
        // รับจุดต้นทาง
        System.out.print("Enter the source vertex (Starting vertex): ");
        String srcName = scanner.next();
        int src = findNodeIndex(nodeNames, srcName);
        
        dijkstra(graph, src, nodeNames);
        
        scanner.close();
    }

    private static int findNodeIndex(String[] nodeNames, String nodeName) {
        for (int i = 0; i < nodeNames.length; i++) {
            if (nodeNames[i].equals(nodeName)) {
                return i;
            }
        }
        return -1; // ถ้าไม่เจอชื่อจุดที่ใส่
    }

    private static void dijkstra(int[][] graph, int src, String[] nodeNames) {
        int V = graph.length;
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printSolution(dist, parent, nodeNames);
    }

    private static int minDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private static void printSolution(int[] dist, int[] parent, String[] nodeNames) {
        System.out.println("Vertex \t\t Distance from Source \t Path");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(nodeNames[i] + " \t\t " + dist[i] + "\t\t\t");
            printPath(parent, i, nodeNames);
            System.out.println();
        }
    }

    private static void printPath(int[] parent, int j, String[] nodeNames) {
        if (parent[j] == -1) {
            System.out.print(nodeNames[j]);
            return;
        }
        printPath(parent, parent[j], nodeNames);
        System.out.print(" -> " + nodeNames[j]);
    }
}
