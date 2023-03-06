package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_2573 {
    static int N; // 행
    static int M; // 열
    static int map[][];
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int result;
    static class Pos
    {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                map[i][j] = scanner.nextInt();
            }
        }

        int ice_cnt;
        int year = 0;
        //step1. 빙산 덩이 체크
        while((ice_cnt = checkIce()) < 2)
        {
            //checkIce()가 0 이면 0 출력
            if(ice_cnt == 0)
            {
                year = 0;
                break;
            }
            //빙산 덩이가 2덩이 미만이라면 1년 올리고 녹이기
            melt();
            year ++;

        }
        System.out.println(year);
        //빙산 덩이가 2덩이 이상이면 출력


    }

    private static void melt() {
        //동시에 바뀌어야하므로 맵의 변화량을 담을 배열 생성
        int[][] change = new int[N][M];

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                if(map[i][j] > 0) {
                    for(int d = 0; d < 4; d ++)
                    {
                        int ni = i + delta_i[d];
                        int nj = j + delta_j[d];
                        if(0 <= ni && ni < N && 0 <= nj && nj < M)
                        {
                            if(map[ni][nj] <= 0)
                            {
                                change[i][j] ++;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                map[i][j] -= change[i][j];
            }
        }
    }

    /*
    return 빙산 덩이 수
     */
    private static int checkIce()
    {
        int cnt = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                if(!visited[i][j] && map[i][j] > 0)
                {
                    bfs(i,j, visited);
                    cnt ++;
                }
            }
        }

        return cnt;
    }

    private static void bfs(int i, int j, boolean[][] visited) {
        Queue<Pos> queue = new LinkedList<>();
        Pos nextPos;

        visited[i][j] = true;
        queue.add(new Pos(i,j));

        while(queue.size() != 0)
        {
            nextPos = queue.poll();

            for(int d = 0; d < 4; d ++)
            {
                int ni = nextPos.i + delta_i[d];
                int nj = nextPos.j + delta_j[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < M)
                {
                    if(!visited[ni][nj] && map[ni][nj] > 0)
                    {
                        visited[ni][nj] = true;
                        queue.add(new Pos(ni,nj));
                    }
                }
            }
        }
    }
}
