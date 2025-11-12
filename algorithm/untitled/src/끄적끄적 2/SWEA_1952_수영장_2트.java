package 끄적끄적;

import java.util.Scanner;

public class SWEA_1952_수영장_2트 {
    static int[] price;
    static int[] month;
    static int min;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            min = Integer.MAX_VALUE;
            price = new int[4];
            month = new int[12];

            for (int i = 0; i < 4; i++)
                price[i] = scanner.nextInt();

            for (int i = 0; i < 12; i++)
                month[i] = scanner.nextInt();

            dfs(0, 0); //cnt, sum
            System.out.println("#" + tc + " " + min);
        }
    }

    private static void dfs(int cnt, int sum) {
        if (cnt >= 12) {
            min = Math.min(min, sum);
            return;
        }

        if (month[cnt] > 0) {
            //1일
            dfs(cnt + 1, sum + month[cnt] * price[0]);
            //한달
            dfs(cnt + 1, sum + price[1]);
            //3달
            dfs(cnt + 3, sum + price[2]);
            //1년
            dfs(cnt + 12, sum + price[3]);
        } else {
           dfs(cnt + 1, sum);
        }
    }
}
