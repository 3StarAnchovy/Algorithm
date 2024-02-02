package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
나무 M미터 필요함.
H 기준으로 자를건데, H보다 작으면 안잘림

적어도 M미터의 나무를 집에 가져가기 위해 절단기에서 설정할 수 있는 높이 최대값 구해보기

높이의 최소값은 0
높이의 최대값은 입력값중 최대값
높이 하나씩 늘려가면서 짤라보기 -> 터짐 -> 이분탐색

잘린 나무의 길이 합이 M보다 작아? 더 길게 짤라 ㅇㅇ 높이 낮춰
커? 높이 키워
 */
public class boj_2805_나무자르기 {
    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            max = Math.max(max, arr[i]);
        }

        long result = binarySearch(max);
        System.out.println(result - 1);
    }

    private static long binarySearch(int max) {
        long start = 0;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = cutTree(mid);

            if (cnt < M) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return start;
    }

    private static long cutTree(long mid) {
        long sum = 0;
        for(int i = 0; i < N; i ++){
            sum += arr[i] - mid > 0 ? arr[i] - mid : 0;
        }
        return sum;
    }
}
