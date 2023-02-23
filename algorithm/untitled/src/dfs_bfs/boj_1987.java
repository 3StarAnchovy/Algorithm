package dfs_bfs;

import java.util.Scanner;

public class boj_1987 {
    static int R;
    static int C;
    static boolean[] visited;
    static char[][] map;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int cnt;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();

        map = new char[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++)
        {
            String input = scanner.next();
            map[i] = input.toCharArray();
        }

        DFS(0,0, cnt + 1);
        System.out.println(max);
    }

    public static void DFS(int r, int c, int cnt)
    {
        if(max < cnt)
            max = cnt;

        visited[map[r][c] - 'A'] = true;

        for(int i = 0; i < 4; i ++) {
            int nr = r + delta_i[i];
            int nc = c + delta_j[i];
            if(0 <= nr && nr < R && 0 <= nc && nc < C) // 인덱스 체킹
            {
                if(!visited[map[nr][nc] - 'A']) {
                    DFS(nr, nc, cnt + 1);
                    visited[map[nr][nc] - 'A'] = false; //
                }
            }
        }
    }
}
