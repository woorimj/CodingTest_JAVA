import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, K;
    public static  int[][] graph;
    public static boolean[][] visited;

    // 방향백터 {좌,우 하,상}
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        // 상하좌우를 비교하면서 방문 처리하는 로직
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고, 아직 방문하지 않았으며, 연결된 1인 경우만 탐색
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int count = 0; // 총 지렁이의 개수

            // 2. 배추밭 정보(M:가로, N:세로, K:배추개수)
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 초기화
            graph = new int[M][N];
            visited = new boolean[M][N];

            // 3. K개의 좌표 입력받아 좌표의 값을 1로설정
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            // 4. DFS 배추밭 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            // 5.출력
            System.out.println(count);
        }
    }
}
