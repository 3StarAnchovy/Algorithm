package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15657 {
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

        combi(0,0); //cnt, start
        System.out.print(sb);
    }

    private static void combi(int cnt, int start) {
        if(cnt == M)
        {
            for(int i = 0; i < M; i ++)
                sb.append(picked[i]).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = start; i < N; i ++)
        {
            picked[cnt] = arr[i];
            combi(cnt + 1, i);
        }
    }
}
