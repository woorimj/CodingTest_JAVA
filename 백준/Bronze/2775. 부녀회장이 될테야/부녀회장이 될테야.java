import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        //1. 테스트케이스 입력
        int T = input.nextInt();

        //2. k층n호
        while(T != 0){
            int k = input.nextInt();
            int n = input.nextInt();

            int[][] dp = new int[k + 1][n + 1];

            //default -> 0층 n호에는 n명 살아
            for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
            System.out.println(dp[k][n]);
            T--;
        }
    }
}