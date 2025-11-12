package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1254_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (isPail(str.substring(i)))
                break;

            result++;
        }

        System.out.println(str.length() + result);
    }

    private static boolean isPail(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}


/*
 -앞에서 읽으나 뒤에서 읽으나 같게 읽히는 문자열 - 팰린 드롬
 */

/*
abcba

abt c tba
 */