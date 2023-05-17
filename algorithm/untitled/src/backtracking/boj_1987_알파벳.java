package backtracking;

import java.util.Scanner;

public class boj_1987_알파벳 {
    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int max;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();

        map = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String temp = scanner.next();
            for (int j = 0; j < C; j++)
                map[i][j] = temp.charAt(j);
        }

        visited[map[0][0] - 'A'] = true;
        dfs(0, 0, 0); //i,j,cnt
        System.out.println(max + 1);
    }

    private static void dfs(int i, int j, int cnt) {
        if (cnt > max) {
            max = cnt;
        }

        //사방탐색 제끼고,
        for (int d = 0; d < 4; d++) {
            int ni = i + delta_i[d];
            int nj = j + delta_j[d];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[map[ni][nj] - 'A']) {
                //갈수있다면 방문, 다음 재귀 호출 후 리스토어
                visited[map[ni][nj] - 'A'] = true;
                dfs(ni, nj, cnt + 1);
                visited[map[ni][nj] - 'A'] = false;
            }

        }


    }
}
