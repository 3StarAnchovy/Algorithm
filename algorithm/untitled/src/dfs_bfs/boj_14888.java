package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj_14888 {
    static int N;
    static int[] arr;
    static int[] sign;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Stack<Integer> sign_stack = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        sign = new int[4];
        for(int i = 0; i < 4; i ++)
            sign[i] = scanner.nextInt();

        dfs(0); //cnt
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int cnt) {
        if(cnt == N - 1) // 부호의 수
        {
            int sum = arr[0];
            for(int i = 0; i < sign_stack.size(); i ++)
            {
                int sign = sign_stack.get(i);
                if(sign == 0) // 1
                    sum += arr[i + 1];
                else if(sign == 1)
                    sum -= arr[i + 1];
                else if(sign == 2)
                    sum *= arr[i + 1];
                else
                    sum /= arr[i + 1];
            }

            max = Math.max(max,sum);
            min = Math.min(min,sum);
            return;
        }

        for(int i = 0; i < 4; i ++)
        {
            //가지치기
            if(sign[i] > 0)
            {
                sign[i] --;
                sign_stack.add(i);
                dfs(cnt + 1);
                sign_stack.pop();
                sign[i] ++;
            }
        }
    }
}
