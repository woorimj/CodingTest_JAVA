import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] trees =  new int[5];

        //1. 나무조각 정보 배열만들기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        //2. 배열정렬 과정
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                if(trees[j] > trees[j + 1]){
                    int temp = trees[j + 1];
                    trees[j + 1] = trees[j];
                    trees[j] = temp;

                    for(int tree:trees){
                        System.out.print(tree + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}