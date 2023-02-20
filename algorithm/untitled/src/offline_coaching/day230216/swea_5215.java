package offline_coaching.day230216;

import java.util.Scanner;

public class swea_5215 {
    static int TC;
    static int inputNum;
    static int inputLimit;
    static int[] arr;
    static int[] cal_arr;
    static boolean[] isSelected;
    static int max = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        TC = scanner.nextInt();
        for(int t = 1; t <= TC; t ++)
        {
            inputNum = scanner.nextInt();
            inputLimit = scanner.nextInt();

            arr = new int[inputNum];
            cal_arr = new int[inputNum];
            isSelected = new boolean[inputNum];
            for(int i = 0; i < inputNum; i ++)
            {
                arr[i] = scanner.nextInt();
                cal_arr[i] = scanner.nextInt();
            }

            max = 0;
            getPowerSet(0);
            System.out.println("#" + t + " " + max);
        }
    }

    private static void getPowerSet(int cnt) {
        if(cnt == inputNum)
        {
            int flavor_score = 0;
            int cal_score = 0;
            for(int i = 0; i < inputNum; i ++)
            {
                if(isSelected[i]) {
                    flavor_score += arr[i];
                    cal_score += cal_arr[i];
                }
            }

            if(cal_score <= inputLimit)
            {
                if(max < flavor_score)
                    max = flavor_score;
            }
            return ;
        }

        isSelected[cnt] = true;
        getPowerSet(cnt + 1);
        isSelected[cnt] = false;
        getPowerSet(cnt + 1);


    }
}
