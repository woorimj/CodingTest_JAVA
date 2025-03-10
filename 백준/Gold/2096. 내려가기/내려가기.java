import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, max=0, min=0;
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 점수 정보입력
        array = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대,최소 점수합 구하기
        dp = new int[N][3];

        // 첫번째줄은 배열에 넣어놓기
        for (int j = 0; j < 3; j++)
            dp[0][j] = array[0][j];

        // 두번째줄부터 max값 계산
        for(int i = 1; i < N; i++){
            dp[i][0] = array[i][0] + Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = array[i][1] + Math.max(Math.max(dp[i-1][0],dp[i-1][1]), dp[i-1][2]);
            dp[i][2] = array[i][2] + Math.max(dp[i-1][1],dp[i-1][2]);
        }
        max = Math.max(Math.max(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

        // 최소합 구하기 위한 dp배열 초기화
        for (int i = 1; i < N; i++)
            Arrays.fill(dp[i], 0);

        // 두번째줄부터 min값 계산
        for(int i = 1; i < N; i++){
            dp[i][0] = array[i][0] + Math.min(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = array[i][1] + Math.min(Math.min(dp[i-1][0],dp[i-1][1]), dp[i-1][2]);
            dp[i][2] = array[i][2] + Math.min(dp[i-1][1],dp[i-1][2]);
        }
        min = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);

        System.out.print(max + " " + min);
    }
}
