package prefix_sum;

import java.util.Scanner;

/*
- 일반적인 합 구하기
 */
public class SumTest {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int sum = 0;
        //N 부터 M까지의 합 구하기
        for(int i = N; i <= M; i ++)
            sum += arr[i];

        System.out.println(sum);
    }
}
