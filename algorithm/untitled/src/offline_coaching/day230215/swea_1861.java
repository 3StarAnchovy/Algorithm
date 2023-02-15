package offline_coaching.day230215;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class position
{
    int i;
    int j;

    public position(int i, int j) {
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


public class swea_1861 {
    /* 접근 1
    - 사방탐색하다가 자기보다 1 크면 이동
    - visit 찍고 쭉 탐색
    - 탐색 할 때마다
     */
    static int[][] map;
    static int N;
    static boolean[][] visited;

    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for(int t = 1; t <= TC; t ++)
        {
            int max = 0;
            int cnt = 0;
            position max_pos = null;
            N = scanner.nextInt();

            map = new int[N][N];


            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++) {
                    visited = new boolean[N][N];
                    cnt = bfs(new position(i, j));
                    if(max < cnt) {
                        max_pos = new position(i,j);
                        max = cnt;
                    }
                }
            }
            System.out.println("#" + t + " " + map[max_pos.getI()][max_pos.getJ()] + " " + max);
        }
    }

    private static int bfs(position position)
    {
        int cnt = 1;
        Queue<position> queue = new LinkedList<>();

        queue.add(position);
        int __i = position.getI();
        int __j = position.getJ();

        visited[__i][__j] = true;
        while(queue.size() != 0)
        {
            position temp = queue.poll();
            __i = temp.getI();
            __j = temp.getJ();

            for(int i = 0; i < 4; i ++)
            {
                int ni = __i + delta_i[i];
                int nj = __j + delta_j[i];
                if(0 <= ni && ni < N && 0 <= nj && nj < N)
                {
                    if(!visited[ni][nj] && map[ni][nj] == map[__i][__j] + 1)
                    {
                        visited[ni][nj] = true;
                        queue.add(new position(ni,nj));
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }
}
