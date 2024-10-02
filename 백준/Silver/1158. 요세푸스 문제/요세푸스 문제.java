import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int N, K; // N명의 사람, K번째 사람
    static  int index = 0; // 사람인덱스
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1-N명의 사람
        K = Integer.parseInt(st.nextToken()); // K번째 사람 제거

        // 1-N까지의 사람 저장
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            index = (index + K - 1 ) % queue.size(); // 인덱스 계산
            sb.append(queue.remove(index));

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}