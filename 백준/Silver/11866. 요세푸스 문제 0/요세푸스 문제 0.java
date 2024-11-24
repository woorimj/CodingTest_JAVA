import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        //1. N명입력, K번째
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //2. 큐 만들기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        //3. 요세푸스 순열만들기
        sb.append("<");
        while(!queue.isEmpty()){
            for(int i = 0; i < K - 1; i++){
                queue.add(queue.remove());
            }
            sb.append(queue.remove());

            if(!queue.isEmpty())
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}