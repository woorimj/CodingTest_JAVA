import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int current_weight = 0; // 지금 다리위에 올라가있는 트럭의 총 무게

        // 트럭을 저장할 도로큐 생성
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        // 트럭을 도로에 올린다/만다
        for(int i = 0; i < truck_weights.length;){
            answer++; // 초수증가

            current_weight -= bridge.poll();

            if(current_weight + truck_weights[i] <= weight){
                bridge.add(truck_weights[i]); // 트럭올리기
                current_weight += truck_weights[i++];
            }else {
                bridge.add(0);
            }
        }

        answer += bridge_length;
        return answer;
    }
}