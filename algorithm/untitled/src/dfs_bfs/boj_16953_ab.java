package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953_ab {
    static long N, M;
    static HashMap<Long, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long answer = bfs(N, M);
        System.out.println(answer);
    }

    private static long bfs(long N, long M) {
        Queue<Long> que = new ArrayDeque<>();
        hashMap.put(N, 1);
        que.add(N);

        int time = 0;
        while (!que.isEmpty()) {
            int qSize = que.size();
            time++;
            while (qSize-- > 0) {
                long num = que.poll();
                //System.out.println(num);
                if (num == M) {
                    return time;
                } else {
                    //수정해보자
                    if (num * 2 <= 1000000001 && hashMap.get(num * 2) == null) {
                        que.add((num * 2L));
                        hashMap.put(num * 2, 1);
                    }

                    if (num * 10 + 1 <= 1000000001 && hashMap.get(num * 10 + 1) == null) {
                        que.add((num * 10L + 1));
                        hashMap.put(num * 10 + 1, 1);
                    }

                }
            }
        }

        return -1;
    }
}

/*
정수 A를 B로 바꾸려고 한다.
* 2를 곱한다
* 1을 수의 가장 오른쪽에 추가한다.
 */
