package brute_force;

import java.util.Scanner;

public class boj_7696 {
    public static boolean checkDigit(int n, int temp)
    {
        while(n != 0)
        {
            if((n % 10) != temp)
                return false;
            n /= 10;
        }
        System.out.println("true");
        return true;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        //tt
        int n = 1;
        while(n != 0)
        {
            n = scanner.nextInt();
            int cnt = 0;
            int sum = 0;
            for(int i = 1; i <=n; i ++)
            {
                if(i < 10)
                {
                    cnt ++;
                    continue;
                }
                //자릿수가 같지 않으면
                if(checkDigit(cnt, cnt % 10) == false)
                    cnt ++;
                else {
                    cnt ++;
                    sum++;
                }
            }
            if (n == 0)
                break;
            System.out.println(cnt + sum);
        }
    }
}
