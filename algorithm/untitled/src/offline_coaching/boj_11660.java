package offline_coaching;

import java.util.Scanner;

public class boj_11660 {
    static int[] arr;
    static int N;
    static int M;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N * N + 1];
        int[] x1 = new int[M];
        int[] x2 = new int[M];
        int[] y1 = new int[M];
        int[] y2 = new int[M];


        for(int i = 1; i < (N * N + 1); i ++)
            arr[i] = scanner.nextInt();

        for(int i = 1 ; i < (N * N + 1); i ++)
            arr[i] += arr[i -1] + arr[i];
        for(int i = 0; i < M; i ++)
        {
            x1[i] = scanner.nextInt();
            y1[i] = scanner.nextInt();
            x2[i] = scanner.nextInt();
            y2[i] = scanner.nextInt();
        }


    }
}
