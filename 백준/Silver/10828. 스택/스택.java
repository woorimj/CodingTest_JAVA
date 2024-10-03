import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] stack;
    static int size = 0;
    static int N;

    public static void push(int num) {
        stack[size++] = num;
    }

    public static int pop() {
        return (size == 0) ? -1 : stack[--size];
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return (size == 0) ? 1 : 0;
    }

    public static int top() {
        return (size == 0) ? -1 : stack[size - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        stack = new int[N];

        StringTokenizer st;
        while (N > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
            }
            N--;
        }
    }
}
