import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] max = new int[N + 1][3];
        int[][] min = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + board[i][0];
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) +  board[i][1];
            max[i][2] = Math.max(max[i - 1][2], max[i - 1][1]) + board[i][2];

            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + board[i][0];
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + board[i][1];
            min[i][2] = Math.min(min[i - 1][2], min[i - 1][1]) + board[i][2];
        }

        int result_max = 0;
        int result_min = 1000000 * 9; // 최대 숫자가 9이니깐?
        for (int j = 0; j < 3; j++) {
            if (result_max < max[N][j]) {
                result_max = max[N][j];
            }
            if (result_min > min[N][j]) {
                result_min = min[N][j];
            }
        }
        System.out.print(result_max + " " + result_min);
    }
}