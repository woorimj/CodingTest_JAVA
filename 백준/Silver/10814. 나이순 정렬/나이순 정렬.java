import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] member;

        // 1.회원수입력
        int N = Integer.parseInt(br.readLine());

        member = new String[N][2];
        // 2.회원수만큼 입력받은 정보로 배열만들기
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                member[i][j] = st.nextToken();
            }
        }

        // 3.나이순 정렬
        Arrays.sort(member, Comparator.comparingInt(a -> Integer.parseInt(a[0])));

        for (int i = 0; i < N; i++) {
            System.out.println(member[i][0] + " " + member[i][1]);
        }
    }
}