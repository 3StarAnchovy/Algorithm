package mid;

import java.util.*;

public class TwonNumber {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T;

        T = scanner.nextInt();

        for(int k = 1; k <= T; k ++)
        {
            int N,M;
            N = scanner.nextInt();
            M = scanner.nextInt();

            int[] arrA = new int[N];
            int[] arrB = new int[M];

            //input
            for(int i = 0; i < N; i ++)
                arrA[i] = scanner.nextInt();
            for(int i = 0; i <M; i ++)
                arrB[i] = scanner.nextInt();

            if(N > M)
            {
                int max = 0;
                for(int i = 0; i < N - M + 1; i ++)
                {
                    int sum = 0;
                    for(int j = 0; j < M; j ++)
                        sum += arrA[j + i] * arrB[j];
                    if(max < sum)
                        max = sum;
                }
                System.out.println("#" + k + " " + max);
            }
            else
            {
                int max = 0;
                for(int i = 0; i < M - N + 1; i ++)
                {
                    int sum = 0;
                    for(int j = 0; j < N; j ++)
                        sum += arrA[j] * arrB[j + i];
                    if(max < sum)
                        max = sum;
                }
                System.out.println("#" + k + " " + max);
            }

        }
    }
}
