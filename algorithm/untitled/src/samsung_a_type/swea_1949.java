package samsung_a_type;

import java.util.Scanner;

public class swea_1949 {
    static int T;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visit;
    static int[] delta_r = {-1, 1, 0, 0};
    static int[] delta_c = {0, 0, -1, 1};
    static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int max = Integer.MIN_VALUE;
            N = scanner.nextInt();
            K = scanner.nextInt();
            map = new int[N][N];
            visit = new boolean[N][N];
            res = Integer.MIN_VALUE;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    map[r][c] = scanner.nextInt();
                    max = Math.max(max, map[r][c]);
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (max == map[r][c]) {
                        visit[r][c] = true;
                        dfs(r, c, 0, 1);
                        visit[r][c] = false;
                    }
                }
            }

            System.out.println("#" + t + " " + res);
        }
    }

    private static void dfs(int r, int c, int cut, int cnt) {
        for (int d = 0; d < 4; d++) {
            int nr = r + delta_r[d];
            int nc = c + delta_c[d];

            if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc]) {
                if (map[nr][nc] < map[r][c]) {
                    visit[nr][nc] = true;
                    dfs(nr, nc, cut, cnt + 1);
                    visit[nr][nc] = false;
                } else if (cut == 0) {
                    for (int i = 1; i <= K; i++) {
                        map[nr][nc] -= i;
                        if (map[nr][nc] < map[r][c]) {
                            visit[nr][nc] = true;
                            dfs(nr, nc, cut + 1, cnt + 1);
                            visit[nr][nc] = false;
                        }
                        map[nr][nc] += i;
                    }
                }
            }
        }

        res = Math.max(res, cnt);
    }
}
