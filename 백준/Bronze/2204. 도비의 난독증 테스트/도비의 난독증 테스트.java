import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 1.단어 개수 입력
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            // 2.단어 입력 받기
            ArrayList<String> words = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                words.add(br.readLine());
            }

            // 3.대소문자 무시 -> 사전순 정렬
            words.sort((word1, word2) ->
                    word1.toLowerCase().compareTo(word2.toLowerCase()));

            // 가장 앞서는 단어 출력
            System.out.println(words.get(0));
        }
    }
}
