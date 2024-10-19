import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] games; // 각 경기의 팀 쌍 저장
    public static int[][] wins;  // 각 팀의 승/무/패 기록 저장

    // 백트래킹을 통해 가능한 경기 결과를 탐색
    static void backTracking(int[][] wins, int matchCount, int size, boolean[] isPossible) {
        if (isPossible[0]) { // 가능한 경우를 이미 찾았을 경우
            return;
        }

        // 모든 경기를 완료했을 경우
        if (matchCount == size) {
            isPossible[0] = true; // 가능한 경우로 설정
            return;
        }

        int myTeam = games[matchCount][0];
        int enemyTeam = games[matchCount][1];

        // 승리한 경우
        if (wins[0][myTeam] > 0 && wins[2][enemyTeam] > 0) {
            wins[0][myTeam]--;
            wins[2][enemyTeam]--;
            backTracking(wins, matchCount + 1, size, isPossible);
            wins[0][myTeam]++;
            wins[2][enemyTeam]++;
        }

        // 무승부한 경우
        if (wins[1][myTeam] > 0 && wins[1][enemyTeam] > 0) {
            wins[1][myTeam]--;
            wins[1][enemyTeam]--;
            backTracking(wins, matchCount + 1, size, isPossible);
            wins[1][myTeam]++;
            wins[1][enemyTeam]++;
        }

        // 패배한 경우
        if (wins[2][myTeam] > 0 && wins[0][enemyTeam] > 0) {
            wins[2][myTeam]--;
            wins[0][enemyTeam]--;
            backTracking(wins, matchCount + 1, size, isPossible);
            wins[2][myTeam]++;
            wins[0][enemyTeam]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        games = new int[15][2]; // 6개의 팀 -> 15경기
        int index = 0;
        for (int i = 0; i < 5; i++) { // 한 팀당 5경기
            for (int j = i + 1; j < 6; j++) {
                games[index][0] = i;
                games[index][1] = j;
                index++;
            }
        }

        int tc = 4;
        // 4개의 테스트케이스
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            wins = new int[3][6]; // 승/무/패 각각 저장하는 배열
            boolean isValid = true;
            boolean[] isPossible = new boolean[1]; // 가능한지를 판단하는 변수 배열로 변경 (매 테스트 케이스마다 초기화됨)

            // 각 팀의 경기 결과 입력 받기
            for (int i = 0; i < 6; i++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());

                wins[0][i] = win;
                wins[1][i] = draw;
                wins[2][i] = lose;

                // 한 팀당 무조건 5번의 경기를 해야됨
                if (win + draw + lose != 5) {
                    isValid = false;
                    break;
                }
            }

            // 경기 수가 올바른 경우에만 백트래킹 수행
            if (isValid) {
                backTracking(wins, 0, 15, isPossible);
                if (isPossible[0]) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
