package baisic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1676_팩토리얼0의개수 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[10];

        // 2와 5의 갯수 구하기 ?
        // ㄴㄴ 5의 개수 구하기임
        int cnt = 0;
        for(int i = 1; i <= N; i ++) {
            int temp = i;
            while(temp % 5 == 0) {
                cnt ++;
                temp /= 5;
            }
        }
        System.out.print(cnt);
    }
}
