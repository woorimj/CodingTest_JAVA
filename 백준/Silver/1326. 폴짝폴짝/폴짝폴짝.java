import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] bridge;
    public static int[] visited;

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll(); // 현재위치
            int num = bridge[x - 1]; // 현재위치의 징검다리의 숫자값

            // 오른쪽방향
            for (int next = x + num; next <= bridge.length; next += num) {
                if (visited[next] > 0)
                    continue;

                if (next == end) {
                    return visited[x];
                }

                queue.offer(next);
                visited[next] = visited[x] + 1;
            }

            // 왼쪽방향
            for (int next = x - num; next > 0; next -= num) {
                if (visited[next] > 0)
                    continue;

                if (next == end) {
                    return visited[x];
                }

                queue.offer(next);
                visited[next] = visited[x] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1.징검다리 갯수 입력
        int N = Integer.parseInt(st.nextToken());

        // 2.징검다리 정보
        bridge = new int[N];
        visited = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        // 3.시작,도착정보
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 4.징검다리 탐색
        int result;
        if(a == b)
            result = 0;
        else
            result = bfs(a,b);

        System.out.println(result);
    }
}