import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long[] dp = new long[5001];

        dp[0] = dp[2] = 1;
        for (int i = 4; i <= 5000; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                dp[i] += dp[j - 2] * dp[i - j];
                dp[i] %= 1_000_000_007;
            }
        }

        int T = sc.nextInt();
        while (T != 0) {
            int L = sc.nextInt();
            if (L % 2 != 0) {
                System.out.println(0);
            } else {
                System.out.println(dp[L]);
            }
            T--;
        }
        sc.close();
    }
}
