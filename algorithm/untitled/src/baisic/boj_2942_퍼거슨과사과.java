package baisic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2942_퍼거슨과사과 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //step1 최대공약수 구하기
        int gcd = getGCD(Math.max(R, C), Math.min(R, C));

        //step2 최대공약수의 약수 구하기
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                //응애 나 약수
                sb.append(i).append(' ').append(R / i).append(' ').append(C / i).append('\n');
                if (i != gcd / i) {
                    //gcd / i 도 약수
                    sb.append(gcd / i).append(' ').append(R / (gcd / i)).append(' ').append(C / (gcd / i)).append('\n');
                }
            }
        }
        System.out.print(sb);
    }

    private static int getGCD(int max, int min) {
        if (max % min == 0) {
            return min;
        }

        return getGCD(min, max % min);
    }
}
