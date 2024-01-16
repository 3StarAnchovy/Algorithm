package brute_force;

/*
    666부터 666이 연속적으로 세개가 들어가는지 체킹하기
    숫자를 하나씩부터 올려서 666이 들어간다면 카운트를 올리자.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1436_영화감독숌 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        int num = 666;

        //input
        N = Integer.parseInt(br.readLine());

        while (N != count) {
            num++;
            if (String.valueOf(num).contains("666"))
                count++;
        }
        System.out.println(num);
    }
}
