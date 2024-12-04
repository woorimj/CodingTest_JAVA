import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] land;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int dfs(int x, int y) {
        visited[x][y] = true;

        int size = 1; // 시작을 먼저 포함

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (land[nx][ny] == 0 && !visited[nx][ny])
                    size += dfs(nx, ny);
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N*N 크기의 땅
        M = Integer.parseInt(st.nextToken()); // 가지고 있는 버섯 포자의 개수
        K = Integer.parseInt(st.nextToken()); // 최대 연결된 칸의 개수

        land = new int[N][N];
        visited = new boolean[N][N];

        // 땅 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int usedCount = 0; // 사용한 포자 수
        boolean usedSeed = false;  // 포자사용 여부

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    int size = dfs(i, j);
                    int count = size / K;
                    if(size % K != 0)
                        count++;

                    usedCount += count;

                    if (count > 0) {
                        usedSeed = true;
                    }

                    // 사용가능 포자의 수보다 많은 경우
                    if (usedCount > M) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
            }
        }

        // 포자를 아예 사용하지 않은 경우
        if (!usedSeed) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M - usedCount);
        }
    }
}