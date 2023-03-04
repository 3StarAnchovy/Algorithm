package samsung_a_type;

/*
접근 1.
순열로 색깔 바꿀거 픽

 */

import java.util.Scanner;

public class swea_2112 {
    static int[][] map;
    static int[][] map_raw;
    static int D, W, K;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            D = scanner.nextInt(); // 두께
            W = scanner.nextInt(); // 가로
            K = scanner.nextInt(); // 합격기준

            map = new int[D][W];
            map_raw = new int[D][W];
            for (int r = 0; r < D; r++) {
                for (int c = 0; c < W; c++) {
                    map[r][c]= map_raw[r][c] = scanner.nextInt();

                }
            }

            result = Integer.MAX_VALUE;
            //step 1. 입력받은거 먼저 체크
            if (checkPass(map))
                result = 0;
            //step 2. 패스 안뜨면 약 주입, 순열로 상태도 완탐
            else
                perm(0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void perm(int cnt, int layer) {
        if (cnt >= result)
            return;
        if (layer == D) {
            if (checkPass(map))
                if (cnt < result)
                    result = cnt;
            return;
        }

        //약품 주입안함
        perm(cnt, layer + 1);

        //A 주입
        for (int c = 0; c < W; c++)
            map[layer][c] = 0;
        perm(cnt + 1, layer + 1);

        //B 주입
        for (int c = 0; c < W; c++)
            map[layer][c] = 1;
        perm(cnt + 1, layer + 1);

        //어.. 배열 되돌려야되는데 싯팔
        for (int c = 0; c < W; c++)
            map[layer][c] = map_raw[layer][c];
    }


    /*
    필름이 패스인지 체킹
    패스면 true
    아니면 false
     */
    private static boolean checkPass(int[][] map) {
        for (int c = 0; c < W; c++) {
            int type = map[0][c];
            int cnt = 1;
            boolean flag = false;
            for (int r = 1; r < D; r++) {
                if (type == map[r][c])
                    cnt++;
                else {
                    type = map[r][c];
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
