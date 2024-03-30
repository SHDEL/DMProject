import java.util.Arrays;
import java.util.Scanner;
public class FiniteAutomaton {
    private String [] inputState;
    private String[][] graph = {
        {"1", "0", "-1"}, //s0
        {"-1", "0", "1"}, //s1
        {"1", "0", "-1"}, //s2
    };
    private boolean acceptState = false;
    public FiniteAutomaton(){
        homeProgram();
    }
    public boolean accept(String input) {
        inputState = input.split(" ");
        int root = 0; // s1
        while (acceptState == false){
            for (int i = 0; i < inputState.length; i++){
                for (int j = 0; j < graph[root].length; j++){
                    if ((root == 1) && (i == inputState.length - 1)){
                        if (inputState[i].equals(graph[root][j])){
                            root = j;
                            if (root == 2){
                                acceptState = true;
                                break;
                            }
                        }
                    }
                    else if (inputState[i].equals(graph[root][j])){
                        acceptState = false;
                        root = j;
                        break;
                    }
                }
            }
            if (acceptState){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public void homeProgram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Finite Automaton Program------");
        System.out.println("Graph(From slide DM10 P.14): ");
        for (String[] arr : graph){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("*Enter the set with 0 and 1 and white space between letters*");
        System.out.print("Enter set: ");
        String input = sc.nextLine();
        if (accept(input)){
            System.out.println(input + " is Accepted");
        }
        else{
            System.out.println(input +  " is Rejected");
        }
        sc.close();
        
        
        
    }
}