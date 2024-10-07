import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static ArrayList<Integer> bfs_result = new ArrayList<>();  // BFS 결과 저장
    public static ArrayList<Integer> dfs_result = new ArrayList<>();  // DFS 결과 저장



    // 너비우선탐색
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start); // 시작정점 큐에 삽입
        visited[start] = true; // 시작정점 방문처리
        bfs_result.add(start); //

        while(!queue.isEmpty()){ // 큐가 빌때까지
            int target = queue.poll();

            // 인접 노드 방문하는 반복문
            for(int node : graph.get(target)){
                if(!visited[node]){ // 방문하지 않은 노드면
                    queue.offer(node); // 큐에 저장
                    visited[node] = true; // 방문처리
                    bfs_result.add(node);
                }
            }
        }

    }

    // 깊이 우선탐색
    public static void dfs(int start){
        visited[start] = true; // 시작정점 방문처리
        dfs_result.add(start);

        // 인접 노드 방문하는 반복문
        for(int node : graph.get(start)){
            if(!visited[node]){ // 방문하지 않은 노드면
                dfs(node); // 힌칸 더 내려간다고 생각 <- 재귀호출
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 3가지 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수
        int V = Integer.parseInt(st.nextToken());  // 시작 정점

        // 2. 그래프 초기화 + 간선정보 추가
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()); // 정점 1
            int num2 = Integer.parseInt(st.nextToken()); // 정점 2

            // 양방향 추가
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        // 3. 그래프 정점 순서 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // 4.DFS/BFS 각각 함수 실행 후 결과출력
        visited = new boolean[N + 1];
        dfs(V);
        for (int node : dfs_result) {
            System.out.print(node + " ");
        }
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
        for (int node : bfs_result) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
