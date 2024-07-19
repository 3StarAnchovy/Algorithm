package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4179_불 {
    static int R, C;
    static int[][] map;
    static char[][] cMap;
    static int ji, jj;
    static boolean[][] visited;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] delta_i = {0, 0, -1, 1};
    static int[] delta_j = {1, -1, 0, 0};

    static Queue<Pos> fireQue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        cMap = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = input.charAt(j);
                if (c == 'F') {
                    fireQue.add(new Pos(i, j));
                    visited[i][j] = true;
                } else if (c == 'J') {
                    ji = i;
                    jj = j;

                    if(ji == 0 || ji == R -1 || jj == 0 || jj == C - 1){
                        System.out.println(1);
                        System.exit(0);
                    }
                }
                cMap[i][j] = c;

            }
        }

        fire_bfs();
        visited = new boolean[R][C];
        jbfs();
        System.out.println("IMPOSSIBLE");

    }

    private static void jbfs() {
        Queue<Pos> que = new ArrayDeque<>();
        visited[ji][jj] = true;
        que.add(new Pos(ji, jj));
        int cnt = 0;
        while (!que.isEmpty()) {
            int qSize = que.size();
            cnt++;
            while (qSize-- > 0) {
                Pos pos = que.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && cMap[ni][nj] == '.') {
                        if ((map[ni][nj] == 0 || cnt < map[ni][nj])) {
                            if (ni == R - 1 || ni == 0 || nj == 0 || nj == C - 1) { //가장자리일때
                                System.out.println(cnt + 1);
                                System.exit(0);
                            } else {
                                visited[ni][nj] = true;
                                map[ni][nj] = cnt;
                                que.add(new Pos(ni, nj));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void fire_bfs() {
        int cnt = 0;

        while (!fireQue.isEmpty()) {
            int qSize = fireQue.size();
            cnt++;
            while (qSize-- > 0) {
                Pos pos = fireQue.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = delta_i[d] + pos.i;
                    int nj = delta_j[d] + pos.j;

                    if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj]) {
                        if (cMap[ni][nj] != '#') {
                            map[ni][nj] = cnt;
                            fireQue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }
    }
}

/*
미로에서 탈출할수 있도록 도와주자!
불 먼저 bfs
지훈이 bfs
 */
