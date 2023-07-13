package simulation;

import java.util.List;
import java.util.Scanner;

public class Programmers_lv2_K진수에서_소수개수_구하기 {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        int result = 0;

        //step 1 : n진법으로 변환
        String binary = convert(N, K);

        //step 2 : 0 기준으로 split
        String[] binary_list = binary.split("0");

        //step 3 : 해당 문자열 int로 바꾸고, 이거 소수인지 판단하기 (에라어쩌고)
        for (String temp : binary_list) {
            if (!temp.equals("") && isPrime(Long.parseLong(temp)))
                result ++;
        }

        System.out.println(result);
    }

    private static boolean isPrime(long lTemp) {
        if (lTemp < 2) return false;

        for (int i = 2; i <= Math.sqrt(lTemp); i++)
            if (lTemp % i == 0) return false;

        return true;
    }


    private static String convert(int n, int k) {
        String result = "";

        while (n != 0) {
            result = n % k + result;
            n /= k;
        }

        return result;
    }
}
