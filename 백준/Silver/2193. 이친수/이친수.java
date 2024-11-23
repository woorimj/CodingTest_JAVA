import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. N자리 입력
        int N = Integer.parseInt(br.readLine());

        // 2. dp배열
        long[] dp = new long[N + 1];

        dp[1] = 1; // 1자리 이친수: "1"
        if (N >= 2) {
            dp[2] = 1; // 2자리 이친수: "10"
        }

        // 3. 가능한 조합의 수 구하기
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 4. 결과 출력
        System.out.println(dp[N]);
    }
}