package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_14503 {
    static class Position
    {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int N, M;
    static int r, c, d;
    static boolean[][] visited;
    static int[] delta_i = {-1,0,1,0}; // 북동남서
    static int[] delta_j = {0,1,0,-1};
    static int[][] map;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j ++)
                map[i][j] = scanner.nextInt();

        bfs(r, c, d);
    }

    private static void dfs(int r, int c, int d)
    {
        if(r == c)
        {
            return ;
        }
    }

    private static void bfs(int r, int c, int d) {
        Queue<Position> queue = new LinkedList<>();

        queue.add(new Position(r,c));
        visited[r][c] = true;

        while(queue.size() != 0)
        {
            Position temp = queue.poll();
            int ni = temp.i + delta_i[d % 4];
            int nc = temp.j + delta_j[d % 4];
            if(0 <= ni && ni < N && 0 <= nc && nc < M)
            {

            }
        }
    }
}
