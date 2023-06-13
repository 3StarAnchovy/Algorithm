package samsung_a_type;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_지하철노선_홍지민 {
    static int N;
    static int[] map;
    static boolean[] visited;
    static int[] picked;
    static int max;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            map = new int[N];
            visited = new boolean[N];
            picked = new int[4]; //first 0,1 second 2,3

            max = 0;
            //step1 : 입력받기
            for (int i = 0; i < N; i++)
                map[i] = scanner.nextInt();

            int max_val = 0;
            for(int a = 0; a < N - 6; a ++)
            {
                for(int b = a + 2; b < N - 4; b ++)
                {
                    for(int c = b + 2; c < N - 2; c ++)
                    {
                        for(int d = c + 2; d < N; d ++)
                        {
                            if(d + 1 - N == a)
                                continue;
                            int temp = gob(a,b) + gob(c,d);
                            max_val = Math.max(temp,max_val);
                            temp = gob(a,d) + gob(b,c);
                            max_val = Math.max(temp,max_val);
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + max_val);
        }
    }

    private static int gob(int a, int b)
    {
        return (map[a] + map[b]) * (map[a] + map[b]);
    }

}
