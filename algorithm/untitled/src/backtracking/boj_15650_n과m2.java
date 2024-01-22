package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650_n과m2 {
    static int N, R;
    static int[] picked;
    static int[] arr;
    static boolean[] isSelected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        picked = new int[R];
        arr = new int[N];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++)
            arr[i] = i + 1;

        getCombi(0, 0);
        System.out.print(sb);
    }

    private static void getCombi(int cnt, int start) {
        if (cnt == R) {
            for (int i = 0; i < R; i++)
                sb.append(picked[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            picked[cnt] = arr[i];
            isSelected[i] = true;
            getCombi(cnt + 1, i + 1);
        }
    }
}
