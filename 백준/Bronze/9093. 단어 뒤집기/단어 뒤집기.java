import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        Stack<Character> stack = new Stack<Character>();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < T; j++) {
            String str = sc.nextLine() + " ";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(str.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());

        sc.close();
    }
}


