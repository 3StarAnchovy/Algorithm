package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579_계단오르기 {
    static int[] step;
    static int[][] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        step = new int[N + 1];
        memo = new int[N + 1][3]; // j개의 계단을 연속해서 밟은 상태에서, i번째 계단까지 올랐을 때의 점수 최대값
        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1){
            System.out.println(step[1]);
            return;
        }

        memo[1][1] = step[1];
        memo[2][1] = step[2];
        memo[1][2] = 0;
        memo[2][2] = step[1] + step[2];

        for (int i = 2; i <= N; i++) {
            memo[i][1] = Math.max(memo[i - 2][2], memo[i - 2][1]) + step[i];
            memo[i][2] = memo[i - 1][1] + step[i];
        }

        System.out.println(Math.max(memo[N][1], memo[N][2]));
    }
}

/*
테이블 정의하기
memo[i][j] j개의 계단을 연속해서 밟았을때, i번째 계단까지 올라간 점수의 최대값
memo[5][2] 2개의 계단을 연속해서 밟았을 때, 5번째 계단에서의 최대값

점화식 뽑기
 */
