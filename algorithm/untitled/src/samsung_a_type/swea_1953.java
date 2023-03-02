package samsung_a_type;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_1953 {
    static int N;
    static int M;
    static int R;
    static int C;
    static int L;
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_r = {-1, 1, 0, 0, -1, 1, 1, -1}; //상하좌우, 상우, 하우 ,하좌, 상좌
    static int[] delta_c = {0, 0, -1, 1, 1, 1, -1, -1};

    static Queue<Position> queue;
    static int cnt;

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            R = scanner.nextInt();
            C = scanner.nextInt();
            L = scanner.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            cnt = 0;
            bfs(new Position(R, C));
            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static void bfs(Position v) {
        queue = new LinkedList<>();

        int __r = v.r;
        int __c = v.c;
        visited[__r][__c] = true;
        queue.add(v);
        L--;
        cnt++;

        while (!queue.isEmpty()) {
            if (L  == 0)
                break;

            int size = queue.size();

            while (size-- > 0) {
                v = queue.poll();
                __r = v.r;
                __c = v.c;

                switch (map[__r][__c]) {
                    case 1: // 사방
                        searchAdj(__r, __c, 0, 4);
                        break;
                    case 2:
                        searchAdj(__r, __c, 0, 2);
                        break;
                    case 3:
                        searchAdj(__r, __c, 2, 4);
                        break;
                    case 4:
                        searchAdj(__r, __c, 4, 5);
                        break;
                    case 5:
                        searchAdj(__r, __c, 5, 6);
                        break;
                    case 6:
                        searchAdj(__r, __c, 6, 7);
                        break;
                    case 7:
                        searchAdj(__r, __c, 7, 8);
                        break;

                }
            }
            L--;
        }
    }



    private static void searchAdj(int r, int c, int to, int from) {
        for (int i = to; i < from; i++) {
            int nr = r + delta_r[i];
            int nc = c + delta_c[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < M) {
                if (!visited[nr][nc] && map[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    queue.add(new Position(nr, nc));
                    cnt++;
                }
            }
        }
    }
}
