import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, S;
    public static int count = 0;
    public static int[] num;

    public static void backTracking(int start, int sum) {
        int total = sum;

        // 배열 끝에 도달한 경우 종료
        if (start == N) {
            return;
        }

        total += num[start];
        // 합이 S와 같으면 카운트 증가
        if (total == S) {
            count++;
        }

        // 다음 요소로 넘어가기
        for (int i = start + 1; i < N; i++) {
            backTracking(i, total);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        //백트래킹
        // 2. DFS 실행 (각 인덱스에서 탐색 시작)
        for (int i = 0; i < N; i++) {
            backTracking(i, 0);
        }
        System.out.println(count);
    }
}
