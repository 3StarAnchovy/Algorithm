package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_1600_말이_되고픈_원숭이 {
    static int K; //말의 움직임
    static int W, H; // 가로길이, 세로길이
    static int[][] map;
    static boolean[][][] visited;
    static int[] delta_i = {-1, 1, 0, 0}; //원숭이 delta
    static int[] delta_j = {0, 0, -1, 1};
    static int[] h_delta_i = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] h_delta_j = {-1, 1, 2, 2, 1, -1, -2, -2};

    static class Pos {
        int i;
        int j;
        int h_cnt;

        public Pos(int i, int j, int h_cnt) {
            this.i = i;
            this.j = j;
            this.h_cnt = h_cnt;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //step1. 입력
        K = scanner.nextInt();
        W = scanner.nextInt();
        H = scanner.nextInt();

        map = new int[H][W];
        visited = new boolean[K + 1][H][W];

        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                map[i][j] = scanner.nextInt();

        bfs(new Pos(0, 0, 0));
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();

        visited[pos.h_cnt][pos.i][pos.j] = true;
        queue.add(pos);

        int time = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            time++;
            while (qSize-- > 0) {
                pos = queue.poll();
                //현재위치가 도착지라면 time 반환하기
                if (pos.i == H - 1 && pos.j == W - 1) {
                    System.out.println(time - 1);
                    return ;
                }

                //원숭이의 움직임으로 가기
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < H && 0 <= nj && nj < W && !visited[pos.h_cnt][ni][nj]) {
                        if (map[ni][nj] == 0) {
                            visited[pos.h_cnt][ni][nj] = true;
                            queue.add(new Pos(ni, nj,pos.h_cnt));
                        }
                    }
                }

                //말의 움직임이 남아있다면 말의 움직임으로 가기
                if (pos.h_cnt == K) continue;

                for (int d = 0; d < 8; d++) {
                    int ni = pos.i + h_delta_i[d];
                    int nj = pos.j + h_delta_j[d];

                    if (0 <= ni && ni < H && 0 <= nj && nj < W && !visited[pos.h_cnt + 1][ni][nj]) {
                        if (map[ni][nj] == 0) {
                            visited[pos.h_cnt + 1][ni][nj] = true;
                            queue.add(new Pos(ni, nj,pos.h_cnt + 1));
                        }
                    }
                }

            }
        }
        System.out.println(-1);
    }
}
