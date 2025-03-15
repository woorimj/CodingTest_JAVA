import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int findHeight(int[] arr, int N, int M) {
        int start = 1;
        int end = N;
        int result = N;

        while (start <= end) {
            int mid = (start + end) / 2; // 가로등 높이 지정

            int covered = 0; // 비추는 공간 범위
            boolean canCover = true; // 전체 비출수 있는지

            for (int i = 0; i < M; i++) {
                int left = arr[i] - mid;  // 왼쪽으로 비출 수 있는 범위
                int right = arr[i] + mid; // 오른쪽으로 비출 수 있는 범위

                // 왼쪽 비추는 범위가 현재 공간범위보다 커지면 시작지점 0에서 부터 커버되지 않는 부분이 생김
                if (left > covered) {
                    canCover = false;
                    break;
                }

                covered = right; // 현재까지 커버 가능한 구간

                // 모든 구간을 다 비추고 있으면
                if (covered >= N) {
                    break;
                }
            }

            if (canCover && covered >= N) { // 길 전체를 커버 가능하면 최소 높이 찾기 -> 높이를 낮춤
                result = mid;
                end = mid - 1;
            } else { // 커버 불가능하면 높이를 올림
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 가로등 위치 입력받기
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findHeight(arr, N, M));
    }
}
