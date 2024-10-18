package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20125_쿠키의신체측정 {
    static int N;
    static int[] delta_i = {0,0,-1,1};
    static int[] delta_j = {1,-1,0,0};
    static int heart_i,heart_j;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int i = 0; i < N; i ++){
            map[i] = br.readLine().toCharArray();
        }

        findHeart();
        System.out.println(heart_i);
        System.out.println(heart_j);

        //head



    }

    private static void findHeart(){
        //심장 찾기
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j ++){
                boolean flag = true;
                for(int d = 0; d < 4; d ++){
                    int ni = i + delta_i[d];
                    int nj = j + delta_j[d];

                    if(0 <= ni && ni < N && 0<= nj && nj < N){
                        if (map[ni][nj] != '*') {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    heart_i = i;
                    heart_j = j;
                    return;
                }
            }
        }
    }
}

/*
머리 심장 허리, 팔, 다리 구분하기

// step 0 입력받기

//step 1 심장찾기

//step 2 심장 기준으로 머리 팔 허리 구하기

// 허리 끝쪽에서 다리 구하기
 */