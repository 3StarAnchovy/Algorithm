package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463_1로_만들기_재활 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 0;

        for(int i = 2; i <= N; i ++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1 , dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}

/*
- 테이블정의하기
    dp[i] = i를 만드는 최소 연산 횟수
- 점화식찾기
    dp[i] = dp[i - 1] * 3 , dp[i - 1] * 2 dp[i - 1] + 1 중 최소 값
- 초기값 정하기
    dp[1] = 0
*/

/*
- X가 3으로 나누어 떨어지면, 3으로 나눈다.
- X가 2로 나누어 떨어지면, 2로 나눈다.
- 1을 뺀다.

정수가 주어졌을때 연산 최소값 구하기
 */