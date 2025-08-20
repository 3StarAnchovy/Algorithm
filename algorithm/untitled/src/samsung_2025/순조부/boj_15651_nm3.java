package samsung_2025.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651_nm3 {
    static int N,M;
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        picked = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i ++)
                sb.append(picked[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i ++) {


                picked[cnt] = i + 1;
                dfs(cnt + 1);


        }
    }
}
