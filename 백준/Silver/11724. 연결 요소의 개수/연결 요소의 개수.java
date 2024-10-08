import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void dfs(int start){
        visited[start] = true; 
        
        for(int node : graph.get(start)){
            if(!visited[node]){ 
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0; // 연결요소 개수

        // 1.입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수

        // 2. 그래프 초가화 + 간선정보입력
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 3. 그래프 탐색하면서 연결요소 개수 구하기
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++; // 연결요소 하나 추가
            }
        }
        System.out.println(count);
    }
}
