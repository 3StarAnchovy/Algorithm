package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11866_요세푸스_입출력최적화 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new ArrayDeque<>();

        //input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //init
        for (int i = 1; i <= N; i++)
            queue.add(i);

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if (!queue.isEmpty())
                sb.append(", ");
        }

        //answer
        sb.append(">");
        System.out.print(sb);
    }
}
