package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class swea_2105 {
    static int N;
    static int[][] map;
    //첫번쨰는 더미
    static int[] delta_i = {1, 1, -1, -1};
    static int[] delta_j = {1, -1, -1, 1};
    static boolean[] visited;
    static int max = -1;

    static class Pos {
        int i;
        int j;
        int d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            map = new int[N][N];

            //init
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            visited = new boolean[101];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(new Pos(i, j, 0), new Pos(i, j, 0), 0);// 현재위치, 출발점,
                }
            }

            System.out.println("#" + tc + " " + max);
            max = -1;
        }
    }

    private static void dfs(Pos current, Pos start, int cnt) {
        if (current.i == start.i && current.j == start.j && cnt > 1) {
            max = Math.max(max, cnt);
            return;
        }
        if (current.d == 4) {
            //방향 네번 꺾었으면
            //start의 좌표와 현재 좌표와 비교. 일치한다면 최대값 비교후 갱신
            return;
        }

        //안꺾는 경우
        int ni = current.i + delta_i[current.d];
        int nj = current.j + delta_j[current.d];
        if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]]) {
            visited[map[ni][nj]] = true;
            dfs(new Pos(ni, nj, current.d), start, cnt + 1);
            visited[map[ni][nj]] = false;
        }

        //꺾는 경우
        if (current.d < 3) {
            ni = current.i + delta_i[current.d + 1];
            nj = current.j + delta_j[current.d + 1];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]]) {
                visited[map[ni][nj]] = true;
                dfs(new Pos(ni, nj, current.d + 1), start, cnt + 1);
                visited[map[ni][nj]] = false;
            }
        }
    }
}
