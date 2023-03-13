package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_15665 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        /*
        접근
        순열? 조합? 순열인데, 입력된 배열에 중복이 없는 순열
         */
        arr = new int[N];
        visited = new boolean[N];
        picked = new int[M];
        for(int i = 0; i < N; i ++)
            arr[i] = scanner.nextInt();

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

        int past = -1;
        for(int i = 0; i < N; i ++)
        {
            if(past != arr[i])
            {
                picked[cnt] = arr[i];
                past = arr[i];
                perm(cnt + 1);
            }
        }
    }
}
