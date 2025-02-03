package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20529_세사람심리적거리 {
    static String[] arr;
    static int[] picked;
    static int N, M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            arr = new String[N];
            picked = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }

            if (N >= 33) {
                sb.append(0).append("\n");
            } else {
                dfs(0, 0);
                sb.append(min).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void dfs(int cnt, int start) {
        if (cnt == 3) {
            int sum = 0;
            sum += getDistance(arr[picked[0]], arr[picked[1]]);
            sum += getDistance(arr[picked[1]], arr[picked[2]]);
            sum += getDistance(arr[picked[0]], arr[picked[2]]);

            min = Math.min(sum, min);
            return;
        }

        for (int i = start; i < N; i++) {
            picked[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }

    private static int getDistance(String a, String b) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            char cA = a.charAt(i);
            char cB = b.charAt(i);

            if (cA != cB)
                sum++;
        }
        return sum;
    }
}

//입력

//3개 조합으로 뽑기
