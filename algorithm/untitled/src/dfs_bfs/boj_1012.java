package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class boj_1012 {
     //상하좌우
    static int[] delta_x = {0,-1,0,1};
    static int[] delta_y = {1,0,-1,0};
    static int M;
    static int N;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int tc = 0; tc < T; tc ++)
        {
            M = scanner.nextInt(); //가로
            N = scanner.nextInt(); //세로
            int K = scanner.nextInt();

            int[][] graph = new int[M ][N ];
            boolean[][] visited = new boolean[M ][N ];
            int cnt = 0;
            for(int i = 0; i < K; i ++)
            {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                graph[x][y] = 1;
            }

            for(int i = 0; i < M; i ++)
            {
                for(int j = 0; j < N; j ++ )
                {
                    //방문하지 않았고 현재 위치가 1일때 bfs 시작
                    if(!visited[i][j] && graph[i][j] == 1)
                    {
                        bfs(graph,visited,i,j);
                        cnt ++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int[][] graph, boolean[][] visited, int i, int j) {
        Queue<custompair> queue = new LinkedList<>();

        //큐에 정점 정보 추가
        queue.add(new custompair(i,j));
        //방문 체킹
        visited[i][j] = true;

        //큐 비우고 정점 정보 담아줌

        while(!queue.isEmpty())
        {
            custompair v = queue.poll();
            j = v.getJ();
            i = v.getI();
            //사방 탐색
            for(int r = 0; r < 4; r ++)
            {
                int dx = delta_x[r] + i;
                int dy = delta_y[r] + j;
                //인덱스 체킹
                if(dx >= 0 && dy >=0 && dx < M && dy < N)
                {
                    if(!visited[dx][dy] && graph[dx][dy] == 1)
                    {
                        queue.add(new custompair(dx,dy));
                        visited[dx][dy] = true;
                    }
                }

            }
            //visited 배열 필요 없음 -> 1을 0으로 바꿔줌
            // 변수 헷갈림 좌표 i,j
        }
    }
}
