package 끄적끄적;

import java.util.Scanner;

public class Test {
    static int[][] map;
    static int[][] map_raw;
    static int D, W, K;
    static int result;

    public static void main(String[] args)
    {
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
                    map[r][c] = map_raw[r][c] = scanner.nextInt();
                }
            }

            result = Integer.MAX_VALUE;
            //step 1 일단 입력받은거 패스인지 체킹
            if(checkPass(map))
                result = 0;
                //step2 순열로 완탐해보기
                //근데 이게 중간에 약 투입이 기존의 최솟값보다 많으면 가지치기
                //최소값보다 적으면 갱신 ㄱㄱ
            else
                perm(0,0); //depth, 약 투입 횟수


        }
    }

    private static void perm(int layer, int cnt) {
        if(layer == D)
        {
            return;
        }

        //약 투입 안한 경우
        perm(layer + 1, cnt);

        //약 a 투입 경우
        for(int c = 0; c < W; c ++)
            map[layer][c] = 0;
        perm(layer + 1, cnt + 1);

        //약 b 투입 경우
        for(int c = 0; c < W; c ++)
            map[layer][c] = 0;
        perm(layer + 1, cnt + 1);

        //다음 재귀를 위한 restore
        for(int c = 0; c < W; c ++)
            map[layer][c] = map_raw[layer][c];
    }

    private static boolean checkPass(int[][] map)
    {
        for(int c = 0; c < W; c ++)
        {
            int cnt = 1;
            boolean flag = false;
            int type = map[0][c];
            for(int r = 1; r < D; r ++)
            {
                if(type == map[r][c])
                    cnt ++;
                else
                {
                    type = map[r][c];
                    cnt ++;
                }

                //해당 행이 k를 만족하면 일단 계속 ㄱㄱ
                if(cnt == K)
                {
                    flag = true;
                    break;
                }
            }
            //한 행이라도 k보다 작다면 빠꾸
            if(!flag)
                return false;
        }
        return true;
    }
}
