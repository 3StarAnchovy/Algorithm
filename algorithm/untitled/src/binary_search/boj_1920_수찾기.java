package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        //input
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //step 1 정렬 조지기
        Arrays.sort(arr);

        //step 2 이분탐색 조지기
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(binarySearch(num)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean binarySearch(int num) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            }
        }

        return false;
    }
}

/*
N개의 정수가 주어졌을때, X라는 정수가 존재하는지 알아내는 프로그램 작성하기

step 1 정렬 조지기

step 2 이분탐색 조지기
 */
