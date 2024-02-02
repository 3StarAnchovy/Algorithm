package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N개의 랜선 만들어야함.
K개의 랜선은 길이가 다 다름. 모두 N개의 같은 길이의 랜선을 잘라야함.
- 자를수 있는 랜선의 최소 길이는 1, 최대 길이는 입력값의 최대값이다.
- 1 ~ max까지 탐색하면서 n개를 만들수 있는 랜선의 최대 길이를 찾는다 -> 하나하나 다 돌리면 터지니까 이분탐색
 */
public class boj_1654_랜선자르기_재활 {
    private static int K, N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int sum = 0;
        arr = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        System.out.println(binarySearch(max) -1);

    }

    //최소값 ~ 최대값 까지 다 짤라보기.
    // 목표값보다 작아? 더 잘게 잘라
    // 목표값보다 커? 더 크게 잘라
    private static long binarySearch(int max) {
        long start = 1;
        long end = max; //start와 end가 의미하는거 = 이 길이로 자를거야

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = cutCable(mid);

            if (cnt < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static long cutCable(long mid) {
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i] / mid;
        }
        return sum;
    }
}
