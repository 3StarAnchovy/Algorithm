package softeer;

import java.io.*;
import java.util.*;

/*
부모님께서 농사를 지을 땅의 크기는 1*3
땅의 높이를 변경하는데 1초 소비됨.
*/
public class soft_진정한효도 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[3][3];
        //step1 입력받기
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int n = 1; n <= 3; n++) {
            //step2 가로줄 1~3까지 만들어보기
            for (int i = 0; i < 3; i++) {
                int time = 0;
                for (int j = 0; j < 3; j++) {
                    int diff = map[i][j] - n;
                    time += Math.abs(diff);
                }

                result = Math.min(result, time);
            }

            //step3 세로줄 1~3까지 만들어보기
            for (int j = 0; j < 3; j++) {
                int time = 0;
                for (int i = 0; i < 3; i++) {
                    int diff = map[i][j] - n;
                    time += Math.abs(diff);
                }

                result = Math.min(result, time);
            }

        }

        System.out.println(result);
    }
}
