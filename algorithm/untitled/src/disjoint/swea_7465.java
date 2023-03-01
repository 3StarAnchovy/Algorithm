package disjoint;

import java.util.Scanner;

/*
접근 1
서로소를 활용하여 문제를 풀려함
findSet과 unionSet을 구현

관계 cnt 도출
- union 될때마다 N에서 --;
- 모든 입력 다 받고 union 후 arr 완탐
 */

public class swea_7465 {
    static int N; //정점 수
    static int M; //간선 수
    static int[] arr;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for(int t = 1; t <= TC; t ++)
        {
            N = scanner.nextInt();
            M = scanner.nextInt();

            arr = new int[N + 1];
            makeSet();
            int cnt = N;
            for(int i = 0; i < M; i ++)
            {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(union(a,b))
                    cnt --;
            }
            System.out.println("#" + t + " " + cnt);
        }
    }

    private static boolean union(int a, int b)
    {
        int rootA = findSet(a);
        int rootB = findSet(b);

        if(rootA == rootB)
            return false;
        arr[rootB] = rootA;
        return true;
    }
    private static int findSet(int a)
    {
        if(arr[a] == a)
            return a;
        return arr[a] = findSet(arr[a]);
    }
    private static void makeSet() {
        for(int i = 1; i < N + 1; i ++)
            arr[i] = i;
    }
}
