package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11660_구간합구하기5 {
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        /*
        dp[i][j] i 행의 j까지의 합
         */

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //init
        for (int i = 1; i <= N; i++)
            dp[i][1] = map[i][1];

        //memo
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // x= i
            // y = j

            for (int j = x1; j <= x2; j++) {
                sum += dp[j][y2] - dp[j][y1 - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
