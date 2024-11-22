import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void findNum(int[][] arr, int N) {
        int winnerIndex = 0;
        int maxScore = 0;

        for (int i = 0; i < N; i++) {
            int[] cards = arr[i];
            int targetNum = 0;

            // 5장중에서 3장 조합만들기
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[a] + cards[b] + cards[c];
                        int num = sum % 10; // 일의 자리 계산
                        targetNum = Math.max(targetNum, num);
                    }
                }
            }

            if (targetNum > maxScore) {
                maxScore = targetNum;
                winnerIndex = i;
            } else if (targetNum == maxScore) {
                if (i > winnerIndex) {
                    winnerIndex = i;
                }
            }
        }
        System.out.println(winnerIndex + 1);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력받기
        int N = Integer.parseInt(br.readLine());

        //2. 각 사람의 숫자카드 정보 입력
        arr = new int[N][5];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //3. 이차원배열 탐색
        findNum(arr, N);
    }
}