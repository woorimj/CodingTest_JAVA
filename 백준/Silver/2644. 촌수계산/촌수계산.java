import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static int dfs(int n1, int n2){
        visited[n1] = true;

        // 찾으려는 노드 도달
        if (n1 == n2) {
            return 0;
        }

        for (int node : graph.get(n1)) {
            if (!visited[node]) {
                visited[node] = true;
                int level = dfs(node, n2);
                visited[node] = false;

                if (level != -1) {
                    return level + 1;
                }
            }
        }

        return -1; // 연결되지 않으면 -1 반환
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력받기
        int N = Integer.parseInt(br.readLine()); // 사람수-정점

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine()); // 관계수-간선

        //2. 그래프 초기화
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 3. 촌수 계산
        visited = new boolean[N + 1];
        System.out.println(dfs(num1, num2));
    }
}