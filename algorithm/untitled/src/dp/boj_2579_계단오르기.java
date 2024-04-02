package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2579_계단오르기 {
    static int[] step;
    static int[] memo;
    static int N;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}

/*
테이블 정의하기
memo[i][j] j개의 계단을 연속해서 밟았을때, i번째 계단까지 올라간 점수의 최대값
memo[5][2] 2개의 계단을 연속해서 밟았을 때, 5번째 계단에서의 최대값

점화식 뽑기
 */
