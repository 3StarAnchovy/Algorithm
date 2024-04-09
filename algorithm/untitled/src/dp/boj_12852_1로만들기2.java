package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12852_1로만들기2 {
    static int[] memo;
    static int[] trace;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        trace = new int[N + 1];


        memo[1] = 0;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + 1;
            trace[i] = i - 1;
            if(i % 2 == 0 && memo[i] > memo[i/2] + 1){
                memo[i] = memo[i/2] + 1;
                trace[i] = i/2;
            }

            if (i % 3 == 0 && memo[i] > memo[i/3] + 1) {
                memo[i] = memo[i/3] + 1;
                trace[i] = i / 3;
            }
        }

        System.out.println(memo[N]);
        while (N > 0){
            System.out.print(N +" ");
            N = trace[N];
        }

    }
}

/*
테이블 정하기
dp[i] = i를 만들기 위한 최소 연산수

점화식 뽑기
dp[i] = min(dp[i / 3] + 1, dp[i -1] + 1)
dp[i] = min(dp[i/2] + 1, dp[i -1] + 1)

초기값 박기
dp[1] = 0;

 */
/*
1 befor[1] = 2;
1 2 before[2] = 1;
1 3 before[] before[3] = 1
1 2 4
 */