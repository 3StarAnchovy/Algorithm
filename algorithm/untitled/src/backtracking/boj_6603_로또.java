package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_로또 {
    static int[] picked;
    static int[] arr;
    static int K;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0)
                break;

            arr = new int[K];
            picked = new int[6];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            getCombi(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void getCombi(int start, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append('\n');

            return;
        }

        for (int i = start; i < K; i++) {
            picked[cnt] = arr[i];
            getCombi(i + 1, cnt + 1);
        }
    }
}
