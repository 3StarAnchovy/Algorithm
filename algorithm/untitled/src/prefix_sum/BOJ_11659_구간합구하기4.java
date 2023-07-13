package prefix_sum;

import java.util.Scanner;

public class BOJ_11659_구간합구하기4 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // step 1 : 입력받기
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N + 1];
        int[] prefix_sum = new int[N + 2];
        for(int i = 1; i < N + 1; i ++)
            arr[i] = scanner.nextInt();

        // step 2 : 구간합 구하기
        for(int i = 1; i < N + 1; i ++)
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];

        for(int i = 0; i < M; i ++)
        {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            int result = prefix_sum[end] - prefix_sum[start - 1];
            System.out.println(result);
        }
    }
}
