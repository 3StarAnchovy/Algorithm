package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
접근
섬의 외곽선에 -1로 표시.
-1 끼리 또 bfs 돌려서 최소거리 도출?
n ^ 2 = 100 ^ 2 존나 충분
 */

public class boj_2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static class Pos
    {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        map = new int[N][N];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                map[i][j] = scanner.nextInt();
            }
        }

        visited = new boolean[N][N];
        //섬 외곽 표시
        int area_num = -1;
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(map[i][j] == 1 && !visited[i][j])
                {
                    bfs(new Pos(i,j),area_num);
                    area_num --;
                }
            }
        }

        //printArr(map);

        //외곽 표시 했으면 최소거리 도출.
        //포문돌려서 맵이 -1일 때 탐색 시작
        //-이면 0 주변으로 계속 탐색하다가 자신과 다른 영역의 음수를 만나면 거리 체킹
        //체킹한 거리가 최소값이라면 최소값 갱신

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(map[i][j] < 0)
                {
                    visited = new boolean[N][N];
                    bfs_for_min_search(new Pos(i,j),map[i][j]);
                }
            }
        }

        System.out.println(min - 1);
    }

    private static void bfs_for_min_search(Pos pos, int area_num) {
        Queue<Pos> queue = new LinkedList<>();

        visited[pos.i][pos.j] = true;
        queue.add(pos);
        int cnt = 0;

        while (!queue.isEmpty())
        {
            int q_size = queue.size();
            cnt ++;
            while(q_size -- > 0)
            {
                pos = queue.poll();
                for(int d = 0; d < 4; d ++)
                {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if(0 <= ni && ni < N && 0 <= nj && nj < N)
                    {
                        //0이면 큐에 담으면서 계속 탐색
                        if(!visited[ni][nj] && map[ni][nj] == 0)
                        {
                            visited[ni][nj] = true;
                            queue.add(new Pos(ni,nj));
                        }
                        //본인과 다른 영역에 음수라면 최소값 비교, 최소값이라면 갱신
                        if(map[ni][nj] < 0 && map[ni][nj] != area_num)
                            min = Math.min(min,cnt);
                        if(cnt > min)
                            return;
                    }
                }
            }
        }
    }

    //외곽선 표시
    //1 주변에 0 있으면 외곽임
    //map이 1일 때 사방 주변으로 체킹해서 0 있으면 자신은 -1
    private static void bfs(Pos pos,int area_num) {
        Queue<Pos> queue = new LinkedList<>();

        visited[pos.i][pos.j] = true;
        queue.add(pos);

        while(queue.size() != 0)
        {
            pos = queue.poll();
            for(int d = 0; d < 4; d ++)
            {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if(0 <= ni && ni < N && 0 <= nj && nj < N)
                {
                    //1이면 큐에 담으면서 계속 탐색
                    if(!visited[ni][nj] && map[ni][nj] == 1)
                    {
                        visited[ni][nj] = true;
                        queue.add(new Pos(ni,nj));
                    }
                    //0이면 외곽이라는 뜻. 담진 않고 현재 값을 -1로 바꾼다.
                    if(map[ni][nj] == 0)
                        map[pos.i][pos.j] = area_num;
                }
            }
        }
    }

    private static void printArr(int[][] map)
    {
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
