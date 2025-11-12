package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14501_퇴사 {
    static int N;
    static int[] t;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        t = new int[N + 1];
        p = new int[N + 1];
        dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        /* 응애 */
        for (int i = 1; i <= 7; i++) {
            dp[i] = Math.max(dp[i - 1],0);
        }
    }

    /*
    dp[n] = n만큼 상담을 했을 때 금액 최대값

    dp[0] = 0
    dp[1] = 0
    dp[n] = Math.max(dp[n-1]
     */
}


