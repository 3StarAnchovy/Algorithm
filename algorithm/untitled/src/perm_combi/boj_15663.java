package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15663 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] picked;
    static int[] arr;
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
        perm(0); //cnt
        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if(cnt == M)
        {
            for(int i = 0; i < M; i ++)
            {
                sb.append(picked[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int doulbe_check = -1;
        for(int i = 0; i < N; i ++)
        {
            if(!visited[i] && doulbe_check != arr[i])
            {
                doulbe_check = arr[i];
                visited[i] = true;
                picked[cnt] = arr[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
