package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15661 {
    static int N;
    static boolean[] visited;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n = 1; n < N; n++) {
            visited = new boolean[N + 1];
            //System.out.println(n);
            dfs(1, 1, n);
            //System.out.println("================");
        }

        System.out.println(min);

    }

    private static void dfs(int cnt, int start, int n) {
        if (cnt == n + 1) {
            // for (int i = 1; i <= N; i++) {
            //     System.out.print(visited[i] ? 1 : 0);
            // }
            // System.out.println("");

            min = Math.min(min, getDiff());
            return;
        }

        for (int i = start; i <= N; i++) {
            visited[i] = true;
            dfs(cnt + 1, i + 1, n);
            visited[i] = false;
        }
    }

    private static int getDiff() {
        int start = 0;
        int link = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++)
                if (visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
        }

        return Math.abs(start - link);
    }

}
/*
총 n명 중 2팀으로 나뉜다.

투 팀의 인원수는 같지 않아도 되지만, 한명 이상이어야함 !

1부터 n까지 번호 배정



 */
