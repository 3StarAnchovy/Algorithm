package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class boj_6603 {
    static int N; //픽 해야되는 개수
    static int[] input;
    static int[] picked;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        while (N != 0) {
            input = new int[N];
            picked = new int[6];
            //init
            for (int i = 0; i < N; i++)
                input[i] = scanner.nextInt();

            getCombi(0, 0); //cnt, start
            System.out.println();
            N = scanner.nextInt();
        }

    }

    private static void getCombi(int cnt, int start) {
        //cnt가 N이면 종료
        if (cnt == 6) {
            for(int i = 0; i < picked.length; i ++)
                System.out.print(picked[i] + " ");
            System.out.println();

            return;
        }

        //for문 돌려 start부터 M까지
        for (int i = start; i < N; i++) {
            picked[cnt] = input[i];
            getCombi(cnt + 1, i + 1);
        }
    }

}
