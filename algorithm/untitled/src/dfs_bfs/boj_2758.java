package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2758 {
    static int N; //픽 해야되는 개수
    static int M; // 자연수 범위
    static int[] input;
    static int[] picked;
    static int result;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for(int t = 0; t < tc; t ++)
        {
            result = 0;
            N = scanner.nextInt();
            M = scanner.nextInt();

            input = new int[M + 1];
            picked = new int[N];
            //init
            for(int i = 1; i < M + 1; i ++)
                input[i] = i;

            getCombi(0,1); //cnt, start
            System.out.println(result);
        }

    }

    private static void getCombi(int cnt, int start) {
        //cnt가 N이면 종료
        if(cnt == N)
        {
            result ++;
            //System.out.println(Arrays.toString(picked));
            return;
        }

        //for문 돌려 start부터 M까지
        //인덱스 만져야될거같은데
        for(int i = start; i <= M + 1; i ++)
        {
            if(i <= M) {
                picked[cnt] = input[i];
                //다음 재귀로 넘어가는거는 이전꺼보다 두배 더 커야됨
                getCombi(cnt + 1, i * 2);
            }
            else
                break;
        }

    }


}
