
public class Kruskal {
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
    int[] vertex = {1, 2, 3, 4, 5, 6, 7, 8};
    int m = 0;
    int n = vertex.length;
    int tmp_v1;
    int tmp_v2;
    int tmp_e;

    boolean [] visited = new boolean[graph.length];
    boolean finish = false;
    
    public Kruskal(){
        System.out.println("--------Kruskal's Program------");
        // System.out.println("Enter node 0 - 8 ");
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
