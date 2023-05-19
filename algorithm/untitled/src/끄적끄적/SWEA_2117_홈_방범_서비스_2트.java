package 끄적끄적;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_2117_홈_방범_서비스_2트 {
    static int N; // arr_size
    static int M;
    static int[][] map;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int max = 1;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            map = new int[N][N];
            max = 1;

            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++)
                    map[i][j] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(new Pos(i,j));
                }
            }

            System.out.println("#"+tc + " " + max);
        }
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();
        int home_cnt = 0;
        boolean[][] visited = new boolean[N][N];

        //손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾았을 때, 그 때의 서비스를 제공받는 집들의 수
        queue.add(pos);
        visited[pos.i][pos.j] = true;

        //출발점이 집일수도있음
        if(map[pos.i][pos.j] == 1)
            home_cnt++;
        getProfit(1, home_cnt);

        int time = 1;
        while(!queue.isEmpty())
        {
            int qSize = queue.size();

            time ++;
            while(qSize -- > 0)
            {

                pos = queue.poll();
                for(int d = 0; d < 4; d ++)
                {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if( 0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj])
                    {
                        if(map[ni][nj] == 1)
                            home_cnt ++;
                        queue.add(new Pos(ni,nj));
                        visited[ni][nj] = true;
                    }
                }

                getProfit(time,home_cnt); //서비스 영역 크기, 운영 비용
            }
        }
    }

    private static void getProfit(int time, int home_cnt) {
        //이익 계산
        int a = time * time + (time - 1) * (time - 1);
        int b = home_cnt * M;

        //이익이 0 이상이면 비교 후 최대값 갱신
        if(b - a >= 0) // 이득임
            max = Math.max(max, home_cnt);
    }
}
