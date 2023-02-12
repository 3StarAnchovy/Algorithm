package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position
{
    private int n;
    private int m;

    public Position(int n, int m) {
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

public class boj_2178 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] step_cnt;

    //상하좌우
    static int[] delta_n = {-1,1,0,0};
    static int[] delta_m = {0,0,-1,1};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        //init
        map = new int[N][M];
        visited = new boolean[N][M];
        step_cnt = new int[N][M];
        step_cnt[N-1][M-1] = Integer.MAX_VALUE;

        //input
        for(int i = 0; i < N; i ++)
        {
            String input = scanner.next();
            for(int j = 0; j < M; j ++)
                map[i][j] = input.charAt(j) - '0';
        }

        //출발 : 0,0 / 도착 : N-1,M-1
        BFS(new Position(0,0));
        System.out.println(step_cnt[N-1][M-1]);
    }

    private static void BFS(Position position) {
        Queue<Position> queue = new LinkedList<>();

        queue.add(position);
        int n = position.getN();
        int m = position.getM();
        visited[n][m] = true;
        step_cnt[n][m] = 1;

        while(queue.size() != 0)
        {
            Position temp = queue.poll();
            n = temp.getN();
            m = temp.getM();
            //사방탐색
            for(int i = 0; i < 4; i ++)
            {
                int next_n = n + delta_n[i];
                int next_m = m + delta_m[i];
                //인덱스 초과 방지
                if(next_n >= 0 && next_m >= 0 && next_n < N && next_m < M)
                {
                    //방문하지 않았다면, 방문찍고
                    //여태까지 걸어온 수 기록
                    //
                    if(!visited[next_n][next_m] && map[next_n][next_m] == 1)
                    {
                        visited[next_n][next_m] = true;
                        step_cnt[next_n][next_m] = step_cnt[n][m] + 1;
                        queue.add(new Position(next_n,next_m));
                    }
                }
            }
        }
    }
}
