package brute_force;

import java.util.Scanner;

public class boj_14568 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int cnt = 0;
        //1 ~ N까지 모든 경우의 수
        for(int i = 1; i <= N; i ++)
        {
            int young = i;
            //남희는 2개 이상이여야 함
            for(int j = i + 2; j <= N - i; j ++) {
                int nam = j;
                int taek = N - i - j;
                if (taek % 2 == 0 && taek > 0 && (nam + young + taek == N))
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
