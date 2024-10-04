import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        for(int i = 0; i < T; i++){
            String ps = br.readLine(); // 괄호 문자열 입력받기
            LinkedList<Character> queue = new LinkedList<>(); // 큐에 저장하기

            boolean isVPS = true;

            // 하나씩 빼면서 다른 방향의 괄호가 나오면 큐에 저장된 괄호를 빼면서 비교하기
            for(int j = 0; j < ps.length(); j++){
                char ch =  ps.charAt(j);

                if(ch == '('){
                    queue.add(ch);
                }
                else if(ch == ')'){
                    if(queue.isEmpty()){
                        isVPS = false;
                        break;
                    }
                    else{
                        queue.poll(); // 짝이 맞는 괄호를 큐에서 빼기
                    }
                }
            }

            if(queue.isEmpty() && isVPS){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

    }
}
