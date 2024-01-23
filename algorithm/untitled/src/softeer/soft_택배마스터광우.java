package softeer;

import java.io.*;
import java.util.*;

/*
step 1 순열 구하기

step 2 순열로 탐색된 배열로 바구니 넘게 안넘을만큼 담기
*/
public class soft_택배마스터광우 {
    private static int N, M, K;
    private static int[] arr;
    private static int[] picked;
    private static boolean[] isSelected;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        picked = new int[N];
        isSelected = new boolean[N];
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        getPerm(0);
        System.out.println(min);
    }

    private static void getPerm(int cnt) {
        //step 2 순열로 탐색된 배열로 바구니 넘게 안넘을만큼 담기
        if (cnt == N) {
            int sum = 0;
            int i = 0;
            for (int k = 0; k < K; k++) {
                int bag = 0;
                while (true) {
                    bag += picked[i];
                    i = (i + 1) % N;

                    if (bag + picked[i] > M)
                        break;
                }
                sum += bag;
            }

            min = Math.min(sum, min);
            //System.out.println(Arrays.toString(picked));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isSelected[i]) {
                picked[cnt] = arr[i];
                isSelected[i] = true;
                getPerm(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}
