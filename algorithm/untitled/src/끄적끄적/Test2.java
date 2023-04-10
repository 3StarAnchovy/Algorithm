package 끄적끄적;

/*
dfs
search()
    네번 꺾으면 return
모든 디저트카페에 대해서 serach() 수행

방향 고정
 */

import java.util.Scanner;

public class Test2 {
    static int D; // 두께
    static int W; // 보호필름 가로크기
    static int K; // 합격기준
    static int[][] map;
    static int min = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            D = scanner.nextInt();
            W = scanner.nextInt();
            K = scanner.nextInt();

            map = new int[D][W];
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            min = Integer.MAX_VALUE;
            if (check()) {
                min = 0;
            } else {
                injection(0, 0); //약품주입횟수 Cnt, layer;
            }

            System.out.println("#" + tc + " " + min);

        }
    }

    private static void injection(int cnt, int layer) {
        if (cnt >= min) {
            return;
        }

        if (layer == D) {
            if (check())
                min = Math.min(cnt, layer);
            return;
        }

        //약품 주입 안함
        injection(cnt, layer + 1);

        int[] copy = copyArray(map[layer]);
        //a 약품 주입함
        for (int i = 0; i < W; i++)
            map[layer][i] = 0;
        injection(cnt + 1, layer + 1);

        //b 약품 주입함
        for (int i = 0; i < W; i++)
            map[layer][i] = 1;
        injection(cnt + 1, layer + 1);

        //restore
        for (int i = 0; i < W; i++)
            map[layer][i] = copy[i];
    }

    private static int[] copyArray(int[] map) {
        int[] copy = new int[W];

        for (int i = 0; i < W; i++) {
            copy[i] = map[i];
        }

        return copy;
    }

    private static boolean check() {
        for (int i = 0; i < W; i++) {
            boolean flag = false;
            int cnt = 1;
            int temp = map[0][i];
            for (int j = 1; j < D; j++) {
                if (temp == map[j][i]) {
                    cnt++;
                } else {
                    temp = map[j][i];
                    cnt = 1;
                }
                if (cnt == K) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;
        }
        return true;
    }
}
