import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] target = queue.poll();

            int nodes = target[0];
            int level = target[1];

            if (level >= 2)
                continue;

            for (int node : graph.get(nodes)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(new int[]{node, level + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력받기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 2. 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 3. BFS-그래프 탐색
        visited = new boolean[N + 1];
        bfs(1);

        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (visited[i])
                count++;
        }
        System.out.println(count - 1);
    }
}