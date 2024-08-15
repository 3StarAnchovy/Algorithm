package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17484_진우의달여행 {
    static int[][] map;
    static int[] delta_i = {1, 1, 1};
    static int[] delta_j = {-1, 0, 1};
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < M; j++) {
            dfs(0, -1, map[0][j], 0, j); //cnt, 이전 방향, 다음 방향, sum
        }
        System.out.println(min);
    }

    private static void dfs(int cnt, int nd, int sum, int ni, int nj) {
        if (cnt == N - 1) {
            min = Math.min(min,sum);
            return;
        }

        for (int d = 0; d < 3; d++) {
            if (d == nd)
                continue;
            int nni = ni + delta_i[d];
            int nnj = nj + delta_j[d];
            if (0 <= nni && nni < N && 0 <= nnj && nnj < M) {
                dfs(cnt + 1, d, sum + map[nni][nnj], nni, nnj);
            }
        }
    }
}

/*
방향은 총 3가지
연로를 최대한 아끼며 지구의 어느위치에서든 출발하여 달의 어느위치든 착륙하는 것이다.
 */
