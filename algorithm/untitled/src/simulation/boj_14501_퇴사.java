package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {
    static int N;
    static int[] time;
    static int[] price;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        time = new int[N];
        price = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        //dfs

        System.out.println(max);
    }

    private static void dfs(int result, int start) {
        max = Math.max(result, max);
        for (int i = start; i < N; i++) {
            if (i + time[i] <= N) {
                dfs(result + price[i], start + time[i]);
            }
        }
    }
}

/*
오늘부터 N + 1일 째 되는날 퇴사 위해
남은 N일 동안 최대한 많은 상담을 하려함
비서는 하루에 하나씩 서러 다른 사람의 상담을 잡아놓음
상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.
dfs();
 */