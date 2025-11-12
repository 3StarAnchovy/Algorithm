package samsung_2025.순조부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열 {
    static int N,S;
    static int arr[];
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        //부분집합
        dfs(0,0);
        if(S == 0 && result != 0)
            result --;
        System.out.println(result);
    }

    private static void dfs(int cnt, int sum) {
        if(cnt == N) {
            if(sum == S) result ++;
            return;
        }

        //픽할때
        dfs(cnt + 1, sum + arr[cnt]);

        //픽하지 않을 때
        dfs(cnt + 1, sum);

    }
}
