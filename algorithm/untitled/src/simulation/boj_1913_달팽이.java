package simulation;

import java.util.Scanner;

public class boj_1913_달팽이 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {1, 0, -1, 0}; //아래, 오른쪽, 위, 왼쪽
    static int[] delta_j = {0, 1, 0, -1};
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //step 1 : 입력받기, 1base 주의하면서 배열 생성
        N = scanner.nextInt();
        map = new int[N + 1][N + 1]; // 1base; 더미 데이터 ㅇㅇ
        visited = new boolean[N + 1][N + 1];
        int find = scanner.nextInt();

        snail(N * N, 1, 1, 0); // cnt, i, j, d

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == find) {
                    sb.append(i).append(" ").append(j);
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    /*
    - step 2: 값 입력 시작
    - 재귀 호출
        - 기저조건 (N * 2만큼 시행했을 때)
        - 매개변수 값 배열에 입력
        - 다음 배열에 값 전달할때, 다음값의 visit가 true거나 배열의 범위를 벗어날때 d를 바꿔서 보내주기
     */
    private static void snail(int cnt, int i, int j, int d) {
        if (cnt == 0) {
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    sb.append(map[r][c]).append(" ");
                }
                sb.append('\n');
            }

            return;
        }

        map[i][j] = cnt;
        visited[i][j] = true;
        int ni = i + delta_i[d];
        int nj = j + delta_j[d];

        if (1 <= ni && ni <= N && 1 <= nj && nj <= N && !visited[ni][nj]) {
            snail(cnt - 1, ni, nj, d);
        }
        //배열의 범위를 벗어나거나 visited가 찍혀있을 떄
        else {
            int nd = ((d + 1 + 4) % 4);
            ni = i + delta_i[nd];
            nj = j + delta_j[nd];
            snail(cnt - 1, ni, nj, nd);
        }
    }
}
