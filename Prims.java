import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Prims {

    private int [][] graph;
    private int[] vertex;
    private int m = 0;
    private int n;
    private int tmp_v1;
    private int tmp_v2;
    private int root;
    private HashMap<Integer,String> visited = new HashMap<>();

    public Prims(){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Prim's Program-------");
        System.out.println("*Enter row and col for Graph*");
        System.out.print("row: ");
        int row = sc.nextInt();
        System.out.println();
        System.out.print("col: ");
        int col = sc.nextInt();
        graph = new int[row][col];
        System.out.println("------Enter edege in graph------");
        for (int i = 0; i < graph.length; i++){
            System.out.print("Enter num in row " + (i + 1) + " : ");
            for (int j = 0; j < graph[0].length; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        vertex = new int[graph.length];
        n = vertex.length;
        System.out.println("-----Please Enter root node-----");
        System.out.print("Enter root node 1 - 8: ");
        root = sc.nextInt();
        root--;
        sc.close();
        runPrims();
    }
    private void runPrims(){
        while (m < n - 1){
            int min = findMin(root);
            for (int i = root; i < graph.length; i++){
                for (int j = 0; j < graph[0].length; j++){
                    if (graph[i][j] == min){
                        graph[i][j] = 0;
                        graph[j][i] = 0;
                        visited.remove(min);
                        tmp_v1 = i + 1;
                        tmp_v2 = j + 1;
                        root = j;
                        break;
                    }
                }
            }
            System.out.println("Node " + tmp_v1 + " to Node " + tmp_v2+ " " + min);
            m++;
        }
    }
    
    private int findMin(int n){
        getEdge(n);
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, String> set : visited.entrySet()){
            if (set.getKey() < min && set.getValue().equals("false")){
                min = set.getKey();
            }
        }
        return min;
    }
    private void getEdge(int n){
        for (int i = 0; i < graph[n].length; i++){
            if (graph[n][i] != 0){
                int tmp = graph[n][i];
                visited.put(tmp, "false");
                
            }
        }
    }
}
