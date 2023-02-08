package dfs_bfs;

import java.util.Scanner;

public class boj_15652 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static int[] isSelected;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        //isBig = new int[N];
        picked = new int[M];
        for(int i = 0; i < N; i ++)
            arr[i] = i + 1;

        recursivePer(0,0);
    }

    private static void recursivePer(int cnt, int check) {
        if(cnt == M)
        {
            for(int n : picked)
                System.out.print(n + " ");
            System.out.println();
            return;
        }
        for(int i = check; i < N; i ++)
        {
            //지난거보다 작은거는 continue
            picked[cnt] = arr[i];
            recursivePer(cnt + 1, i);
        }
    }
}
