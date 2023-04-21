package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_2589_보물섬 {
    static int R,C;
    static char[][] map;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int max = 0;
    static class Pos
    {
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
        for (int i = 0; i < R; i++) {
            String temp = scanner.next();
            map[i] = temp.toCharArray();
        }

        for(int i = 0; i < R; i ++)
        {
            for(int j = 0; j < C; j ++)
            {
                if(map[i][j] == 'L')
                {
                    bfs(new Pos(i,j));
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        queue.add(pos);
        visited[pos.i][pos.j] = true;

        int distance = 0;
        while(!queue.isEmpty())
        {
            distance ++;
            int qSize = queue.size();
            while(qSize -- > 0)
            {
                pos = queue.poll();
                for(int d = 0; d < 4; d ++)
                {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if(0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj])
                    {
                        if(map[ni][nj] == 'L') {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }

        // 이거 다 끝났을때 출발위치에서 갈 수 있는 모든거
        max = Math.max(distance,max);
    }
}
