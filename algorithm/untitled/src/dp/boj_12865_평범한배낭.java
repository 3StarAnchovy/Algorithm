package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_12865_평범한배낭 {
    static int N,K,W;
    static int[] dp;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[K + 1]; // K무게일때, 최대 가치

        //init
        dp[0] = 0;

        //memo
    }
}

/*
dp
최대한 가치있게 배낭 싸려고함
N개의 물건이 있을 때, 무게 W와 가치 V를 가지는데 최대 K만큼 즐기려함
 */