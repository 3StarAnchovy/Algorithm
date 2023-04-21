package perm_combi;

import java.util.Scanner;

public class boj_14889_스타트와_링크 {
    static int N; // 인원
    static int[] arr; // N만큼의 인원
    static int[] picked; // 조합 픽
    static int[][] map; // 입력 받는 배열
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N + 1];
        picked = new int[N / 2];
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = i;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        combi(0, 1); //cnt, start;
        System.out.println(min);
    }

    private static void combi(int cnt, int start) {
        if (cnt == N / 2) {
            int start_sum = 0;
            int link_sum = 0;
            // visited가 참인것 스타트
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[i] && visited[j])
                        start_sum += map[i][j];
                    else if (!visited[i] && !visited[j])
                        link_sum += map[i][j];
                }
            }

            min = Math.min(min, Math.abs(start_sum - link_sum));
            return;
        }

        for (int i = start; i <= N; i++) {
            visited[i] = true;
            combi(cnt + 1, i + 1);
            visited[i] = false; // restore
        }
    }
}
