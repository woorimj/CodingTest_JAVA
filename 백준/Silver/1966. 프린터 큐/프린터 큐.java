import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int T; // 테스트 케이스 수
    static int N, M; // 문서의 수 N, 궁금한 문서의 위치 M
   
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 문서의 수
            M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) { 
                queue.add(new int[]{i, Integer.parseInt(st.nextToken())}); // 배열로 인덱스와 우선순위 저장
            }

            int count = 0; // 출력 순서
            while (!queue.isEmpty()) {
                int[] current = queue.poll(); // 큐에서 첫 번째 문서를 꺼냄
                boolean checkPriority = false;

                // 현재 문서보다 높은 우선순위가 있는지 확인
                for (int i = 0; i < queue.size(); i++) {
                    if (queue.get(i)[1] > current[1]) { // 우선순위 비교하기
                        checkPriority = true;
                        break;
                    }
                }

                // 더 높은 우선순위가 있다면 다시 큐에 추가
                if (checkPriority) {
                    queue.add(current);
                } else {
                    count++; // 출력 순서 증가
                    if (current[0] == M) { // index 확인
                        sb.append(count).append("\n"); 
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
