import java.util.Scanner;

public class Kruskal {
    private int [][] graph;
    private int[] vertex = {1, 2, 3, 4, 5, 6, 7, 8};
    private int m = 0;
    private int n = vertex.length;
    private int tmp_v1;
    private int tmp_v2;
    private boolean [] visited;
    
    public Kruskal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------Kruskal's Program------");
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
        sc.close();
        runKruskal();
    }
    public void runKruskal(){
        while (m < n - 1){
            int min = findMinWeight();
            for (int i = 0; i < graph.length; i++){
                for (int j = 0; j < graph[0].length; j++){
                    if (graph[i][j] == min){
                        graph[i][j] = 0;
                        graph[j][i] = 0;
                        visited[i] = true;
                        tmp_v1 = i + 1;
                        tmp_v2 = j + 1;
                    }
                }
            }
            
            System.out.println("Node " + tmp_v1 + " to Node " + tmp_v2+ " " + min);
            // for (int[] arr : graph){
            //     System.out.println(Arrays.toString(arr));
            // }
            m++;
        }
    }
    public int findMinWeight(){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++){
            // System.out.println("loop i");
            for (int j = 0; j < graph[0].length; j++){
                if (graph[i][j] != 0 && graph[i][j] < min && visited[i] == false){
                    min = graph[i][j];
                }
                
            }
            
        }
        return min;
    }
}
