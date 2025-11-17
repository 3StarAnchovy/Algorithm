package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11404_플로이드 {
    static int[][] map;
    static int N,M;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j ++) {
                map[i][j] = INF;

                if(i == j) map[i][j] = 0;
            }
        }

        for(int i = 0; i < M; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(map[a][b] != 0)
                map[a][b] = Math.min(map[a][b],c);
            else map[a][b] = c;
        }

        //map[i][j] = i에서 j로 가는 비용
        //map[i][j] = Math.min(map[i][0 ~ N] + map[0~n][j], map[i][j])
        for(int k = 1; k <= N; k ++) {
            for(int i = 1; i <= N; i ++) {
                for(int j = 1; j <= N; j ++) {
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }

        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j ++) {
                System.out.print(map[i][j] == INF ? 0 : map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

/*
n개의 도시가 있따. 다른 도시에 도착하는 m개의 버스가 있따
 */