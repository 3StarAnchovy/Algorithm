package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2512_예산 {
    private static int N;
    private static int[] arr;
    private static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        M = Long.parseLong(br.readLine());
        long a = binarySearch(max);

        System.out.println(a - 1);
    }

    //
    private static long binarySearch(int max) {
        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = limitMax(mid); // sum이 총 예산보다 커? 상한액 줄여

            if (sum <= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static long limitMax(long mid) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i] > mid ? mid : arr[i];
        }

        return sum;
    }
}
