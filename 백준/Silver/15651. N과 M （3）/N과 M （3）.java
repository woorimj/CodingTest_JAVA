import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] result;

    public static StringBuilder sb = new StringBuilder(); // 출력 최적화

    // 백트래킹 함수
    public static void backTracking(int start) {
        // 조건에 맞으면 출력
        if (start == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            result[start] = i; // 현재 노드에 값 추가
            backTracking(start + 1); // 다음 노드 탐색
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 자연수 N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //2. 수열을 저장할 배열
        result = new int[M];

        //3. 백트래킹
        backTracking(0);

        //4. 시간초과 -> sb로 한번에 출력
        System.out.print(sb.toString());
    }
}
