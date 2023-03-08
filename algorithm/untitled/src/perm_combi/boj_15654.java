package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15654 {
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        picked = new int[M];
        visited = new boolean[N];
        for(int i = 0; i < N; i ++)
        {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        perm(0); // cnt, start
        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if(cnt == M)
        {
            for(int i = 0; i < cnt; i ++)
                sb.append(picked[i]).append(" ");
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            if(!visited[i]) {
                visited[i] = true;
                picked[cnt] = arr[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
