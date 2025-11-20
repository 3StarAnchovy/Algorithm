package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14938_서강그라운드 {
    static int N, M, R;
    static int[][] arr;
    static int[] reward;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        reward = new int[N + 1];

        //init
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;

                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            reward[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            arr[start][end] = Math.min(r, arr[start][end]);
            arr[end][start] = Math.min(r, arr[end][start]);
        }

        //arr[i][j] = i에서 j로 가는 최소값
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] != INF && arr[i][j] <= M) {
                    temp += reward[j];
                }
            }
            max = Math.max(temp, max);
        }

        System.out.println(max);

    }
}

/*
예은이가 얻을수있는 아이템 최대 개수
수색 범위 내 모든 아이템 습득 가능함
 */