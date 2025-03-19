import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static void bfs(int A, int K) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[K + 1];

        queue.add(A);
        visited[A] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int n = queue.poll();

                if (n == K) {
                    System.out.println(count);
                    return;
                }
                if (n + 1 <= K && !visited[n + 1]) {
                    queue.add(n + 1);
                    visited[n + 1] = true;
                }
                if (n * 2 <= K && !visited[n * 2]) {
                    queue.add(n * 2);
                    visited[n * 2] = true;
                }
            }
            count++;
        }
    }
    
    public static void main (String[]args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int K = sc.nextInt();
        bfs(A, K);
    }
}