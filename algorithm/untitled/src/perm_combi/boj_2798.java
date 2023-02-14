package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2798 {
    static int N;
    static int M; // 얘 넘기면 안됨
    static int[] arr;
    static int[] picked;
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N];
        picked = new int[3];
        for (int i = 0; i < N; i++)
            arr[i] = scanner.nextInt();

        getCombi(0, 0, 0); //cnt arr idx
        System.out.println(result);
    }

    private static void getCombi(int cnt, int start_idx, int sum)
    {
        if(cnt == 3)
        {
            if(result < sum && sum <= M) {
                System.out.println(Arrays.toString(picked));
                System.out.println("tt " + sum);
                result = sum;
            }
            return ;
        }

        for(int i = start_idx; i < N; i ++)
        {
            int temp = sum + arr[i];
            picked[cnt] = arr[i];
            getCombi(cnt + 1, i + 1, temp);
        }
    }

}
