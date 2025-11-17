package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11780_플로이드2 {
    static final int INF = 987654321;
    static int[][] arr;

    static int[][] nxt;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        nxt = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;

                if (i == j)
                    arr[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(c, arr[a][b]);
            nxt[a][b] = b;
        }

        // arr[a][b] : a에서 b로 가는 최소 비용
        // nxt[a][b] : a에서 b로 가는 최소 정점 (한단계만)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(arr[i][j] == INF ? 0 : arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j || arr[i][j] == INF) {
                    sb.append(0).append("\n");
                } else {
                    int cnt = 0;
                    StringBuilder temp = new StringBuilder();
                    int st = i;
                    while (st != j) {
                        temp.append(st).append(" ");
                        st = nxt[st][j];
                        cnt++;
                    }
                    cnt ++;
                    temp.append(j);
                    sb.append(cnt).append(" ").append(temp);
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
