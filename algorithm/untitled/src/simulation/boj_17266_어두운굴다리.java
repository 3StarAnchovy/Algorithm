package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17266_어두운굴다리 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bs());

    }

    private static int bs() {
        int start = 1;
        int end = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (light(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static boolean light(int height) {
        boolean[] visited = new boolean[N];

        int prev = 0; // 이전 가로등이 비춘 위치

        for (int i=0; i<arr.length; i++) {
            if (arr[i] - height <= prev) {
                prev = arr[i] + height;
            } else {
                return false;
            }
        }

        // 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 커야함
        return N - prev <= 0;
    }
}

/*
이분탐색..?
 */

/*
가로등 설치 개수 M과 각 가로등의 위치 x들의 결정을 끝냄
가로등은 높이만큼 주위 비출수있음
최소 높이로 모든길을 밝힘
가로등은 모든 높이가 같아야함
 */
