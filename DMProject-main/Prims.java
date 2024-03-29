import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prims {
    int [][] graph = {
        
        //1   2  3  4  5  6  7  8
        {0, 0, 355, 0, 0, 0, 0, 695},
        {0, 0, 74, 0, 0, 0, 348, 0},
        {355, 74, 0, 262, 0, 0, 269, 0},
        {0, 0, 262, 0, 0, 0, 242, 0},
        {0, 0, 0, 0, 0, 230, 306, 0},
        {0, 0, 0, 0, 230, 0, 83, 0},
        {0, 348, 269, 242, 306, 83, 0, 151},
        {695, 0, 0, 0, 0, 0, 151, 0}
    };
    private int[] vertex = {1, 2, 3, 4, 5, 6, 7, 8};
    private int m = 0;
    private int n = vertex.length;
    private int tmp_v1;
    private int tmp_v2;
    private ArrayList<Integer> tmp_e = new ArrayList<>();
    private int root = 0;
    private boolean [] visited = new boolean[graph.length];

    public Prims(){
        System.out.println("-------Prim's Program-------");
        
        runPrims();
        // findMin(root);
    }
    public void runPrims(){
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
            // System.out.println("TMP E after remove: " + tmp_e);
            System.out.println("Node " + tmp_v1 + " to Node " + tmp_v2+ " " + min);
            // for (int[] arr : graph){
            //     System.out.println(Arrays.toString(arr));
            // }
            m++;
        }
    }
    public int findMin(int n){
        getVertex(n);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tmp_e.size(); i++){
            if (tmp_e.get(i) < min && visited[n] == false){
                min = tmp_e.get(i);
            }
        }
        // System.out.println(tmp_e);
        return min;
    }
    public void getVertex(int n){
        for (int i = 0; i < graph[n].length; i++){
            if (graph[n][i] != 0){
                int tmp = graph[n][i];
                tmp_e.add(tmp);
                // tmp_e.stream().distinct().collect(Collectors.toList());
                
            }
        }
    }
}
