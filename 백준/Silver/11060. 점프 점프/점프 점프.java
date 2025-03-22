import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int bfs(int[] A, int N) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[N];
        int[] jumps = new int[N];

        queue.offer(0);
        visited[0] = true;
        jumps[0] = 0;

        while (!queue.isEmpty()) {
            int target = queue.poll();

            // 도착하면
            if (target == N - 1) {
                return jumps[target];
            }

            // 탐색
            int maxJump = target + A[target];
            for (int i = target + 1; i <= maxJump && i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    jumps[i] = jumps[target] + 1;
                    queue.offer(i);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(bfs(A, N));
    }
}
