package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15656 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        picked = new int[M];

        for(int i = 0; i < N; i ++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);
        perm_no_visit(0); //cnt
        System.out.print(sb);
    }

    private static void perm_no_visit(int cnt) {
        if(cnt == M)
        {
            for(int i = 0; i < M; i ++)
                sb.append(picked[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            picked[cnt] = arr[i];
            perm_no_visit(cnt + 1);
        }
    }
}
