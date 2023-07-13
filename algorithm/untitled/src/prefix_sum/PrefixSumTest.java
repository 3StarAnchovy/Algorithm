package prefix_sum;

import java.util.Scanner;

/*
- 누적합을 이용하여 구간합 구하기
 */
public class PrefixSumTest {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] prefix_sum = new int[11];

        //누적합 구하기
        //3 ~ 5 까지 ㅇㅇ
        for(int i = 1; i < arr.length; i ++)
        {
            prefix_sum[i] = prefix_sum[i - 1] + arr[i];
        }

        System.out.println(prefix_sum[5] - prefix_sum[3 - 1]);
    }
}
