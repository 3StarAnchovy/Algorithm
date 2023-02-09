package offline_coaching.day230209;

import java.util.Arrays;
import java.util.Scanner;

public class Training {
    static int N;
    static int R;
    static boolean[] isSelected;
    static int[] picked;

    static int[] arr;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        R = scanner.nextInt();

        arr = new int[N];
        picked = new int[R];
        isSelected = new boolean[N];
        for(int i = 0; i < N; i++)
            arr[i] = i + 1;

        Perm(0);
        //Combi(0,0);
    }

    private static void Combi(int cnt, int start) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = start; i < N; i ++)
        {
            picked[cnt] = arr[i];
            Combi(cnt + 1, i + 1);
        }
    }

    public static void Perm(int cnt)
    {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            if(isSelected[i])
                continue;
            picked[cnt] = arr[i];
            isSelected[i] = true;
            Perm(cnt + 1);
            isSelected[i] = false;
        }
    }
}
