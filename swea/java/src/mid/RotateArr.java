package mid;

import java.util.*;

public class RotateArr {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T;

        T = scanner.nextInt();
        for(int k = 1; k <= T; k ++)
        {
            int N;

            N = scanner.nextInt();

            int[][] arr = new int[N][N];
            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];

            //arr input, rotate
            for(int i = 0; i < N; i ++)
                for(int j = 0; j < N; j ++) {
                    arr[i][j] = scanner.nextInt();
                    arr90[j][N - i - 1] = arr[i][j];
                    arr180[N - i - 1][N - j - 1] = arr[i][j];
                    arr270[N - j - 1][i] = arr[i][j];
                }

            //result
            System.out.println("#" + k);
            for(int i = 0; i < N; i ++)
            {
                for (int j = 0; j < N; j ++)
                    System.out.print(arr90[i][j]);
                System.out.print(" ");
                for (int j = 0; j < N; j ++)
                    System.out.print(arr180[i][j]);
                System.out.print(" ");
                for (int j = 0; j < N; j ++)
                    System.out.print(arr270[i][j]);

                if(k != N)
                    System.out.print("\n");
            }
        }
    }
}
