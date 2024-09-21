package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1206_등수구하기 {
    static int N, P;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //step0 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        arr = new long[N];

        if(N == 0) {
            System.out.println(1);
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        //step 1 배열 오름차순으로 수정하기
        //Arrays.sort(arr);

        if(N == P && newScore <= arr[N - 1]) {
            System.out.println(-1);
            System.exit(0);
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] > newScore) {
                rank++;
            } else
                break;
        }

        System.out.println(rank);
    }

    private static int bs(int score) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] < score) {
                start = mid + 1;
            } else if (arr[mid] > score) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}


/*
노래마다 랭킹 리스트가 있음
게임할 때마다 얻는 점수가 비오름차순으로 저장 되어있다.

랭킹 리스트에 올라갈수 있는 점수의 개수가 P가 주어지고
리스트에 있는 N개가 비오름차순으로 주어진다.
새로운 점수가 랭킹 리스트에서 몇등 하는지 구하세용
랭킹리스트에 올라갈 수 없을 정도로 낮다면 -1 출력
 */