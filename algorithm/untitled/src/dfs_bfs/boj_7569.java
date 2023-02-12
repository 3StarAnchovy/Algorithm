package dfs_bfs;

import java.util.Scanner;

public class boj_7569 {
    static int N;
    static int M;
    static int H; // 높이
    static int[][][] map; //토메이로 위치
    static boolean[][][] visited;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int uncnt = 0;

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                for (int k = 0; k < M; k ++) {
                    map[i][j][k] = scanner.nextInt();
                    if(map[i][j][k] == 0)
                        uncnt ++;
                }
            }
        }
    }
}
