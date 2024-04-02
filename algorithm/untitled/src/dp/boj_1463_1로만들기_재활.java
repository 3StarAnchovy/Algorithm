package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463_1로만들기_재활 {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];

        memo[0] = 0;
        memo[1] = 0;
        for(int i = 2; i <= N; i ++){
            memo[i] = memo[i - 1] + 1;

            if(i % 3 == 0){
                memo[i] = Math.min(memo[i / 3] + 1, memo[i]);
            }if (i % 2 == 0){
                memo[i] = Math.min(memo[i / 2] + 1, memo[i]);
            }
        }

        System.out.println(memo[N]);

    }
}
