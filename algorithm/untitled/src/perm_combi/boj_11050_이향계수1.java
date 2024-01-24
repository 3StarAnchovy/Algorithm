package perm_combi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11050_이향계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 1;
        for (int i = 0; i < M; i++) {
            result *= N - i;
        }

        for (int i = M; i > 1; i--) {
            result /= i;
        }

        System.out.println(result);
    }
}
