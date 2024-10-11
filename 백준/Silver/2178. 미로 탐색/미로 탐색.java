import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[][] route;

    // 상하좌우탐색
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};


    public static int bfs(int x, int y, int N, int M){
        Queue<int[]> queue = new LinkedList<>(); // 큐를 배열로 설정

        queue.offer(new int[]{x, y, 1}); // 시작정점 큐에 시작 위치 + 거리값=1 시작
        visited[x][y] = true; // 시작정점 방문처리

        while(!queue.isEmpty()){ // 큐가 빌때까지
            int[] q = queue.poll();
            int n1 = q[0];
            int n2 = q[1];
            int n3 = q[2];

            // 마지막 도착지점에 도달하면 거리값 리턴
            if(n1 == N && n2 == M) {
                return n3;
            }

            for (int i = 0; i < 4; i++) {
                int nx = n1 + dx[i];
                int ny = n2 + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, n3+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. 미로의 크기 입력 (N-가로, M-세로)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //2. 미로의 크기로 그래프 초기화 하면서 한줄씩 주어지는 정보 입력받기
        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                graph[i][j] = line.charAt(j - 1) - '0';
            }
        }

        // 3. BFS로 미로탐색하기 <- 최단거리 구허기
        int route = bfs(1,1, N, M);

        // 4. 출력
        System.out.println(route);
    }
}
