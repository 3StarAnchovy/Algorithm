package simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
접근
깡구현인거같음
delta 선언
원베이스

구름 생성 // 얘는 큐 써서 구현해보자
이동 구현
비 내리기 구현
구름 사라지기 구현
물복사 구현

 */
public class boj_21610 {
    static int N, M;
    static int d, s; // 이동방향, 거리
    static int[][] basket;
    static boolean[][] visited;

    static int[] delta_i = {0,0, -1, -1, -1, 0, 1, 1, 1};
    static int[] delta_j = {0,-1, -1, 0, 1, 1, 1, 0, -1};

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static Queue<Pos> cloud = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        basket = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                basket[i][j] = scanner.nextInt();

        //초기 구름 생성
        cloud.add(new Pos(N, 1));
        cloud.add(new Pos(N, 2));
        cloud.add(new Pos(N - 1, 1));
        cloud.add(new Pos(N - 1, 2));

        for (int m = 0; m < M; m++) {
            d = scanner.nextInt();
            s = scanner.nextInt();
            visited = new boolean[N + 1][N + 1];
            //이동 구현
            move();
            //비 내리기 구현
            rain();
            //구름삭제 + 물복사 버그, 구름 삭제할때 visit체킹 해야함
            copyBug();

            makeCloud();
        }
        System.out.println(getSum());
    }

    private static int getSum() {
        int sum = 0;

        for(int i = 1; i <= N; i ++)
        {
            for(int j = 1; j <= N; j ++)
            {
                sum += basket[i][j];
            }
        }
        return sum;
    }

    private static void copyBug() {
        while (cloud.size() != 0)
        {
            Pos pos = cloud.poll();
            //대각 탐색
            int cnt = 0;
            for(int d = 2; d <= 8; d+= 2)
            {
                //
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if(1 <= ni && ni <= N && 1 <= nj && nj <= N && basket[ni][nj] >= 1)
                {
                    cnt ++;
                }
            }

            basket[pos.i][pos.j]+=cnt;
            visited[pos.i][pos.j] = true;
        }
    }

    private static void rain() {
        for(Pos pos : cloud)
        {
            basket[pos.i][pos.j] += 1;
        }
    }

    private static void makeCloud() {
        for(int i = 1; i <= N; i ++)
        {
            for(int j = 1; j <= N; j ++)
            {
                if(basket[i][j] >= 2 && !visited[i][j])
                {
                    cloud.add(new Pos(i,j));
                    basket[i][j] -= 2;
                }
            }
        }
    }

    private static void move() {
        int qSize = cloud.size();
        while (qSize-- > 0) {
            Pos current = cloud.poll();

            int ni = current.i;
            int nj = current.j;

            for (int i = 0; i < s; i++) {
                ni += delta_i[d];
                nj += delta_j[d];
            }
            while(ni<=0){
                ni+=N;
            }
            while(ni>N){
                ni-=N;
            }
            while(nj<=0){
                nj+=N;
            }
            while(nj>N){
                nj-=N;
            }
            cloud.add(new Pos(ni, nj));
        }
    }
}
