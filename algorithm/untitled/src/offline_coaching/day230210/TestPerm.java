package offline_coaching.day230210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class TestPerm {
    static int N;
    static int R;

    static int[] arr;
    static boolean[] isSelected;
    static int[] picked;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N =scanner.nextInt();
        R = scanner.nextInt();

        arr = new int[N];
        picked = new int[R];
        isSelected = new boolean[N];

        for(int i = 0 ; i < N; i ++)
            arr[i] = i + 1;
        //N개 중 R개 뽑아 나열하는 모든 경우의 수 - 순열
        //getPerm(0);
        //N개 중 r개 뽑는 모든 경우의수 - 조합
        //getCombi(0,0);
        //N개의 만들수 있는 모든 부분집합 출력
        getPowerSett(0);
    }

    private static void getPowerSett(int cnt) {
        if(cnt == N)
        {
            for(int i = 0; i < N; i ++)
            {
                System.out.print(isSelected[i] ? arr[i] : " ");
            }
            System.out.println();
            return ;
        }
        isSelected[cnt] = true;
        getPowerSett(cnt + 1);

        isSelected[cnt] = false;
        getPowerSett(cnt + 1);

    }

    private static void getCombi(int cnt, int start) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return ;
        }
        for(int i = start; i < N; i ++)
        {
            picked[cnt] = arr[i];
            isSelected[i] = true;
            getCombi(cnt + 1, i + 1);
        }
    }

    private static void getPerm(int cnt) {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return ;
        }
        for(int i = 0; i < N; i ++)
        {
            if(isSelected[i])
                continue;
            picked[cnt] = arr[i];
            isSelected[i] = true;
            getPerm(cnt + 1);
            isSelected[i] = false;
        }
    }
}
