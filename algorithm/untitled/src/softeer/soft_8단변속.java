package softeer;

import java.io.*;
import java.util.*;

/*
변속이 가능한지 점검할수 있는 프로그램

*/
public class soft_8단변속 {
    private static int[] arr;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] == 1) {
            answer = "ascending";
            for (int i = 1; i < 8; i++) {
                if (arr[i] != arr[i - 1] + 1) {
                    answer = "mixed";
                    break;
                }
            }
        } else if (arr[0] == 8) {
            answer = "descending";
            for (int i = 1; i < 8; i++) {
                if (arr[i] != arr[i - 1] - 1) {
                    answer = "mixed";
                    break;
                }
            }

        } else {
            answer = "mixed";
        }

        System.out.println(answer);
    }
}
