import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 보도블럭몇개 입력
        int N = Integer.parseInt(br.readLine());

        //2. 보드블럭 정보 입력
        String block = br.readLine();
        char[] blocks = new char[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = block.charAt(i); // 문자열의 i번째 문자를 배열에 저장
        }

        // 3. 최소 에너지를 저장할 dp 배열
        int[] dp = new int[N];
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        //4. 보도블럭 배열탐색
        for(int i = 0; i < N; i++){
            char cur = blocks[i];
            char next;
            // 그 다음 올거 조건문
            if(cur == 'B'){
                next = 'O';
            } else if (cur == 'O') {
                next = 'J';

            }else{
                next = 'B';
            }

            // 에너지양 구하기
            for (int j = i + 1; j < N; j++) {
                if (blocks[j] == next) {
                    int jump = (j - i) * (j - i); // 점프하는 데 드는 에너지
                    if (dp[i] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[i] + jump); // 최소 에너지 갱신
                    }
                }
            }
        }

        //5. 결과
        if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}