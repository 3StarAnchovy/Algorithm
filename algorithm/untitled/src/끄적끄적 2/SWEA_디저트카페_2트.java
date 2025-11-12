package 끄적끄적;

import java.util.Scanner;

public class SWEA_디저트카페_2트 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] delta_i = {1,1,-1,-1};
    static int[] delta_j = {1,-1,-1,1};
    static int max = -1;
    static class Pos{
        int i;
        int j;
        int d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for(int tc = 1; tc <= TC; tc ++)
        {
            max = -1;
            //step1 : 입력받기
            N = scanner.nextInt();
            map = new int[N][N];
            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++)
                    map[i][j] = scanner.nextInt();
            }

            visited = new boolean[100 + 1];

            //step2 : dfs 시행
            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++)
                {
                    dfs(new Pos(i,j,0), new Pos(i,j,0), 0); // start
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(Pos start, Pos current, int cnt) {
        if(cnt != 0 && current.i == start.i && current.j == start.j)
        {
            max = Math.max(max,cnt);
        }
        if(current.d == 4)
            return;

        //꺾는 경우
        if(current.d < 3)
        {
            int ni = current.i + delta_i[current.d + 1];
            int nj = current.j + delta_j[current.d + 1];
            if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]])
            {
                visited[map[ni][nj]] = true;
                dfs(start, new Pos(ni,nj, current.d + 1), cnt + 1);
                visited[map[ni][nj]] = false;
            }
        }

        //꺾지 않는 경우
        int ni = current.i + delta_i[current.d];
        int nj = current.j + delta_j[current.d];
        if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]])
        {
            visited[map[ni][nj]] = true;
            dfs(start, new Pos(ni,nj, current.d), cnt + 1);
            visited[map[ni][nj]] = false;
        }
    }
}
