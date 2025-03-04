import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int h,w;
    public static int[][] land = new int[50][50];


    public static boolean dfs(int x, int y){
        // 범위 나가면 종료
        if(x <= -1 || x >= h || y <= -1 || y >= w){
            return false;
        }

        // 현재 노드가 1(땅)이면서 아직방문하지 않았다면
        if(land[x][y] == 1){
            land[x][y] = -1; // 방문처리함
            // 좌,우
            dfs(x - 1, y);
            dfs(x + 1, y);
            // 상,하
            dfs(x , y - 1);
            dfs(x, y + 1);
            // 대각선
            dfs(x - 1, y - 1);
            dfs(x + 1, y - 1);
            dfs(x - 1, y + 1);
            dfs(x + 1, y + 1);
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            // 1.지도 정보(w:너비, h:높이)
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                return;

            // 2.지도 정보입력
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 3.방문처리
            int count = 0; // 섬의 개수
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                   if(dfs(i,j)){
                       count += 1;
                   }
                }
            }

            // 4.출력
            System.out.println(count);
        }
    }
}
