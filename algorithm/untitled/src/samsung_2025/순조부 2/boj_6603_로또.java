package samsung_2025.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6603_로또 {
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb;
    static int K, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0)
                break;

            arr = new int[K];
            picked = new int[6];
            for(int i = 0; i < K; i ++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0,0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void dfs(int cnt, int start) {
        if(cnt == 6) {
            for(int i = 0; i < 6; i ++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < K; i ++) {
            picked[cnt] = arr[i];
            dfs(cnt + 1, i+1);
        }
    }
}
