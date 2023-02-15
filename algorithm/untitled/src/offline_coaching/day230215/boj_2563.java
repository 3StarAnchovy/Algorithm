package offline_coaching.day230215;

import java.util.Scanner;

public class boj_2563 {
    static int N;
    static int[][] map = new int [100][100];
    /* 접근
        모든 색종이의 넓이를 더한다.

        겹치는 부분 넓이를 뺀다.
            x y 좌표가 다른 색종이들 x < a < x + 10 && y < a < y + 10이 에 만족한다면 겹치는 거임

     */

    /* 접근
    '   배열[10][10]
        3 7
        3
     */

    /*

     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        int cnt = 0;

        for(int i = 0; i < N; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for(int j = x; j < x + 10; j ++)
            {
                for(int k = y; k < y + 10; k ++)
                {
                    map[j][k] = 1;
                }
            }
        }

        for(int j = 0; j < 100; j ++)
        {
            for(int k = 0; k < 100; k ++)
            {
                if (map[j][k] == 1)
                    cnt ++;
            }
        }

        System.out.println(cnt);
    }
}
