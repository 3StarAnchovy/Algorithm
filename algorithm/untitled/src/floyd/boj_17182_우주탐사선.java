package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17182_우주탐사선 {
    static int[][] map;
    static int[] picked;
    static boolean[] visited;
    static int N, K;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        visited = new boolean[N];
        picked = new int[N];
        picked[0] = K;
        visited[K] = true;

        //print();
        min = Integer.MAX_VALUE;
        dfs(1);
        System.out.println(min);
    }

    private static void dfs(int r) {
        if (r == N ) {
            int temp = 0;
            for(int i = 0; i < N - 1; i ++) {
                temp += map[picked[i]][picked[i + 1]];
            }
            min = Math.min(temp,min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[r] = i;
                dfs(r + 1);
                visited[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println("출력");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
모든 행성을 탐사하는데 걸리는 최소시간 계산
이미 방문한 행성도 중복 해서 갈 수 있다.


 */