package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15649 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static boolean[] isSelected;

    public static void recurivePermu(int cnt)
    {
        if(cnt == M) {
            for(int n : picked)
                System.out.print(n + " ");
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i ++)
        {
            if(isSelected[i])
                continue;
            picked[cnt] = arr[i];
            isSelected[i] = true;
            recurivePermu(cnt + 1);
            isSelected[i] = false;
            picked[cnt] = 0;
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        picked = new int[M];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i ++)
            arr[i] = i + 1;
        recurivePermu(0);
    }
}
