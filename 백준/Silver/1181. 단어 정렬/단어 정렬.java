import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1.단어개수 입력
        int N = Integer.parseInt(br.readLine());

        // 2.중복제거 -> 입력받기
        HashSet<String> words = new HashSet<>();
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 3.길이순 정렬 -> 같으면 사전순
        List<String> list = new ArrayList<>(words);
        list.sort((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word1.length() - word2.length();
            } else {
                return word1.compareTo(word2);
            }
        });

        // 4.출력
        for (String word : list) {
            System.out.println(word);
        }
    }
}