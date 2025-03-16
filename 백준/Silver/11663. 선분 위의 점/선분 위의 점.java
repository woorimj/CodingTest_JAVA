import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] dots;

    public static int binarySearch(int start, int end) {
        int left = 0;
        int right = dots.length - 1;

        // 시작점 이상인 위치
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dots[mid] < start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int startIdx = left;

        // 끝점 이하인 위치
        left = 0;
        right = dots.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dots[mid] > end) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int endIdx = right + 1;

        return endIdx - startIdx;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dots = new int[N];
        st  = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            dots[i] = Integer.parseInt(st.nextToken());
        }

        // 좌표정보 정렬
        Arrays.sort(dots);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end =Integer.parseInt(st.nextToken());

            // 이분탐색
            int result = binarySearch(start,end);
            System.out.println(result);
        }
    }
}
