package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class CustomPosition
{
    int n;
    int m;

    public CustomPosition(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
}

public class boj_7576 {
    static int N;
    static int M;
    static int[][] map;
    static int[] delta_n = {-1,1,0,0};
    static int[] delta_m = {0,0,-1,1};
    static int[][] day_cnt;
    static Queue<CustomPosition> queue;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        queue = new LinkedList<>();

        M = scanner.nextInt();
        N = scanner.nextInt();

        map = new int[N][M];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                map[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                if(map[i][j] == 1)
                    queue.add(new CustomPosition(i,j));
            }
        }

        BFS();
        int max = -1;
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j++)
            {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if(max < map[i][j])
                    max = map[i][j];
            }
        }

        System.out.println(max - 1);
    }

    private static void BFS() {
        while(queue.size() != 0)
        {
            CustomPosition temp = queue.poll();
            int n = temp.getN();
            int m = temp.getM();

            for(int i = 0; i < 4; i ++)
            {
                int nn = n + delta_n[i]; // next n,m
                int nm = m + delta_m[i];
                if(0 <= nn && nn < N &&  0 <= nm && nm < M)
                {
                    if(map[nn][nm] == 0)
                    {
                        map[nn][nm] = map[n][m] + 1;
                        queue.add(new CustomPosition(nn,nm));
                    }
                }
            }
        }
    }
}
