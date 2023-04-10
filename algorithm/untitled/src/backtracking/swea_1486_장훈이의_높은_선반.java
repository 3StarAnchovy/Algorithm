package backtracking;

import java.util.Arrays;
import java.util.Scanner;

/*
문제 해석
서점에는 높이 B의 선반 하나 있음
N명의 점원들이 선반위의 올려놓은 물건을 사용해야함
점원의 키는 H 탑을 쌓아서 물건을 사용하기로 함
탑의 높이는 모든 점원의 키 합
탑의 높이가 b 이상인 경우 선반위의 물건을 사용할 수 있는데,
높이가 더 높을수록 위험하므로 높이가 b 이상인 탑중에서 높이가 가장 낮은 탑을 알아내려고함
 */

/*
부분집합, 조합으로 접근
1~5명의 키로 만들 수 있는 합 중에서 가장 높은 합 출력
 */
public class swea_1486_장훈이의_높은_선반 {
    static int N; // 점원 수
    static int B; // 탑의 높이
    static boolean[] picked;
    static int[] arr;
    static int min;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for(int tc = 1; tc <= TC; tc++)
        {
            N = scanner.nextInt();
            B = scanner.nextInt();

            arr = new int[N];
            picked = new boolean[N];

            for(int i = 0; i < N; i ++)
            {
                arr[i] = scanner.nextInt();
            }

            min = Integer.MAX_VALUE;
            subset(0); // cnt;
            System.out.println("#"+tc + " " + min);
        }
    }

    private static void subset(int cnt) {
        if(cnt == N)
        {
            //이 때 만들어진 합이 B에 가까운거 갱신
            int sum = 0;
            for(int i = 0; i < N; i ++)
            {
                if(picked[i])
                    sum += arr[i];
            }
            //System.out.println("this" + Math.abs(B - sum ));
            if(sum >= B)
                min = Math.min(min, Math.abs(B - sum));

            /*
            for(int i = 0; i < N; i ++)
            {
                System.out.print(picked[i] ? arr[i] : "F");
            }
            System.out.println();
            */

            return;
        }

        //픽 한 경우
        picked[cnt] = true;
        subset(cnt + 1);
        picked[cnt] = false;

        //픽 하지 않은 경우
        subset(cnt + 1);
    }
}
