package brute_force;

import java.util.Scanner;

public class boj_7696 {
    public static boolean isDouble(int num)
    {
        int[] cnt = new int[10];
        while(num != 0)
        {
            cnt[num % 10] ++;
            if(cnt[num % 10] != 1)
                return false;
            num /= 10;
        }

        return true;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while(n != 0)
        {
            int cnt;
            //시행 횟수
            cnt = n;
            for(int i = 1; i <= n; i ++)
            {
                //true면 중복아닌
                if(!isDouble(i))
                    cnt ++;
            }
            System.out.println(cnt);
            n = scanner.nextInt();
        }
    }
}
