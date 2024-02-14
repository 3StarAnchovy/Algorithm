package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] memo = new int[11];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i = 4; i <= 10; i ++){
            memo[i] = memo[i -1] + memo[i - 2] + memo[i - 3];
        }

        for(int t = 0; t < T; t ++){
            int n = Integer.parseInt(br.readLine());

            sb.append(memo[n]).append('\n');
        }

        System.out.print(sb);
    }
}
