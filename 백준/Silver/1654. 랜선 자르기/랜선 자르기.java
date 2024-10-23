import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] lines;

    public static long searchLine(int K, int M, int[] lines){

        long min = 1;
        long max = lines[K - 1];

        while(min <= max){
            long mid = (min + max) / 2;
            long count = 0;

            for(int i = 0; i < K; i++){
                count += lines[i] / mid;
            }

            if(count < M)
                max = mid - 1; 
            else
                min = mid + 1;
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1.입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //2. 정보입력
        lines = new int[K];
        for(int i = 0; i < K; i++){
            String line = br.readLine();
            lines[i] = Integer.parseInt(line);
        }

        //3. 배열 정렬
        Arrays.sort(lines);

        //4. 탐색
        long l = searchLine(K, M, lines);

        //5. 출력
        System.out.println(l);
    }
}
