package samsung_a_type;

/*
접근 1.
부호 11개 순열
11! * 50 3초 가능?
터질거같은..데..

접근 2
부호 11개 순열..백트래킹..
경우의 수를 줄여보자
부호 11개, 종류는 4개니깐 중복되는거 무조건 있음
상태도 그리다보면 부호 다 떨어져서 안되는거는 걍 제껴버리기
 */

import java.util.Scanner;
import java.util.Stack;

public class swea_4008 {
    static int N;
    static int[] arr;
    static int[] sign; // + - * /
    static Stack<Integer> sign_picked;
    static int max;
    static int min;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for(int t = 1; t <= TC; t ++)
        {
            N = scanner.nextInt();
            arr = new int [N];
            sign = new int[4];
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            //sign input
            for(int i = 0; i < 4; i ++)
                sign[i] = scanner.nextInt();
            //num input
            for(int i = 0; i < N; i ++)
                arr[i] = scanner.nextInt();
            sign_picked = new Stack<>();
            dfs(0); // cnt
            System.out.println("#" + t + " " + (max - min));
        }
    }

    private static void dfs(int cnt) {
        if(cnt == N - 1)
        {
            int sum = arr[0];
            for(int i = 0; i < N - 1; i ++)
            {
                switch (sign_picked.get(i))
                {
                    case 0: // +
                        sum += arr[i + 1];
                        break;
                    case 1: // -
                        sum -= arr[i + 1];
                        break;
                    case 2: // *
                        sum *= arr[i + 1];
                        break;
                    case 3: // /
                        sum /= arr[i + 1];
                        break;
                }
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for(int i = 0; i < 4; i ++)
        {
            if(sign[i] > 0)
            {
                sign[i] --;
                sign_picked.push(i);
                dfs(cnt + 1);
                sign_picked.pop();
                sign[i] ++;
            }
        }
    }
}
