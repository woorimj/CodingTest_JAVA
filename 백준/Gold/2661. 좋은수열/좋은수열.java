import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int N;

    //수열저장
    public static int[] result;

    public static boolean found = false; // 좋은 수열을 찾았는지 여부

    public static StringBuilder sb = new StringBuilder();


    // 좋은 수열인지 판단하는 함수
    public static boolean isGood(int length) {
        // 부분 수열을 비교하여 나쁜 수열인지 판단
        for (int i = 1; i <= length / 2; i++) {
            // 길이가 i인 인접한 두 부분 수열이 동일한지 확인
            for (int j = 0; j < i; j++) {
                if (result[length - j - 1] != result[length - j - 1 - i]) {
                    // 동일하지 않으면 계속 확인
                    break;
                }
                // 만약 마지막까지 동일하면 나쁜 수열
                if (j == i - 1) {
                    return false;
                }
            }
        }
        return true; // 나쁜 수열이 아니면 좋은 수열
    }

    public static void backTracking(int start) {
        // 이미 좋은 수열을 찾았으면 더이상 진행하지 않음
        if (found)
            return;

        if (start == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            found = true; // 좋은 수열을 찾았음
            return;
        }

        // 1,2,3으로 순서대로 이뤄진 수열만들기 <- 여기서 좋은 수열을 판단하면서, 재귀호출을 함
        for (int i = 1; i <= 3; i++) {
            result[start] = i; // 현재 노드에 값 추가

            // 좋은 수열인경우 계속 노드 탐색
            if(isGood(start + 1))
                backTracking(start + 1); // 다음 노드 탐색
        }
    }

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        //1. 입력
        N = sc.nextInt();

        result = new int[N];
        //2. 수열탐색하면서 -> 좋은 수열을 탐색
        backTracking(0);
    }

}
