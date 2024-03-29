import java.util.ArrayList;
import java.util.Scanner;

public class Prims {
        // {0, 0, 355, 0, 0, 0, 0, 695},
        // {0, 0, 74, 0, 0, 0, 348, 0},
        // {355, 74, 0, 262, 0, 0, 269, 0},
        // {0, 0, 262, 0, 0, 0, 242, 0},
        // {0, 0, 0, 0, 0, 230, 306, 0},
        // {0, 0, 0, 0, 230, 0, 83, 0},
        // {0, 348, 269, 242, 306, 83, 0, 151},
        // {695, 0, 0, 0, 0, 0, 151, 0}
    private int [][] graph;
    private int[] vertex = {1, 2, 3, 4, 5, 6, 7, 8};
    private int m = 0;
    private int n = vertex.length;
    private int tmp_v1;
    private int tmp_v2;
    private ArrayList<Integer> tmp_e = new ArrayList<>();
    private int root;
    private boolean [] visited;

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
        visited = new boolean[graph.length];
        System.out.println("------Enter edege in graph------");
        for (int i = 0; i < graph.length; i++){
            System.out.print("Enter num in row " + (i + 1) + " : ");
            for (int j = 0; j < graph[0].length; j++){
                graph[i][j] = sc.nextInt();
            }
        }
        System.out.println("-----Please Enter root node-----");
        System.out.print("Enter root node 1 - 8:");
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
                        visited[i] = true;
                        tmp_v1 = i + 1;
                        tmp_v2 = j + 1;
                        root = j;
                        tmp_e.remove(tmp_e.indexOf(min));
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
        for (int i = 0; i < tmp_e.size(); i++){
            if (tmp_e.get(i) < min){
                min = tmp_e.get(i);
            }
        }
        return min;
    }
    private void getEdge(int n){
        for (int i = 0; i < graph[n].length; i++){
            if (graph[n][i] != 0){
                int tmp = graph[n][i];
                tmp_e.add(tmp);
                
            }
        }
    }
}
