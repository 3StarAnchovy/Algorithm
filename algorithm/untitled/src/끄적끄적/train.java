package 끄적끄적;

import java.util.Arrays;
import java.util.Scanner;

public class train {

    static int[] arr;
    static int N, R;
    static boolean[] isSelected;
    static int[] picked;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();

        arr = new int [N];

        for(int i = 0; i < N; i ++)
            arr[i] = i + 1;

        picked = new int[R];
        isSelected = new boolean[N];

        perm(0); // cnt
        System.out.println("---");
        combi(0,0); // cnt, start
        powerset(0);
    }

    private static void powerset(int cnt) {
        if(cnt == N)
        {
            for(int i = 0; i < N; i ++)
                System.out.print(isSelected[i] ? arr[i] + " " : "");
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        powerset(cnt + 1);
        isSelected[cnt] = false;
        powerset(cnt + 1);
    }

    private static void combi(int cnt, int start) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = start; i < N; i ++)
        {
            picked[cnt] = arr[i];
            combi(cnt + 1, i + 1);
        }

    }

    private static void perm(int cnt) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            if(!isSelected[i])
            {
                isSelected[i] = true;
                picked[cnt] = arr[i];
                perm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}
