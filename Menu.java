// import java.lang.reflect.Array;
import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Discrete Mathematics Program-------");
        System.out.println("*please enter number to select menu*");
        String [] menu = {"Kruskal's Algorithm", "Prim's Alogorithm", "Dijkstra's Shortest Path", "Finite Automaton"};
        for (int i = 0; i < 4; i++){
            System.out.printf("%s   %s%n", i + 1, menu[i]);
        }
        System.out.print("Enter number to select: ");
        int ans = sc.nextInt();
        run(ans);
        sc.close();
    }
    public static void run(int n){
        switch (n) {
            case 1:
                new Kruskal();
                break;
        
            case 2:
                new Prims();
                break;
            case 3:
            new ShortestPath();
                break;
            case 4:
                new FiniteAutomaton();
                break;
            default:

                break;
        }
    }
}