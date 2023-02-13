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
            getPrime(1,first_prime[i]);
    }

    private static void getPrime(int cnt, int num) {
        for(int i = 1; i <= 9; i += 2)
        {
            int temp = num * 10 + i;
            //temp += 1;
            if(isPrime(num)) {
                if (cnt == N) {
                    System.out.println(num);
                    return;
                }
                else
                    getPrime(cnt + 1, temp);
            }
//            else
//                return;
            //else reutrn 찍으면 안됨 -> for문 계속 돌려야되는데 못돌림
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num; i ++)
        {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
