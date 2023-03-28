package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
접근
입력 중 높이의 최대값을 저장함.

1~최대값까지 bfs 시행
영역 개수 갱신
 */

public class boj_2468 {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int max_height;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int result = 1;

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
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                max_height = Math.max(max_height, map[i][j]);
            }
        }
        for (int k = 1; k <= max_height; k++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > k) { // 방문하지 않았고, k보다 크다면(물에 잠기지 않았다면)
                        cnt++; // 해당 bfs가 시행될때마다 영역 cnt ++;
                        bfs(new Pos(i, j), k);
                    }
                }
                result = Math.max(result,cnt);
            }
        }

        System.out.println(result);
    }

    private static void bfs(Pos pos, int rain_hegiht) {
        Queue<Pos> queue = new LinkedList<>();

        visited[pos.i][pos.j] = true;
        queue.add(pos);

        while (queue.size() != 0) {
            pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N) {
                    if (!visited[ni][nj] && map[ni][nj] > rain_hegiht) {
                        queue.add(new Pos(ni, nj));
                        visited[ni][nj] = true;
                    }
                }
            }
        }
    }
}
