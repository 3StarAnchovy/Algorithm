package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467_용액 {
    static int N;
    static long[] arr;
    static int left, right;
    static long min;
    static long min_left;
    static long min_right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        min = Math.abs(arr[0] + arr[N - 1]);
        min_left = arr[0];
        min_right = arr[N - 1];


        for (int i = 0; i < N; i++)
            binarySearch(i, N - 1);
        System.out.println(min_left + " " + min_right);
    }

    private static void binarySearch(int start, int end) {
        left = start + 1;
        right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            long result = (arr[start] + arr[mid]);

            if (Math.abs(result) < min) {
                min_left = arr[start];
                min_right = arr[mid];
                min = Math.abs(result);
                //System.out.println(result);
            }

            if (result >= 0) {
                right = mid - 1;
            } else if (result < 0) {
                left = mid + 1;
            }
        }
    }
}

/*
범위 좀 큼

같은양의 두 용액을 혼합하여 특성값이 0에 가장 가깝게 용액을 만들료고 한다.
 */

/*
이분 탐색
min = 0
max = 맨 끝 인덱스

용액 합쳐보기

0 보다 커? max = mid - 1
0 보다 작거나 같아? min = mid + 1
 */