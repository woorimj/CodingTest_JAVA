import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] score;

        //1. 응시자수, 상받는사람수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //2. N명만큼 배열에 입력받기
        score = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }

        //3. 배열 정렬
        Arrays.sort(score);

        //4. 뒤에서 k번째 점수 출력
        System.out.println(score[N - K]);
    }
}