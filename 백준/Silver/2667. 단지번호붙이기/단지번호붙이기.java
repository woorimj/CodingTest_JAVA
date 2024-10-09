import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static int N;
    public static int[][] graph;
    public static boolean[][] visited;

    // 방향백터 {좌,우 하,상}
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // 단지별 집의 개수
    public static ArrayList<Integer> houseCounts = new ArrayList<>(); // 단지별 집 개수 저장 리스트


    public static int dfs(int x, int y){
        visited[x][y] = true;
        int count = 1;

        // 상하좌우를 비교하면서 방문 처리하는 로직..
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있고, 아직 방문하지 않았으며, 연결된 1인 경우만 탐색
            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }

    public static void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0; // 총 단지 개수

        //1. 정사각형의 크기 입력
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        // 2. 0과 1로 구성된 지도 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        // 3. DFS 단지 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int count = dfs(i, j); // DFS 수행
                    houseCounts.add(count);
                    result++; // 단지 개수 증가
                }
            }
        }

        // 출력 부분
        System.out.println(result);
        Collections.sort(houseCounts);
        for (int count : houseCounts) {
            System.out.println(count); // 단지별 집 개수 출력
        }
    }
}
