package simulation;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
//50 * 50
//"모든 빈칸"을 채울수있는 최소시간
public class boj_17141_연구소2 {
    static int N,M; // N * N, M=바이러스 개수
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int[][] map;
    static int[][] copy;
    static int min = Integer.MAX_VALUE;
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
        map = new int[N][N];
        copy = new int[N][N];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                map[i][j] = scanner.nextInt();
                //copy[i][j] = map[i][j];
            }
        }
        combi(0,0); //cnt, start

        if(min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min-1);
    }

    private static void combi(int cnt, int start) {
        if(cnt == M)
        {
            //바이러스 ㄱㄱ
            //확산시키기전에 백업하기
            copyArr();
            int time = virusAction();

            //바이스러가 빈공간 없이 다 퍼졌는지 체크
            if(checkVirus())
            {
                //최소값이면 갱신
                min = Math.min(min,time);
            }
            //System.out.println("----");
            //restore
            //restoreArr();
            return;
        }

        for(int i = start; i < N * N; i ++)
        {
            //idx = (i * N) + j
            int r = i / N;
            int c = i % N;
            //놓을 수 있는 자리라면
            //바이러스 놓기(바이러스 == 3, 다음노드가 0이거나 2면 퍼질수 있어야됨)
            if(map[r][c] == 2)
            {
                map[r][c] = 3;
               // System.out.println(r + " " + c);
                combi(cnt + 1,i);
                map[r][c] = 2; // restore
            }
        }
    }

    private static boolean checkVirus() {
        for(int i = 0; i < N; i ++)
        {
            for(int j= 0; j < N; j ++)
            {
                if(copy[i][j] == 0 || copy[i][j] == 2)
                    return false;
            }
        }
        return true;
    }

    private static void copyArr() {
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                copy[i][j] = map[i][j];
            }
        }
    }

    private static int virusAction() {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int time = 0;

        //배열중 바이러스인거 큐에 담기
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(copy[i][j] == 3) {
                    queue.add(new Pos(i, j));
                    visited[i][j] = true;
                }
            }
        }

        //바이러스 확산시키기
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            time ++;
            while(qSize -- > 0)
            {
                Pos next = queue.poll();
                for(int d = 0; d < 4; d++)
                {
                    int ni = next.i + delta_i[d];
                    int nj = next.j + delta_j[d];

                    if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj])
                    {
                        //다음 노드가 0이거나 2라면 확산해야함
                        if(copy[ni][nj] == 0 || copy[ni][nj] == 2)
                        {
                            visited[ni][nj] = true;
                            copy[ni][nj] = 3;
                            queue.add(new Pos(ni,nj));
                        }
                    }
                }
            }
        }

        return time;
    }
}
