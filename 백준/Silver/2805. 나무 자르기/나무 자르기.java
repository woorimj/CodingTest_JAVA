import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] trees;

    public static long searchTree(int M, int[] trees){

        long min = 0; // 가장 짧은 길이
        long max = trees[trees.length - 1]; // 가장 긴 길이

        while(min < max){
            long mid = (min + max) / 2;
            long sum = 0;

            for(int height: trees) {
                if (height - mid > 0)
                    sum += height - mid;
            }

            // 자른 나무길이가 M이 안되면 -> 나무높이를 줄여야됨
            if(sum < M)
                max = mid;
            else{ // 나무길이가 M을 넘어버리면 -> 나무높이를 늘려야됨
                min = mid + 1;
            }
        }

        return min - 1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1.나무의수, 가져가려는 나무의 길이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[N];
        //2. N개의 나무길이 정보 배열만들기
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        //3. 나무길이 정렬
        Arrays.sort(trees);

        //4. 탐색
        long h = searchTree(M, trees);

        //5. 출력
        System.out.println(h);
    }
}