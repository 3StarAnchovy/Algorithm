package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649_n과m1 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[M];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        getPerm(0);
        System.out.print(sb);
    }

    private static void getPerm(int cnt) {
        if (cnt == M) {
            for(int i = 0; i < M; i ++)
                sb.append(picked[i]).append(" ");

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                picked[cnt] = arr[i];
                isSelected[i] = true;
                getPerm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}
