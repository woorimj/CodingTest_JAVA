import java.util.Arrays;

class Solution {

    public long solution(int n, int[] times) {
        long answer = 0;

        // 걸리는 시간순으로 오름차순 정렬
        Arrays.sort(times);

        long min = times[0]; // 가장 최소시간 1분
        long max = (long) times[times.length-1] * n; // 가장 느리게 심사받는 경우 마지막 경우.

        while(min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < times.length; i++)
                sum += mid / times[i];
            if (sum < n)
                min = mid + 1;
            else {
                max = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
