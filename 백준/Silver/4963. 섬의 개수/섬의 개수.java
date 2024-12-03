import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h,w;

    static int[][] land;
    static boolean[][] visited;

    // 방향백터 {좌,우,상,하,왼쪽위,왼쪽아래,오른쪽위,오른쪽아래}
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 경계값을 기준으로 -> 아직 방문하지 않았으며, 연결된 1인 경우만 탐색
            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (land[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int count = 0; // 총 섬의 그룹수

            // 1. 지도 정보(w:너비, h:높이)
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 종료조건 (0 0)
            if(w == 0 && h == 0)
                return;

            // 2. 초기화
            land = new int[h][w];
            visited = new boolean[h][w];

            // 3.지도 정보입력
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 4.DFS 지도탐색
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(land[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            // 5.출력
            System.out.println(count);
        }
    }
}