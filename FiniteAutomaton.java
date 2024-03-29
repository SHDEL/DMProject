
import java.util.Arrays;
import java.util.Scanner;


public class FiniteAutomaton {
    private int state;
    private int[][] table = {{1, 0}, {1, 2}, {1, 0}, {3, 0}, {1, 4}, {5, 0}};
    private int[] acceptState = {4};

    public FiniteAutomaton(){
        this.state = 0;
        homeProgram();
    }
    public boolean accept(String input) {
        for (char symbol : input.toCharArray()) {
            char [] list = input.toCharArray();
            System.out.println("in for loop " + Arrays.toString(list));
            int inputIndex;
            if (symbol == '0') {
                inputIndex = 0;
            } 
            else if (symbol == '1') {
                inputIndex = 1;
            } 
            else {
                return false;
            }
            state = table[state][inputIndex];
            System.out.println("state: " + state);
            
        }
        for (int acceptingState : acceptState) {
            if (state == acceptingState) {
                return true;
            }
        }
        System.out.println("check accetpt");   
        return false;
    }
    public void homeProgram() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Finite Automaton Program------");
        System.out.println("*Enter the set with 0 and 1 and enter 9 to stop*");
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