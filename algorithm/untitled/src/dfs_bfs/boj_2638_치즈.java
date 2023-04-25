package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_2638_치즈 {
    static int N, M;
    static int[][] map;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int time = 0;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];

        // step1. 입력받기 (0은 공기, 1은 치즈)
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();


        //System.out.println("hi");
        while (true) {
            // step2. 치즈가 있는지 없는지 체크하기
            if (check()) break;

            //치즈가 있다면 (0,0)에서 bfs 탐색 시작
            bfs(new Pos(0, 0));
            time++;
        }
        System.out.println(time);
    }

    private static void melt(int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j] >= 3)
                    map[i][j] = 0;
            }
        }
    }

    private static void bfs(Pos pos) {
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> queue = new ArrayDeque<>();
        int[][] copy = copyArray();

        queue.add(pos);
        visited[pos.i][pos.j] = true;
        while (queue.size() != 0) {
            pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    //다음 노드가 0이라면
                    if (copy[ni][nj] == 0 && !visited[ni][nj]) {
                        queue.add(new Pos(ni, nj));
                        visited[ni][nj] = true;
                    }

                    //다음 노드가 치즈라면
                    else if (copy[ni][nj] != 0)
                        copy[ni][nj]++;
                }
            }
        }

        //공기와 인접한 치즈(배열의 값이 3 이상)라면 값 0으로 바꿔버리기
        melt(copy);
    }

    private static int[][] copyArray() {
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    //false : 치즈 있음
    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
