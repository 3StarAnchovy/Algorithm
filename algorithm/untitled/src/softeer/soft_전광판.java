package softeer;

import java.io.*;
import java.util.*;

/*

step1 while문 돌리기

    while( a != 0 && b != 0)
        a,b 나머지 연산하기
        나머지 연산한거 차이만큼 cnt ++;

    if(a>0)
        0이 될때까지 나머지 연산해서 자릿수 싹다 더하기
    else if(b>0)
        0이 될때까지 나머지 연산해서 자릿수 싹다 더하기

*/
public class soft_전광판 {
    private static int cnt;
    private static int[][] board = {
        {1, 1, 1, 0, 1, 1, 1}, //0
        {0, 0, 1, 0, 0, 0, 1}, // 1
        {0, 1, 1, 1, 1, 1, 0}, //2
        {0, 1, 1, 1, 0, 1, 1}, //3
        {1, 0, 1, 1, 0, 0, 1}, //4
        {1, 1, 0, 1, 0, 1, 1},//5
        {1, 1, 0, 1, 1, 1, 1},//6
        {1, 1, 1, 0, 0, 0, 1},//7
        {1, 1, 1, 1, 1, 1, 1},//8
        {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 0; t < TC; t++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (a != 0 && b != 0) {
                diff(a % 10, b % 10);

                a /= 10;
                b /= 10;
            }

            if (a > 0) {
                mod(a);
            } else if (b > 0) {
                mod(b);
            }
            System.out.println(cnt);
        }
    }

    private static void mod(int a) {
        while (a != 0) {
            int mod = a % 10;
            for (int i = 0; i < 7; i++) {
                cnt += board[mod][i];
            }
            a /= 10;
        }
    }

    private static void diff(int a, int b) {
        for (int i = 0; i < 7; i++) {
            if (board[a][i] != board[b][i])
                cnt++;
        }
    }
}
