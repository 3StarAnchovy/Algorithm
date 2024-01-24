package baisic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (isPrime(input))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;

        }
        return true;
    }

}
