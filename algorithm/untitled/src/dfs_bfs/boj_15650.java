package dfs_bfs;

import java.util.Scanner;

public class boj_15650 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static boolean[] selected;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int [N];
        for(int i = 0; i < N; i ++)
            arr[i] = i + 1;

        picked = new int[M];
        recursiveCombin(0,0);
    }

    private static void recursiveCombin(int cnt, int start)
    {
        if(cnt == M)
        {
            for(int n : picked)
                System.out.print(n + " ");
            System.out.println();
            return ;
        }
        for(int i = start; i < N; i ++)
        {
            picked[cnt] = arr[i];
            recursiveCombin(cnt + 1, i + 1);
        }
    }
}
