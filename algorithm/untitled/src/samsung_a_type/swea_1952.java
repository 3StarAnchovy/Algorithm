package samsung_a_type;

import java.util.Scanner;

public class swea_1952 {
    static int[] month = new int[12];
    static int[] prices = new int[4];
    static int min;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for(int tc = 1; tc <= TC; tc++)
        {
            for(int i = 0; i < 4; i ++)
                prices[i] = scanner.nextInt();


            for(int i = 0; i < 12; i ++)
                month[i] = scanner.nextInt();

            min = prices[3];
            dfs(0,0); // cnt;

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void dfs(int cnt ,int sum) {
        if(cnt >= 12)
        {
            min = Math.min(min, sum);
            return;
        }

        if(month[cnt] > 0)
        {
            // 1일
            dfs(cnt + 1, sum +(prices[0] * month[cnt]));
            // 1달
            dfs(cnt + 1, sum + prices[1]);
            // 3달
            dfs(cnt + 3, sum + prices[2]);
        }

        else {
            dfs(cnt + 1, sum);
        }

    }
}
