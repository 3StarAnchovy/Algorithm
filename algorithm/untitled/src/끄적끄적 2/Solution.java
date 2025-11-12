package 끄적끄적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] map;
    static boolean[] visited;
    static int[] picked;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N];
            visited = new boolean[N];
            picked = new int[N];
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            perm(0);
            sb.append('#').append(tc).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == N) {
            int score = boom();
            max = Math.max(score, max);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[cnt] = i;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int boom() {
        boolean[] check = new boolean[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int start = picked[i];
            boolean right_flag = false, left_flag = false;
            int right = 0, left = 0;

            //왼쪽 검사
            while (start-- > 0) {
                if (!check[start]) {
                    left = map[start];
                    left_flag = true;
                    break;
                }

            }
            //오른쪽 검사
            start = picked[i];
            while (start++ < N - 1) {
                if (!check[start]) {
                    right = map[start];
                    right_flag = true;
                    break;
                }
            }

            check[picked[i]] = true;

            //점수 계산
            if (left_flag && right_flag) {
                sum += left * right;
            } else if (left_flag || right_flag) {
                int temp = left_flag ? left : right;
                sum += temp;
            } else
                sum += map[picked[i]];
        }
        return sum;
    }
}
