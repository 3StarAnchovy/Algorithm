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

        arr = new int[N];
        isSelected = new boolean[N];
        picked = new int[R];
        for(int i = 0; i < N; i ++)
            arr[i] = scanner.nextInt();

        //getPerm(0);
        //getCombi(0,0);
        getPowerSet(0);
    }

    private static void getPerm(int cnt) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            if(!isSelected[i])
            {
                picked[cnt] = arr[i];
                isSelected[i] = true;
                getPerm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }

    private static void getCombi(int cnt, int start)
    {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = start; i < N; i ++) {
            picked[cnt] = arr[i];
            getCombi(cnt + 1, i + 1);
        }
    }

    private static void getPowerSet(int cnt)
    {
        if(cnt == N)
        {
            for(int i = 0; i < N; i ++)
            {
                System.out.print(isSelected[i] ? arr[i] + " " : "");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        getPowerSet(cnt + 1);
        isSelected[cnt] = false;
        getPowerSet(cnt + 1);
    }
}
