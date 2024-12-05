import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static char[][] colors;
    public static boolean[][] visited;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y, boolean isColor) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작노드 큐에 넣음
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        char currentColor = colors[x][y];
        while (!queue.isEmpty()) {

            int[] q = queue.poll();

            // 그 다음 노드 탐색하면서 방향더하기
            for (int i = 0; i < 4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];

                // 범위를 벗어나는지 확인
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                // 적록색약 여부로 달라짐
                if (isColor) {
                    // 적록색약 -> R/G가 같은 색상으로 간주
                    if ((currentColor == 'R' || currentColor == 'G') && (colors[nx][ny] == 'R' || colors[nx][ny] == 'G')) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    } else if (currentColor == colors[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                } else {
                    // 일반 경우 -> 같은 색상일 때만
                    if (currentColor == colors[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 크기 N입력
        N = Integer.parseInt(br.readLine());

        // 2. 색깔 판 정보 입력
        colors = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                colors[i][j] = line.charAt(j);
            }
        }

        // 3. 적록색약이 아닌 경우
        visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    count++;
                }
            }
        }

        // 4. 적록색약인 경우
        visited = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    count2++;
                }
            }
        }

        // 5. 결과 출력
        System.out.println(count + " " + count2);
    }
}