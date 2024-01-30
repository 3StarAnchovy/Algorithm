package baisic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2485_가로수 {
    private static int[] diffArr;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        diffArr = new int[N - 1];
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            diffArr[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diffArr);

        int gcd = diffArr[0];
        for(int i = 1; i < N - 1; i ++){
            gcd = GCD(gcd, diffArr[i]);
        }

        int sum = 0;
        for(int i = 0; i < N - 1; i ++){
            sum +=(diffArr[i]/gcd) - 1;
        }
        System.out.println(sum);

    }

    private static int GCD(int max, int min) {
        if (max % min == 0)
            return min;
        return GCD(min, max % min);
    }
}
