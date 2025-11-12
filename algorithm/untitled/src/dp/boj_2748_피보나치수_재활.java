package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2748_피보나치수_재활 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.print(0);
            return;
        }
        dp = new long[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        /* 테이블 쌓기 */
        long result = dynamicFiboTopDown(N);
        System.out.print(result);
    }
    private static int fibo(int depth) {
        if(depth == 1) return 1;
        if(depth == 0) return 0;

        return fibo(depth - 1) + fibo(depth - 2);
    }

    private static long dynamicFiboTopDown(int depth) {
        if(depth == 1) return 1;
        if(depth == 0) return 0;

        if(dp[depth] != 0) {
            return dp[depth];
        }
        else {
            dp[depth] = dynamicFiboTopDown(depth-1) + dynamicFiboTopDown(depth -2);
            return dp[depth];
        }
    }

}

/*

 */