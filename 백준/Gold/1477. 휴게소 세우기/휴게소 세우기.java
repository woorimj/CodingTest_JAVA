import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] array;

    public static int binarySearch(int m) {
        int left = 1;
        int right = array[array.length - 1];

        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = 0;
            for (int i = 1; i < array.length; i++) {
                int d = array[i] - array[i - 1];
                count += (d - 1) / mid;
            }

            if (count > m) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
        int m = Integer.parseInt(st.nextToken()); // 추가로 지을 휴게소 개수
        int l = Integer.parseInt(st.nextToken()); // 고속도로 길이

        // 휴게소 위치 확인후 구간 구하기 위한 배열 만들기 + 초기값 설정
        array = new int[n + 2];
        array[0] = 0;
        array[n + 1] = l;
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
        }

        // 위치값 정렬
        Arrays.sort(array);

        // 이분탐색하기
        System.out.println(binarySearch(m));
    }
}