package offline_coaching;

import java.util.Scanner;

public class boj_11659 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N + 1];

        //input
        for(int i = 1; i <= N; i ++)
            arr[i] = scanner.nextInt();

        //누적합 구하기
        for(int i = 1; i <= N; i ++)
            arr[i] = arr[i -1] + arr[i];

        for(int i = 0; i < M; i ++)
        {
            int from = scanner.nextInt();
            int end = scanner.nextInt();
            System.out.println(arr[end] - arr[from - 1]);
        }
    }
}
