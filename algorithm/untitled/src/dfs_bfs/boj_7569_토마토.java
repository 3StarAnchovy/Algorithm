package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
토마토가 전체 읽는 최소 일수를 구하기

step1 입력받기 토마토는 큐에 담기
생각해보니까 visited가 필요 없다.
동시에 bfs를 시행해야하기에, 큐에 담아놓고 시작해야함


step 2 bfs 시행하면서 인접한 토마토 익히기. 토마토 익힐땐 값을 + 1하면서 익히자

step 3 map 완탐하면서 최대값 갱신하기 이때 최대값은 토마토 전체가 익는 최소 일수임.
        (이때 안익은 토마토가 있으면 -1 반환하기)

        5 3 1
        0 -1 0 0 0
        -1 -1 0 1 1
        0 0 0 1 1

5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
 */
public class boj_7569_토마토 {
    static int M, N, H; //M -> j N->i H -> k
    static int[][][] map;
    static int[] delta_i = {-1, 1, 0, 0, 0, 0, 0};
    static int[] delta_j = {0, 0, -1, 1, 0, 0};
    static int[] delta_h = {0, 0, 0, 0, -1, 1};

    static class Pos {
        int i, j, k;

        public Pos(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    static Queue<Pos> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        queue = new ArrayDeque<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];

        boolean checkT = false;

        //step0 입력받기 토마토는 큐에 담기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    map[n][m][h] = Integer.parseInt(st.nextToken());
                    if (map[n][m][h] == 1)
                        queue.add(new Pos(n, m, h));
                }
            }
        }


        //저장될때부터 모든 토마토가 익어있는 상태라면 1
        int max_day = bfs();
        System.out.println(max_day - 1);

    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                Pos pos = queue.poll();
                for (int d = 0; d < 6; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    int nk = pos.k + delta_h[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nk && nk < H) {
                        if (map[ni][nj][nk] == 0) {
                            map[ni][nj][nk] = map[pos.i][pos.j][pos.k] + 1;
                            queue.add(new Pos(ni, nj, nk));
                        }
                    }
                }
            }
        }

        int max_day = 0;
        //step 3 map 완탐하면서 최대값 갱신하기 이때 최대값은 토마토 전체가 익는 최소 일수임. (이때 안익은 토마토가 있으면 -1 반환하기)

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    max_day = Math.max(max_day, map[i][j][k]);
                }
            }
        }

        return max_day;
    }
}
