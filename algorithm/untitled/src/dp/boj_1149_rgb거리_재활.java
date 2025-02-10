package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149_rgb거리_재활 {
    static int N;
    static int[][] dp;
    static int[] r;
    static int[] g;
    static int[] b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        r = new int[N];
        g = new int[N];
        b = new int[N];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());

        }

        dp[0][0] = r[0];
        dp[0][1] = g[0];
        dp[0][2] = b[0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r[i];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g[i];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + b[i];
        }

        int min = Math.min(dp[N-1][0], dp[N-1][1]);
        min = Math.min(dp[N-1][2], min);

        System.out.println(min);
    }
}

/*
집이 n개 있음. 1번부터 n번집이 순서대로 있음
빨초파 중 하나로 칠해야함
빨강,초록,파랑으로 칠하는 비용이 주어졌을때, 모든집을 칠하는 비용의 최소값

- 1번집의 색은 2번집의 색과 같지 않아야한다
-n번집의 색은 n-1번의 집 색과 같지 않아야한다
 */

/*
1.테이블 정의하기
2.점화식짜기
3. 초기값 박기

dp[0][i] 시작이 초록일때 i까지 최소거리
dp[i] = dp[i -1]
r g b r g b r g
r b g
dp[1][i] 시작이 빨강일 때 i까지 최소거리
dp[2][i] 시작이 파랑일때 i까지 최소거리


 */