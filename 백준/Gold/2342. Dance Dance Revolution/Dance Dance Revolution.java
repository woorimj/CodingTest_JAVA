
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int calculateMoves(List<Integer> moves) {
        int[][] dp = new int[5][5];
        int fill = Integer.MAX_VALUE;

        // 초기화 (최소값을 구해야하니깐)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = fill;
            }
        }

        dp[0][0] = 0;
        for (int step = 0; step < moves.size(); step++) {
            int nextMove = moves.get(step);
            int[][] nextDp = new int[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    nextDp[i][j] = fill;
                }
            }

            // 이동방식
            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (dp[left][right] == fill)
                        continue;

                    int currentPower = dp[left][right];

                    // 왼발 이동
                    if (nextMove != right) {
                        int power;
                        if (left == nextMove)
                            power = 1;
                        else if (left == 0)
                            power = 2;
                        else if (Math.abs(left - nextMove) == 2)
                            power = 4;
                        else power = 3;

                        int newPower = currentPower + power;
                        if (newPower < nextDp[nextMove][right]) {
                            nextDp[nextMove][right] = newPower;
                        }
                    }

                    // 오른발 이동
                    if (nextMove != left) {
                        int power;
                        if (right == nextMove)
                            power = 1;
                        else if (right == 0)
                            power = 2;
                        else if (Math.abs(right - nextMove) == 2)
                            power = 4;
                        else power = 3;

                        int newPower = currentPower + power;
                        if (newPower < nextDp[left][nextMove]) {
                            nextDp[left][nextMove] = newPower;
                        }
                    }
                }
            }
            dp = nextDp;
        }

        // 가장 작은 힘 구하기
        int answer = fill;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[i][j]);
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> array = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0)
                break;
            array.add(move);
        }
        System.out.println(calculateMoves(array));
    }
}