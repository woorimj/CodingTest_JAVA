import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long searchDrink(int[] drink, int N, int K){
        long start = 1;
        long end = drink[N - 1];
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += drink[i] / mid;
            }

            // 조건
            if (count < K) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] drinks = new int[N];
        for(int i = 0; i < N; i++){
            drinks[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(drinks);

        System.out.println(searchDrink(drinks, N, K));
    }
}