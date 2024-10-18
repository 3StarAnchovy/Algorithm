package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {
    static int[] arr;
    static boolean[] picked;
    static int S, N;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boo(0);
        if(S == 0) {
            System.out.println(result - 1);
            return;
        }
        System.out.println(result);
    }

    private static void boo(int cnt) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (picked[i]) {
                    sum += arr[i];
                }
            }

            if(sum == S) {
                result ++;
            }
            return;
        }

        picked[cnt] = true;
        boo(cnt + 1);

        picked[cnt] = false;
        boo(cnt + 1);
    }
}

/*
N개의 정수로 이루어진 수열이 있을 때,
부분수열중에서 그 수열의 원소를 다 더한 값이 S가 더하는 경우
 */