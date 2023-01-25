package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class boj_14400 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        //input
        for(int i = 0; i < n; i ++)
        {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        Arrays.sort(x);
        Arrays.sort(y);
        //중앙값 추출
        int mid_x = x[n / 2];
        int mid_y = y[n / 2];

        int sum = 0;
        for(int i = 0; i < n; i ++)
            sum += Math.abs(mid_x - x[i]) + Math.abs(mid_y - y[i]);

        System.out.println(sum);
    }
}
