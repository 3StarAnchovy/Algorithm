package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1952_달팽이2 {
    static int[][] map;
    static int M, N;
    static boolean[][] visited;
    static int[] delta_i = {0, 1, 0, -1}; //우하좌상
    static int[] delta_j = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //d = ((d + 1 + 4) % 4);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];
        snail(0, 0, 0, 0, 0); // i, j, d, sum

    }

    private static void snail(int i, int j, int d, int sum, int cnt) {
        if (cnt == N * M) {
            System.out.println(sum - 1);
            return;
        }

        visited[i][j] = true;

        int ni = i + delta_i[d];
        int nj = j + delta_j[d];
        if (0 <= ni && ni < M && 0 <= nj && nj < N && !visited[ni][nj]) {
            snail(ni, nj, d, sum, cnt + 1);
        } else {
            int nd = (d + 1 + 4) % 4;
            ni = i + delta_i[nd];
            nj = j + delta_j[nd];
            snail(ni, nj, nd,sum + 1, cnt + 1);
        }
    }
}
