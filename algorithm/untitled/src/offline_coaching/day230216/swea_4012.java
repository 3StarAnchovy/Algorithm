package offline_coaching.day230216;

import java.util.ArrayList;
import java.util.Scanner;

public class swea_4012 {
    /*
    1. 반갈하는거 조합
        세트 하나 조합으로 뽑음
        다른 세트는 위에서 뽑힌것들 중 나머지임
    2. 세트 뽑은거로 요리
        시너지 합산하고 요리 두개 빼기
        뺀 거 최소값임? ㅇㅇ -> 출력
    3. 요리한거로 맛의 차이
     */
    static int N;
    static int[] picked;
    static int[][] foods;
    static boolean[] isSelected;
    static int[] food_num;
    static int[] a_set;
    static int[] b_set;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for(int t = 1; t <= TC; t ++)
        {
            N = scanner.nextInt();

            food_num = new int[N];

            /*
            뽑은거 true -> a음식 세트
            안뽑은거 false -> b음식 세트
             */
            isSelected = new boolean[N];

            for (int i = 0; i < N; i++)
                food_num[i] = i;

            getCombiSet(0, 0);
        }
    }

    private static void getCombiSet(int cnt, int start) {
        if(cnt == N / 2)
        {
            for(int i = 0; i < N; i ++)
            {
                System.out.print(isSelected[i] ? food_num[i]+ " " : "");
            }
            System.out.println();
            return ;
        }

        for(int i = start; i < N; i ++)
        {
            isSelected[i] = true;
            getCombiSet(cnt + 1, i + 1);
            isSelected[i] = false;
            getCombiSet(cnt + 1, i + 1);
        }
    }


}
