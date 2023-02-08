package offline_coaching;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    static int N;
    static int R;
    static int[] arr;
    static int[] picked;
    static boolean[] isSelected;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        R = scanner.nextInt();
        arr = new int[N];
        picked = new int[R];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i ++)
            arr[i] = i + 1;

        recursivePercum(0);
    }

    private static void recursivePercum(int cnt)
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
            recursivePercum(cnt + 1);
            isSelected[cnt] = false;
        }
    }
}
