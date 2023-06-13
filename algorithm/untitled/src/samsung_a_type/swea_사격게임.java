package samsung_a_type;

import java.util.Arrays;
import java.util.Scanner;

public class swea_사격게임 {
    static int N;
    static int[] map;
    static int[] picked;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for(int tc = 1; tc <= TC; tc ++)
        {
            N = scanner.nextInt();
            map = new int[N];
            picked = new int[N];
            visited = new boolean[N];
            max = 0;
            for(int i = 0; i < N; i ++)
            {
                map[i] = scanner.nextInt();
            }

            perm(0);
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void perm(int cnt) {
        if(cnt == N)
        {
            max = Math.max(max,boom());
            return ;
        }

        for(int i = 0; i < N; i ++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                picked[cnt] = i; // 인덱스 담음 ㅇㅇ
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int boom() {
        boolean[] check = new boolean[N];
        int sum = 0;
        for(int i = 0; i < N; i ++)
        {
            boolean right_flag = false;
            boolean left_falg = false;
            int right = 0, left = 0;
            int start = picked[i];
            //왼쪽 쭉 검사
            while(start -- > 0)
            {
                if(!check[start])
                {
                    left_falg = true;
                    left = map[start];
                    break;
                }
            }
            start = picked[i];
            //오른쪽 쭉 검사
            while(start ++ < N - 1)
            {
                if(!check[start])
                {
                    right_flag = true;
                    right = map[start];
                    break;
                }
            }

            //양쪽 다 있을 때
            if(left_falg && right_flag)
            {
                sum += left * right;
            } else if (left_falg || right_flag) {
                int temp = left_falg ? left : right;
                sum += temp;
            }
            else {
                sum += map[picked[i]];
            }

            check[picked[i]] = true;
        }

        return sum;
    }
}
