import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] game = new int[19][19];
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    public static void findWinner() {
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                // 오목판이 1,2인 경우
                if (game[i][j] != 0) {
                    for (int d = 0; d < 8; d++) {
                        int count = 1;

                        // 방향 탐색
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                            if (game[i][j] == game[nx][ny]) {
                                count++;
                            } else {
                                break;
                            }
                            nx += dx[d];
                            ny += dy[d];
                        }

                        // 반대 방향 탐색
                        nx = i - dx[d];
                        ny = j - dy[d];
                        while (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                            if (game[i][j] == game[nx][ny]) {
                                count++;
                            } else {
                                break;
                            }
                            nx -= dx[d];
                            ny -= dy[d];
                        }

                        // 연속 5개가 확인된 경우
                        if (count == 5) {
                            System.out.println(game[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        // 승부가 안난경우
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 오목판 정보 입력
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 오목 탐색하기
        findWinner();
    }
}