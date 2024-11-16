import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void dfs(int index){
        visited[index] = true;
        if(!visited[arr[index]])
            dfs(arr[index]);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트케이스 입력
        int T = Integer.parseInt(br.readLine());

        while (T != 0) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 숫자 입력받기
            arr = new int[N + 1];
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 방문여부 확인
            visited = new boolean[N + 1];
            for(int i = 1; i <= N; i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
            T--;
        }
    }
}