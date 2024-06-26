package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726_2n타일링 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        arr[1] = 1;

        if (N == 1) {
            System.out.println(1);
            return;
        }
        arr[2] = 2;
        for (int i = 3; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            arr[i] %= 10007;
        }

        System.out.println(arr[N]);
    }
}
