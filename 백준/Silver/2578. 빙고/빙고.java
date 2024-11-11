import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] bingo = new int[5][5];

    public static int bingo(int num) {
        int count = 0; // 빙고 갯수
        int row, col; // 가로,세로
        int d1 = 0, d2 = 0; // 대각선

        //1. 빙고 방문처리
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(bingo[i][j] == num){
                    bingo[i][j] = 0;
                }
            }
        }

        //2. 가로,세로
        for (int i = 0; i < 5; i++) {
            row = 0;
            col = 0;
            for (int j = 0; j < 5; j++) {
                row += bingo[i][j];
                col += bingo[j][i];
            }

            if (row == 0)
                count++;
            if (col == 0)
                count++;
        }

        //3. 대각선
        for (int i = 0; i < 5; i++) {
            d1 += bingo[i][i];
            d2 += bingo[i][4 - i];
        }
        if (d1 == 0)
            count++;
        if (d2 == 0)
            count++;
        
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num; //부른 수
        int numCount = 0; // 숫자 몇번째?
        int bingoCount = 0; // 빙고 몇개

        //1. 5*5빙고 정보 입력
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. 빙고탐색
        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                num = Integer.parseInt(st.nextToken());
                bingoCount = bingo(num);
                numCount++;
                if(bingoCount >= 3){
                    System.out.println(numCount);
                    return;
                }
            }
        }
    }
}
