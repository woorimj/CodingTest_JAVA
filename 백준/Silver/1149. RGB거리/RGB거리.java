import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] house = new int[N + 1][4];
        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 4; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][4];

        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];
        dp[1][3] = house[1][3];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = house[i][1] + Math.min(dp[i-1][2], dp[i-1][3]);
            dp[i][2] = house[i][2] + Math.min(dp[i-1][1], dp[i-1][3]);
            dp[i][3] = house[i][3] + Math.min(dp[i-1][1], dp[i-1][2]);
        }

        int result = Math.min(dp[N][1], Math.min(dp[N][2], dp[N][3]));
        System.out.println(result);
    }
}