import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static int[] visited = new int[100001];

    public static int[] dx = {-1, 1, 2}; // 좌우, 2배

    // 너비우선탐색
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll(); // 현재위치

            // 3가지 방향 계산
            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                if (i == 2)
                    nx = x * dx[i];

                // 동생 위치에 도착하면
                if(nx == K){
                    return visited[x];
                }

                // 방향계산 경계
                if(nx >= 0 && nx < visited.length && visited[nx] == 0){
                    queue.offer(nx);
                    visited[nx] = visited[x] + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 두명의 위치 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result;
        //2. bfs탐색 <- 여기서 지금 현재위치가 같을 때를 먼저 처리해줘여됨
        if(N == K)
            result = 0;
        else
            result = bfs(N);

        //3. 출력
        System.out.println(result);

    }
}
