package binary_search;

import java.util.Scanner;

/*
접근 1.
- 자를수 있는 랜선의 최소 길이는 1, 최대 길이는 입력값의 최대값이다.
- 1 ~ max까지 탐색하면서 n개를 만들수 있는 랜선의 최대 길이를 찾는다
    -> 터질거같음.

접근 2.
- 순차적으로 탐색하는것이 아니라, 이분탐색으로 접근해보자
- 랜선의 최소길이와 최대길이를 알고있으므로 mid를 도출할 수 있다.
- mid로 이분탐색하면서 어찌저찌 할 수 있지 않을까?
 */

public class boj_1654 {
    static int K;
    static int N;
    static int[] arr;
    static int arr_max = Integer.MIN_VALUE;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        K = scanner.nextInt();
        N = scanner.nextInt(); // 만들어야되는 랜선 개수

        arr = new int[K];
        for(int i = 0; i < K; i ++)
        {
            arr[i] = scanner.nextInt();
            if(arr_max < arr[i])
                arr_max = arr[i];
        }

        binarySearch(N);
    }

    private static void binarySearch(int target_cnt) {
        long start = 1; // 최소길이
        long end = arr_max; // 최대 길이

        while(start <= end)
        {
            long mid = (end + start) / 2;
            long cut_cnt = cutCable(mid);
            if(cut_cnt < target_cnt) // cut_cnt가 원하는 수보다 작으므로 더 잘게 잘라야함.
                end = mid - 1;
            else
                start = mid + 1;
        }

        System.out.println(start - 1);
    }

    private static long cutCable(long mid) {
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += arr[i] / mid;
        return sum;
    }
}
