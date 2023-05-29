package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class swea_1868_지뢰찾기 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] delta_i = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] delta_j = {0, 1, 1, 1, 0, -1, -1, -1}; //이따 여기 체크해보기

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        //step1 : 입력받기
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();

            map = new char[N][N];
            visited = new boolean[N][N];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                String temp = scanner.next();
                map[i] = temp.toCharArray();
            }

            //step2 : 맵 전체 탐색, 방문되어있지 않고, 8방 주변에 지뢰가 없다면?
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.' && check(i, j)) {
                        visited[i][j] = true;
                        bfs(new Pos(i, j));
                    }
                }
            }

            //step3 : step3 : 방문 처리되어있지 않고, 주변에 지뢰가 있는데, 지뢰가 아닌 얘 cnt
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == '.')
                        cnt++;
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }

    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(pos);
        cnt++;

        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int d = 0; d < 8; d++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];

                if (0 <= ni && ni < N && 0 <= nj && nj < N && map[ni][nj] == '.' && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (check(ni, nj)) {
                        queue.add(new Pos(ni, nj));
                    }
                }
            }
        }
    }

    private static boolean check(int i, int j) {
        for (int d = 0; d < 8; d++) {
            int ni = i + delta_i[d];
            int nj = j + delta_j[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < N) {
                if (map[ni][nj] == '*')
                    return false;
            }
        }
        return true;
    }

}
