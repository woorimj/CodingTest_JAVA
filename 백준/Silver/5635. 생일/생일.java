import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        // 1. 학생 수 입력
        int N = Integer.parseInt(br.readLine());

        // 2. 학생 정보입력
        List<String> students = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            students.add(br.readLine());
        }

        // 3. 일-월-년 구분하기
        students.sort((student1, student2) -> {
            String[] s1 = student1.split(" ");
            String[] s2 = student2.split(" ");

            int day1 = Integer.parseInt(s1[1]);
            int month1 = Integer.parseInt(s1[2]);
            int year1 = Integer.parseInt(s1[3]);

            int day2 = Integer.parseInt(s2[1]);
            int month2 = Integer.parseInt(s2[2]);
            int year2 = Integer.parseInt(s2[3]);

            // 연도 비교
            if (year1 != year2) {
                return year1 - year2;
            }

            // 월 비교
            if (month1 != month2) {
                return month1 - month2;
            }

            // 일 비교
            return day1 - day2;
        });

//        System.out.print(students);

        String yong = students.get(N - 1).split(" ")[0];
        String old = students.get(0).split(" ")[0];

        System.out.println(yong);
        System.out.println(old);
    }
}