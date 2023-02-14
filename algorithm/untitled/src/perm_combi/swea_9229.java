package perm_combi;

import java.util.Scanner;

public class swea_9229 {
    static int N;
    static int M;
    static int[] arr;
    static int[] picked;
    static int result = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int tc =1; tc <= T; tc ++)
        {
            N = scanner.nextInt();
            M = scanner.nextInt();

            arr = new int[N];
            picked = new int[2];
            for(int i = 0; i < N; i ++)
                arr[i] = scanner.nextInt();
            combi(0,0,0); //cnt, startIdx, sum
            if(result != 0)
                System.out.println("#" + tc + " " + result);
            else
                System.out.println("#" + tc + " " + -1);
            result = 0;
        }
    }

    private static void combi(int cnt, int startIdx, int sum) {
        if(cnt == 2)
        {
            if(result < sum && sum <= M)
                result = sum;
            return;
        }

        for(int i = startIdx; i < N; i ++)
        {
            //int temp = sum + arr[i];
           // picked[cnt] = arr[i];
            combi(cnt + 1, i + 1, sum+arr[i]);

        }
    }
}
