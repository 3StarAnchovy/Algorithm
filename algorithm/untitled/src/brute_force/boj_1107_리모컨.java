package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
완전탐색 or 이분탐색?

100에서부터 목표값까지 옮기기 -> 최대값

주어진 숫자를 제외하고 만들수 있는 모든 수 만들기
0 ~ 999999까지
고장난 번호면 걍 넘기기
 */
public class boj_1107_리모컨 {
    private static boolean[] broken;
    private static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if(M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < M; i ++){
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }


        //100에서부터 목표값까지 옮기기 -> 최대값
        int min = Math.abs(N - 100);

        for(int i = 0; i <= 999999; i ++){
            String sNum = String.valueOf(i);
            boolean check = false; // true면 부서진거
            int len = sNum.length();
            for(int j = 0; j < len; j ++){
                if(broken[sNum.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            if(!check){
                min = Math.min(Math.abs(N - i) + len,min);
            }
        }

        System.out.println(min);
    }
}
