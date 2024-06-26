package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3273_두수의합 {
    static int N;
    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        K = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            if (bs(num, i + 1, N - 1))
                answer++;
        }
        System.out.print(answer);
    }

    private static boolean bs(int num, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (num + arr[mid] < K)
                start = mid + 1;
            else if (num + arr[mid] > K)
                end = mid - 1;
            else {
                return true;
            }
        }

        return false;
    }
}
