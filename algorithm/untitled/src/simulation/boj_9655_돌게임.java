package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;

        int mok = N / 3;
        int na = N % 3;

        if (na == 0){
            if(mok % 2 != 0) { // 홀수일 때
                num = 1; // 상근이 승리
            } else {
                num = -1; // 창영이 승리
            }
        }else{
            if(mok % 2 != 0){ // 홀수일 때 창영이 턴
                if(na == 1) {
                    num = -1;
                } else {
                    num = 1;
                }
            } else { // 짝수일 때 상근이 턴
                if(na == 1){
                    num = 1;
                } else {
                    num = -1;
                }
            }
        }

        String result = num == 1 ? "SK" : "CY";
        System.out.println(result);
    }
}

//3으로 나눠.
//나머지가 없을 때
//홀수면 상근이 승리
//짝수면 창영이 승리

//나머지가 있을 때
//몫이 홀수면 창영이턴
//몫이 짝수면 상근이턴

//창영이 턴일 때 나머지가 1이면 창영이 승리, 아니면 근영이 승리
//상영이 턴일 때 나머지가 1이면 근영이 승리, 아니면 창영이 승리

/*
두명
돌 N개가 있을 때, 턴을 번갈아가면서 돌을가져감
돌은 1개 또는 3개 가져갈 수 있음
마지막 돌을 가져 가는 사람이 승리함
 */