package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2748_피보나치수2 {
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[91];
        for(int i = 0; i <= 90; i ++){
            dp[i] = -1;
        }
        int num = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibo(num));
    }

    private static long fibo(int num) {
        if(dp[num] == -1){
            dp[num] = fibo(num - 1) + fibo(num -2);
        }

        return dp[num];
    }
}
