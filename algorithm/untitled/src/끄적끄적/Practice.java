package 끄적끄적;

import java.util.*;

public class Practice {
    static int N;
    static int[] first_prime = {2,3,5,7};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for(int i = 0; i < 4; i ++)
            getPrime(2,first_prime[i]);
    }

    //함수가 해야할것을 명확하게 해야할 필요가 있어보임
    //기제조건, 유도파트 명확하게 해보자
    private static void getPrime(int cnt, int num)
    {
        for(int i = 1; i <= 9; i += 2)
        {
            int temp = num * 10 + i;
            if(isPrime(temp))
            {
                if(N == cnt) {
                    System.out.println(temp);
                    return ;
                }
                else
                    getPrime(cnt + 1, temp);
            }
        }
    }

    private static boolean isPrime(int temp) {
        for(int i = 2; i < temp; i ++)
        {
            if(temp % i == 0)
                return false;
        }
        return true;
    }
}
