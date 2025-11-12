package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2529_부등호 {
    static int K;
    static char[] arr;
    static boolean[] visited;
    static int[] picked;
    static String minAns, maxAns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        arr = new char[K + 1];
        visited = new boolean[10];
        picked = new int[K + 1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i ++) {
            arr[i] = st.nextToken().charAt(0);
        }
        arr[K] = '=';

        dfs(0, 0, 10);

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    private static String getNumber() {
        StringBuilder sb = new StringBuilder();
        for(int num : picked) sb.append(num);
        return sb.toString();
    }

    private static void dfs(int depth, int start, int end) {
        if(depth == K + 1) {
            String result = getNumber();

            if (minAns == null || result.compareTo(minAns) < 0) minAns = result;
            if (maxAns == null || result.compareTo(maxAns) > 0) maxAns = result;

            return;
        }

        for(int i = start; i < end; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                picked[depth] = i;

                if(arr[depth] == '<') {
                    dfs(depth + 1, i + 1, 10);
                } else if (arr[depth] == '>'){
                    dfs(depth + 1, 0, i);
                } else {
                    dfs(depth + 1, 0, 0);
                 }
                visited[i] = false;
            }
        }

    }
}
