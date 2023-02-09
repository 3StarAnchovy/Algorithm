package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class custompair
{
    private int i;
    private int j;

    public custompair(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }
}
public class boj_1926 {
    static int n; // 세로
    static int m; // 가로
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        int draw_cnt = 0;
        int draw_size = 0;
        int max = 0;

        //input
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < m; j ++)
                map[i][j] = scanner.nextInt();

        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < m; j ++)
            {
                if(!visited[i][j] && map[i][j] == 1)
                {
                    draw_cnt ++;
                    custompair customPair = new custompair(i,j);
                    draw_size = drawBFS(customPair);
                    if(max < draw_size)
                        max = draw_size;
                }
            }
        }
        System.out.println(draw_cnt);
        System.out.println(max);
    }
    private static int drawBFS(custompair customPair)
    {
        int cnt = 1;
        Queue<custompair> queue = new LinkedList<>();

        queue.add(customPair);
        int __i = customPair.getI();
        int __j = customPair.getJ();
        visited[__i][__j] = true;

        while(queue.size() != 0)
        {
            custompair v = queue.poll();
            for(int i = 0; i < 4; i ++)
            {
                int nr = delta_i[i] + v.getI();
                int nc = delta_j[i] + v.getJ();
                if(nr >= 0 && nc >= 0 && nr < n && nc < m)
                {
                    if(!visited[nr][nc] && map[nr][nc] == 1)
                    {
                        queue.add(new custompair(nr,nc));
                        visited[nr][nc] = true;
                        cnt ++;
                    }
                }
            }
        }
        return cnt;

    }
}
