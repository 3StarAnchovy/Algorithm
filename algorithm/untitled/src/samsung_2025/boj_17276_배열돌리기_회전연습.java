package samsung_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17276_배열돌리기_회전연습 {
    static int[][] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int rotate = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            for(int i = 0; i < n; i ++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j ++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(rotate < 0) {
                rotate += 360;
            }
            rotate /= 45;

            while(rotate -- > 0) {
                roateArr();
            }

            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void roateArr() {
        int[] copy;

        copy = new int[n];

        for(int i = 0; i < n; i ++) {
            copy[i] = arr[i][n/2]; // 대각선 하나 카피 따기
        }
        //배열 돌리기
        for(int i = 0; i < n; i ++) {
            arr[i][n/2] = arr[i][i];
            arr[i][i] = arr[n/2][i];
            arr[n/2][i] = arr[n-i-1][i];
            arr[n-i-1][i] = copy[n-i-1];
        }
    }
}

/*
n* n 배열 있음
x를 시계방향 또는 반시계로 45도 돌릴려함.

step 1. 입력받기
step 2. 각도 계산하기 (음수는 ? => + 360)
45로 나누기
step3.카피 따고 배열 돌리기
 */
