package perm_combi;

import java.util.Scanner;

public class boj_15651 {
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

        picked = new int[M];
        arr = new int[N];
        for(int i = 0; i < N; i ++)
        {
            arr[i] = i + 1;
        }

        perm(0); //cnt
        System.out.print(sb);
    }

    private static void perm(int cnt) {
        if(cnt == M)
        {

            for(int i = 0; i < M; i ++)
            {
                sb.append(picked[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            picked[cnt] = arr[i];
            perm(cnt + 1);
        }
    }
}
