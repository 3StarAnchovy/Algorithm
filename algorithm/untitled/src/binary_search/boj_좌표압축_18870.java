package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_좌표압축_18870 {
    static int N;
    static int[] arr;
    static int[] raw;
    static HashMap<Integer, Integer> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        raw = new int[N];
        hash = new HashMap<>(); // key : num, value : rank

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            raw[i] = arr[i];
        }

        Arrays.sort(arr); //nlogn

        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (hash.get(arr[i]) == null) {
                hash.put(arr[i], rank);
                rank++;
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(hash.get(raw[i])).append(" ");
        }
        System.out.println(sb);
    }
}
/*
step 1 : 정렬하기
step 2 : hash에 박기
step 3 : 리턴하기
 */
