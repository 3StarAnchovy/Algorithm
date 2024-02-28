package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1913_달팽이_재활 {
    static int N, K;
    static int[][] arr;
    static int[] delta_i = {1, 0, -1, 0}; //하 우 상 좌
    static int[] delta_j = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        int answer_i = 1;
        int answer_j = 1;

        int a = N * N;
        int i = 0, j = 0;
        arr[0][0] = a;
        visited[0][0] = true;
        int d = 0;

        while (a > 1) {
            a--;
            int ni = i + delta_i[d];
            int nj = j + delta_j[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                arr[ni][nj] = a;
            } else {
                d = ((d + 1 + 4) % 4);
                ni = i + delta_i[d];
                nj = j + delta_j[d];

                arr[ni][nj] = a;
            }

            visited[ni][nj] = true;

            if (arr[ni][nj] == K) {
                answer_i = ni + 1;
                answer_j = nj + 1;
            }

            i = ni;
            j = nj;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(arr[r][c]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(answer_i).append(" ").append(answer_j);

        System.out.print(sb);
    }
}
