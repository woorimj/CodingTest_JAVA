import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static long fibo(int n) {
        // dp배열 만들기
        long[] dp = new long[n + 1];

        // default값
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        //1. n입력
        int n = input.nextInt();

        //2. 피보나치 수열 계산해서 출력
        System.out.println(fibo(n));
    }
}