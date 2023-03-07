package brute_force;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_14502 {
    static int N;
    static int M;
    static int[][] map;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        //step1. 벽 세우기 -> 조합 64C3
        setWall(0, 0, 0);
        System.out.println(result);

        //step 2. 벽 세운거 복사 -> 바이러스 살포

        //step 3. 바이러스 살포 후 안전영역 체크

        //step 4. 안전 영역이 기존 값보다 크다? -> ㅇㅋ 갱신
    }

    private static void setWall(int cnt, int start_i, int start_j) {
        if (cnt == 3) {
            int[][] temp = copyArray(map);
            virusAction(temp);
            result = Math.max(checkSafeArea(temp), result);
            //printMap(temp);
            return;
        }

        for (int i = start_i; i < N; i++) { // 이거 이해 잘 못하겠음. 내일 물어보자.
            int temp;
            if(i == start_i)
                temp = start_j;
            else
                temp = 0;
            for (int j = temp; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(cnt + 1, i, j);
                    map[i][j] = 0; // restore
                }
            }
        }
    }

    private static int checkSafeArea(int[][] temp) {
        int cnt = 0;
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                if(temp[i][j] == 0)
                    cnt ++;
            }
        }

        return cnt;
    }

    private static void virusAction(int[][] temp) {
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                if(temp[i][j] == 2)
                    bfs(new Pos(i,j), temp);
            }
        }
    }

    private static void bfs(Pos pos, int[][] temp) {
        Queue<Pos> queue = new LinkedList<>();

        queue.add(pos);

        while(queue.size() != 0)
        {
            pos = queue.poll();
            for(int d = 0; d < 4; d ++)
            {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < M)
                {
                    if(temp[ni][nj] == 0)
                    {
                        temp[ni][nj] = 2;
                        queue.add(new Pos(ni,nj));
                    }
                }
            }
        }
    }

    private static int[][] copyArray(int[][] map) {
        int[][] copy_arr = new int[N][M];

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                copy_arr[i][j] = map[i][j];
            }
        }

        return copy_arr;
    }

    private static void printMap(int[][] map) {
        System.out.println();
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


}
