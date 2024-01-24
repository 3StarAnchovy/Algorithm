package binary_search;

//접근
// 해쉬맵 사용하기
/*
step1 입력받기
입력값은 키로 세팅 -> 이때 값은 0으로 해주기, 기존에 있던 값이라면 기존값에서 ++해주기

step2 M입력받기
키 받아와서 값 뱉기
 */

// 이진탐색 사용하기? 이건모르겠는디

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_10816_숫자카드2_해쉬맵 {
    static private int N, M;
    static private HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        hashMap = new HashMap<>();
        N = Integer.parseInt(br.readLine());

        //step1 입력받기
        // 입력값은 키로 세팅 -> 이때 값은 0으로 해주기, 기존에 있던 값이라면 기존값에서 ++해주기
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (hashMap.get(input) == null)
                hashMap.put(input, 1);
            else
                hashMap.put(input, hashMap.get(input) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (hashMap.get(input) == null)
                sb.append(0).append(' ');
            else
                sb.append(hashMap.get(input)).append(' ');
        }

        System.out.println(sb);
    }
}
