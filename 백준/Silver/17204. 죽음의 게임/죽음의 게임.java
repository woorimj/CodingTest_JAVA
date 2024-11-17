import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;
    static boolean[] visited;

    public static int cycle(int node, int K){
        int count = 0;
        int current = node; // 현재 시작노드

        while (true) {
            // 만약 보성이 번호를 만나면
            if (current == K) {
                return count;
            }

            // 아예 경우의 수가 없다면
            if (visited[current]) {
                return -1;
            }

            visited[current] = true; // 방문처리
            current = num[current]; // 다음노드로 이동
            count++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. 정수, 보성이 숫자 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //2. N개의 사람번호
        num = new int[N];
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        //3. 게임시작 -> 시작 지점은 0
        visited = new boolean[N];

        int result = cycle(0, K);
        System.out.println(result);
    }
}