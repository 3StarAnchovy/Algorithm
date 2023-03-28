package dfs_bfs;

import java.util.Scanner;

public class boj_14503 {
    static int N;
    static int M;
    static int start_i;
    static int start_j;
    static int[][] map;
    static int[] delta_i = {-1, 0, 1, 0};
    static int[] delta_j = {0, 1, 0, -1};
    static int dir;
    static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        start_i = scanner.nextInt();
        start_j = scanner.nextInt();
        dir = scanner.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();

        dfs(start_i, start_j, dir);
        System.out.println(cnt + 1);
    }

    private static void dfs(int start_i, int start_j, int dir) {
        map[start_i][start_j] = -1;

        for (int d = 0; d < 4; d++) {
            dir -= 1;
            if(dir == -1)
                dir = 3;
            int ni = start_i + delta_i[dir];
            int nj = start_j + delta_j[dir];

            if(0 <= ni && ni < N && 0 <= nj && nj < M)
            {
                if(map[ni][nj] == 0)
                {
                    cnt ++;
                    dfs(ni,nj, dir);
                    return; //되돌아가면 안됨
                }
            }
        }

        int d = (dir + 2) % 4;
        int bi = start_i + delta_i[d];
        int bj = start_j + delta_j[d];
        if(0 <= bi && bi < N && 0 <= bj && bj < M) {
            if(map[bi][bj] != 1)
                dfs(bi, bj, dir);
        }
    }
}