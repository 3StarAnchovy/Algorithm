package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003_피보나치 {
   private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        fibonacci(40);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < TC; i ++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }
        System.out.println(sb);
    }

    private static Integer[] fibonacci(int num){
        if(dp[num][0] == null || dp[num][1] == null){
            dp[num][0] = fibonacci(num - 1)[0] + fibonacci(num - 2)[0];
            dp[num][1] = fibonacci(num - 1)[1] + fibonacci(num-2)[1];
        }

        return dp[num];
    }
}
