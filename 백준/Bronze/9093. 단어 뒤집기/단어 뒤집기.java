import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        Stack<Character> stack = new Stack<Character>();
        sc.nextLine(); 

        StringBuilder result = new StringBuilder();
        
        for (int j = 0; j < num; j++) {
            String input = sc.nextLine() + " "; 
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(" "); 
                } else {
                    stack.push(input.charAt(i)); 
                }
            }
            result.append("\n");
        }
        System.out.print(result.toString());
        sc.close();
    }
}

