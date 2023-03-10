package brute_force;

import java.util.Scanner;

public class boj_2023 {
    static int N;
    static int[] first_prime = {2,3,5,7};
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i = 0; i < 4; i ++)
        {
            getPrime(2,first_prime[i]);
        }
    }

    private static void getPrime(int cnt, int num) {

        //자릿수 올리고, 값 더함 (홀수만)
        for(int i = 1; i <= 9; i += 2)
        {
            int temp = num * 10 + i;
            //소수 체킹하고
            if(isPrime(temp))
            {
                //N이면 출력
                if(cnt == N)
                    System.out.println(temp);
                //아니면 재귀 ㄱㄱ
                else
                    getPrime(cnt + 1, temp);
            }
            //소수가 아니면? "num에 변화 없이" 다음 for문
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num ; i ++)
        {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
