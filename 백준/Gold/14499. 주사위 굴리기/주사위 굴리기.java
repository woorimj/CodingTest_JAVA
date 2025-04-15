import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,x,y,k;
    static int[][] map;

    // 동,서,북,남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[] dice = new int[6];

    static void move(int d){
        int nx = x + dx[d - 1];
        int ny = y + dy[d - 1];

        // 경계값에 나가면 절대 안됨
        if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
            return;

        // 주사위 회전 방향
        int temp;
        switch (d) {
            case 1:
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;
            case 2:
                temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;
            case 3:
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;
            case 4:
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;
        }


        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[1];
        } else {
            dice[1] = map[nx][ny];
            map[nx][ny] = 0;
        }

        System.out.println(dice[0]);

        x = nx;
        y = ny;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 지도 각 칸의 숫자 정보 입력
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        // 이동 명령
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int d = Integer.parseInt(st.nextToken());
            move(d);
        }
    }
}