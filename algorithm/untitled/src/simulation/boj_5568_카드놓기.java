package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_5568_카드놓기 {
    static int N, K;
    static int[] arr;
    static int[] picked;
    static boolean[] visited;
    static HashMap<String,Integer> hashMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        picked = new int[K];
        visited = new boolean[N];
        hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        perm(0);
        System.out.println(hashMap.size());
    }

    private static void perm(int cnt) {
        if (cnt == K) {
            StringBuilder word = new StringBuilder();
            for(int i = 0; i < K; i ++){
                word.append(picked[i]);
            }
            hashMap.putIfAbsent(word.toString(), 1);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            picked[cnt] = arr[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}

/*
카드 n장을 바닥에 나란히 놓고 있음 (카드는 1~99까지의 숫자)

카드중에서 k장 선택
상근이가 만들 수 있는 정수는 몇개임?
 */

