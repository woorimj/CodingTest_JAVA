import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1.테스트 케이스
        int T = Integer.parseInt(br.readLine());

        //2.N,M
        while(T != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M + 1][N+ 1];

            //default -> mC0=1, mCm=1
            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                if (i <= N) {
                    dp[i][i] = 1;
                }
            }

            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            System.out.println(dp[M][N]);
            T--;
        }
    }
}