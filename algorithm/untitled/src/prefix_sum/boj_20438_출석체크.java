package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3번부터 n+2까지의 입장 번호
출석코드 보내면 배수에게 출석 코드 ㄱㄱ
k명의 졸고있는 친구들은 출석코드 제출 안함
 */

public class boj_20438_출석체크 {
    private static int N, K, Q, M;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 3];

        // -1 졸고있는 얘, 0 미출석, 1 출석
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[input] = -1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (arr[input] == -1)
                continue;
            for (int j = input; j <= N + 2; j += input) {
                if (arr[j] != -1)
                    arr[j] = 1;
            }

        }

        //메모이제이션
        dp = new int[N + 3];
        dp[3] = (arr[3] != 1 ? 1 : 0);
        for (int i = 4; i <= N + 2; i++) {
            dp[i] = dp[i - 1] + (arr[i] != 1 ? 1 : 0);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[end] - dp[start - 1]).append('\n');
        }

        System.out.print(sb);

        // int sum = 0;
        // for (int i = start; i <= end; i++) {
        //     sum += (arr[i] != 1 ? 1 : 0);
        // }
        // System.out.println(sum + "sum");
    }
}
