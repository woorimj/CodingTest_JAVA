import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int getMaxVolume(int[] volume, int N, int S, int M) {
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j - volume[i] >= 0) {
                        dp[i + 1][j - volume[i]] = true;
                    }
                    if (j + volume[i] <= M) {
                        dp[i + 1][j + volume[i]] = true;
                    }
                }
            }
        }

        // 마지막 곡에서 가능한 최대 볼륨 찾기
        for (int j = M; j >= 0; j--) {
            if (dp[N][j]) {
                return j;
            }
        }

        return -1;
    }


    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         //1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //2. 곡볼륨
        int[] volume = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            volume[i] = Integer.parseInt(st.nextToken());
        }


        // 3. DP 탐색
        System.out.println(getMaxVolume(volume, N, S, M));
    }
}
