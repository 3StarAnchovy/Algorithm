package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4963_섬의개수 {
    static int w, h; //w = j h = i
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1, 1, 0, 0, -1, 1, 1, -1}; //상하좌우, 위오, 아래오, 아래왼, 위왼
    static int[] delta_j = {0, 0, -1, 1, 1, 1, -1, -1};

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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;
            map = new int[h][w];
            visited = new boolean[h][w];

            //input
            //step1 : 입력값으로 배열 초기화 하기
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int land_cnt = 0;

            //step2 : 배열 전체 탐색하면서 bfs 돌리기 -> bfs 돌아갈때마다 섬 개수 ++
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        land_cnt++;
                        bfs(i,j);
                    }
                }
            }

            sb.append(land_cnt).append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(int i, int j) {
        Queue<Pos> que = new ArrayDeque<>();

        visited[i][j] = true;
        que.add(new Pos(i, j));

        while (!que.isEmpty()) {
            int qSize = que.size();

            while (qSize-- > 0) {
                Pos pos = que.poll();

                for (int d = 0; d < 8; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < h && 0 <= nj && nj < w && !visited[ni][nj]) {
                        if (map[ni][nj] == 1) {
                            que.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }
    }
}
