import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int L,C;

    public static char[] code;
    public static char[] result;
    public static StringBuilder sb = new StringBuilder();


    public static void backTracking(int start, int depth){
        if (depth == L){
            int count1 = 0; // 모음개수
            int count2 = 0; // 자음개수

            for (int i = 0; i < L; i++) {
                //모음,자음판단
                if (result[i] == 'a' || result[i] == 'e' || result[i] == 'i' || result[i] == 'o' || result[i] == 'u') {
                    count1++;
                }else {
                    count2++;
                }
            }

            // 조건 모음 한개이상, 자음 두개이상이면 저장
            if (count1 >= 1 && count2 >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
            result[depth] = code[i];
            backTracking(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1.L,C
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        //2.암호를 만들 수 있는 문자입력받기
        code = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++)
            code[i] = st.nextToken().charAt(0);

        // 정렬된 암호를 위한
        Arrays.sort(code);

        //3.암호만들기
        result = new char[L];
        backTracking(0, 0);

        System.out.print(sb.toString());
    }
}
