package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_14503 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    //북동남서 상우하좌
    static int[] dir_i = {1, 0, -1, 0};
    static int[] dir_j = {0, 1, 0, -1};
    static int cnt = 0;

    static class Position {
        int i;
        int j;

        public Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //init
        N = scanner.nextInt();
        M = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int head = scanner.nextInt();

        Position start = new Position(r, c);
        map = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();

        //action
        DFS(start, head);
        System.out.println(cnt);
    }

    private static void DFS(Position start, int head) {
        if (map[start.i][start.j] == 1) {
            return;
        }

        for (int i = 1; i < 5; i++) {
            int ni = start.i + dir_i[(head + i) % 4];
            int nj = start.j + dir_j[(head + i) % 4];
            if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                if(map[ni][nj] == 0) {
                    map[ni][nj] = -1;
                    cnt ++;
                    DFS(new Position(ni, nj), (head + i) % 4);
                }

                else if(map[ni][nj] == 1)
                {
                    return;
                }
            }
        }



    }
}
