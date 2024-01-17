package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은것의 넓이를 출력하라.
 */

public class boj_1926_그림 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = 0;

        //init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int draw_cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //    step1 - 맵 전체 탐방중 1이면 bfs 돌기 (bfs 돌때마다 그림 개수 ++)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    draw_cnt++;
                    max = Math.max(bfs(i,j), max);
                }
            }
        }

        System.out.println(draw_cnt);
        System.out.println(max);
    }

    //    step 2
    //        - bfs 돌면서 큐 내부에서 큐에 값이 들어올때마다 넓이 ++;
    //    - bfs가 끝날때 넓이가 이전값보다 크다면 갱신하기
    private static int bfs(int i, int j) {
        Queue<Pos> queue = new ArrayDeque<>();
        Pos pos = new Pos(i, j);

        int area = 0;
        visited[i][j] = true;
        queue.add(pos);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                pos = queue.poll();
                area++;
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (map[ni][nj] == 1) {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }

        return area;
    }
}
