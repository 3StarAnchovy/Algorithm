package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16410_과자나눠주기 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[N - 1];

        int result = binarySearch(1, max);
        System.out.println(result);

    }

    private static int binarySearch(int min, int max) {
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < M) {
                max = mid - 1;
            } else if (cnt >= M) {
                result = mid;
                min = mid + 1;
            }
        }

        return result;
    }
}

/*
조카들에게 최대한 긴 과자를 나눠주려고 한다. 모즌 조카에게 같은 길이에 나눠주어야하낟.
M명의 조카가 있고, N개의 과자가 있을 때, 조카 1명에게 줄수있는 막대 과자의 길이를 구하라.

변수 특정 -> 과자 나누기 -> 몫 추출 후 cnt에 더하기
cnt == M이야? return
cnt > M이야? 변수 더 키워
cnt < M이야? 변수 더 조그맣게 ㄱㄱ

변수 어케 구함?
1. 순차적으로 탐색하기 1 ~ max 까지 -> 너무 오래걸림
2. 이분탐색
 */
