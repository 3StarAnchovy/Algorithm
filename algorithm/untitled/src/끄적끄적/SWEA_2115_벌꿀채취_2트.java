package 끄적끄적;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_2115_벌꿀채취_2트 {
    static int N, M, C;
    static int[][] map;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] picked;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            //step1. 입력받기
            N = scanner.nextInt();
            M = scanner.nextInt();
            C = scanner.nextInt();

            map = new int[N][N];
            picked = new int[2];
            max = 0;

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    map[i][j] = scanner.nextInt();

            //step2 . 조합시행 - 일꾼 두명이 채집을 시작할 행, 열 픽하기
            combi(0, 0); // cnt, start, profit
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void combi(int cnt, int start) {
        if (cnt == 2) {
            //System.out.println(picked[0] + " " + picked[1]);
            //일꾼 A 부분집합 시행
            subsetA(0, 0, 0); //cnt , // sum
            return;
        }

        for (int i = start; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            if (c + M - 1 < N) { // 유효성 체킹
                picked[cnt] = i;
                combi(cnt + 1, i + M);
            }
        }
    }

    private static void subsetA(int cnt, int sum, int profit) {
        if (sum > C)
            return;
        if (cnt == M) {
            subsetB(0, 0, profit);
            return;
        }

        int r = (picked[0] + cnt) / N;
        int c = (picked[0] + cnt) % N;

        // 채취하는 경우
        subsetA(cnt + 1, sum + map[r][c], profit + map[r][c] * map[r][c]);

        // 채취하지 않는 경우
        subsetA(cnt + 1, sum, profit);
    }

    private static void subsetB(int cnt, int sum, int profit) {
        if (sum > C)
            return;
        if (cnt == M) {
            max = Math.max(max, profit);
            return;
        }

        int r = (picked[1] + cnt) / N;
        int c = (picked[1] + cnt) % N;

        // 채취하는 경우
        subsetB(cnt + 1, sum + map[r][c], profit + map[r][c] * map[r][c]);

        // 채취하지 않는 경우
        subsetB(cnt + 1, sum, profit);
    }
}
