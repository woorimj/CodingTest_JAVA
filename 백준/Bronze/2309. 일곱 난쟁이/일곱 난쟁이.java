import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] height = new int[9];
        int total = 0;

        //1.배열입력
        for(int i = 0; i < 9; i++){
            height[i] = Integer.parseInt(br.readLine());
            total += height[i];
        }


        //2. 배열 탐색하면서 빼기
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(total - height[i] - height[j] == 100){
                    height[i] = 0;
                    height[j] = 0;

                    //3.배열정렬
                    Arrays.sort(height);

                    //4. 정렬된 배열에서 앞에 2개 이후로 출력
                    for(int t = 2; t < 9; t++)
                        System.out.println(height[t]);

                    return;
                }
            }
        }
    }
}
