import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] num;
    public static int[] result;

    public static boolean[] visited;

    public static StringBuilder sb = new StringBuilder(); // 출력 최적화

    //백트래킹 함수
    public static void backTracking(int start) {
        //조건에 맞으면 출력
        if (start == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < N; i++) {
            if(!visited[i] && prev != num[i]) {
                prev = num[i];
                visited[i] = true;
                result[start] = num[i]; // 현재 노드에 값 추가
                backTracking(start + 1); // 다음 노드 탐색
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1.자연수 M,N 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        //2.N개의 수로 노드값 추가
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        //3.수열을 저장할 배열, 방문배열
        result = new int[M];
        visited = new boolean[N];


        // 오름차순 출력을 위해서
        Arrays.sort(num);
        //4. 백트래킹
        backTracking(0);

        System.out.print(sb.toString());
    }
}
