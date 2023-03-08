package perm_combi;

import java.util.Arrays;
import java.util.Scanner;

public class boj_17281 {
    static int inning;
    static int[][] mans;
    static int[] picked;
    static boolean[] visited;
    static int[] man_num;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inning = scanner.nextInt();

        mans = new int[inning][10]; // 0은 버림
        for (int i = 0; i < inning; i++) {
            for (int j = 1; j < 10; j++) {
                mans[i][j] = scanner.nextInt();
            }
        }

        man_num = new int[10];
        for (int i = 1; i < 10; i++) {
            man_num[i] = i;
        }

        picked = new int[10];
        visited = new boolean[10];

        picked[1] = 4;
        visited[4] = true;
        //step1. 타수 순서 정하기
        //step2. 베이스볼 구현.
        perm(2); // cnt //하나 집고 시작했으니까 1부터 ㄱ
        System.out.println(result);

    }

    private static void perm(int cnt) {
        if (cnt == 10) {
            result = Math.max(playBaseBall(), result);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picked[cnt] = man_num[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int playBaseBall() {
        int score = 0;
        for (int i = 0; i < inning; i++) {
            int out_cnt = 0;
            int idx = 1;
            boolean[] base = new boolean[4];

            while (out_cnt < 3) {
                int temp = mans[i][picked[idx % 9]];
                switch (temp) {
                    case 0:
                        out_cnt++;
                        break;
                    case 1: // 안타의 경우
                        for (int d = 3; d >= 1; d--) {
                            if (base[d]) // 사람이 있으면
                            {
                                if (d == 3) {
                                    score++;
                                    base[d] = false;
                                } else {
                                    base[d] = false;
                                    base[d + 1] = true;
                                }
                            }
                            base[1] = true;
                        }
                        break;
                    case 2: // 이루타
                        for (int d = 3; d >= 1; d--) {
                            if (base[d]) // 사람이 있으면
                            {
                                if (d == 3 || d == 2) {
                                    score++;
                                    base[d] = false;
                                } else {
                                    base[d] = false;
                                    base[d + 2] = true;
                                }
                            }
                            base[2] = true;
                        }
                        break;

                    case 3: // 삼루타
                        for (int d = 3; d >= 1; d--) {
                            if (base[d]) // 사람이 있으면
                            {
                                if (d == 3 || d == 2 || d == 1) {
                                    score++;
                                    base[d] = false;
                                }
                            }
                            base[3] = true;
                        }
                        break;
                    case 4: // 홈런
                        for (int d = 3; d >= 1; d--) {
                            if (base[d]) // 사람이 있으면
                            {
                                score++;
                                base[d] = false;
                            }
                            score++;
                        }
                        break;
                }
                idx ++;
            }
        }
        return score;
    }
}
