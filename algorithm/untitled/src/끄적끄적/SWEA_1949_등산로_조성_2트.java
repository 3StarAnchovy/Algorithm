package 끄적끄적;

import java.util.Scanner;

public class SWEA_1949_등산로_조성_2트 {
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int top;
    static int max = 0;

    static class Pos {
        int i, j;
        int cnt; // 등산깎았나?

        public Pos(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            // step1 : 입력 받기
            N = scanner.nextInt();
            K = scanner.nextInt();
            top = 1;
            max = 0;
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                    top = Math.max(top, map[i][j]);
                }
            }

            //step 2 : dfs 시행하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == top) {
                        visited[i][j] = true;
                        dfs(new Pos(i, j, 0), 1); // walk_cnt
                        visited[i][j] = false;
                    }
                }
            }
//            visited[2][3] = true;
//            dfs(new Pos(2,3,0),1);
//            visited[2][3] = false;

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(Pos pos, int walk_cnt) {
        max = Math.max(walk_cnt, max);
        //System.out.print(map[pos.i][pos.j] + " ");

        for (int d = 0; d < 4; d++) {
            int ni = pos.i + delta_i[d];
            int nj = pos.j + delta_j[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                //깎아서 가는 경우
                if (map[ni][nj] >= map[pos.i][pos.j] && pos.cnt == 0) {
                    if (map[ni][nj] - K < map[pos.i][pos.j]) {
                        int ori = map[ni][nj];
                        visited[ni][nj] = true;
                        map[ni][nj] = map[pos.i][pos.j] - 1;
                        dfs(new Pos(ni, nj, pos.cnt + 1), walk_cnt + 1);
                        map[ni][nj] = ori;
                        visited[ni][nj] = false;
                    }
                }
                //걍 가는 경우
                if (map[ni][nj] < map[pos.i][pos.j]) {
                    visited[ni][nj] = true;
                    dfs(new Pos(ni, nj, pos.cnt), walk_cnt + 1);
                    visited[ni][nj] = false;
                }
            }
        }
        //System.out.println("walk : " + walk_cnt);

    }
}
