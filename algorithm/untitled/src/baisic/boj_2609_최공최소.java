package baisic;

/*
이때, A와 B의 최대공약수는 B와 C의 최대공약수와 같습니다. (왜 그런지는 증명을 찾아보시길!)
이러한 성질을 이용해서 계속적으로 나눗셈을 진행해서 C가 0이 되었을 때, 즉 나머지가 0이 되었을 때의 나누는 수가 최대공약수가 됩니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2609_최공최소 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int gcd = getGcd(Math.max(M, N), Math.min(M, N));
        N /= gcd;
        M /= gcd;

        int lcd = gcd * N * M;
        System.out.println(gcd);
        System.out.println(lcd);
    }

    private static int getGcd(int big, int small) {
        if (big % small == 0) {
            return small;
        }
        return getGcd(small, big % small);
    }
}
