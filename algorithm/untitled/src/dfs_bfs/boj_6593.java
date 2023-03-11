package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
접근
유저가 움직일수있는 방향 동서남북 + 상하
dx,dy에 dz 추가해서 3차원으로 접근 생각
목적지까지의 최소거리를 도출해야하므로 bfs 생각
 */
public class boj_6593 {
    static int L = 1, R = 1, C = 1;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] delta_r = {-1, 1, 0, 0, 0, 0};
    static int[] delta_c = {0, 0, -1, 1, 0, 0};
    static int[] delta_z = {0, 0, 0, 0, -1, 1};

    static class Pos {
        int z;
        int r;
        int c;

        public Pos(int z, int r, int c) {
            this.z = z;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!(L == 0 && R == 0 && C == 0)) {
            L = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();

            map = new char[L][R][C];
            visited = new boolean[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = scanner.next().toCharArray();
                }
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S') {
                            bfs(new Pos(i, j, k));
                        }
                    }
                }
            }
        }
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();

        boolean flag = false;
        int z = pos.z;
        int r = pos.r;
        int c = pos.c;
        visited[z][r][c] = true;
        queue.add(pos);

        int cnt = 0;
        A:
        while (!queue.isEmpty()) {
            cnt++;
            int qSize = queue.size();
            while (qSize-- > 0) {
                pos = queue.poll();
                if (map[pos.z][pos.r][pos.c] == 'E') {
                    flag =true;
                    break A;
                }
                for (int d = 0; d < 6; d++) {
                    int nz = pos.z + delta_z[d];
                    int nr = pos.r + delta_r[d];
                    int nc = pos.c + delta_c[d];
                    if (0 <= nz && nz < L && 0 <= nr && nr < R && 0 <= nc && nc < C) {
                        if (!visited[nz][nr][nc] && (map[nz][nr][nc] == '.' || map[nz][nr][nc] == 'E')) {
                            visited[nz][nr][nc] = true;
                            queue.add(new Pos(nz, nr, nc));
                        }
                    }
                }
            }
        }

        if(flag)
            System.out.println("Escaped in " + (cnt - 1) + " minute(s).");
        else
            System.out.println("Trapped!");
    }
}
