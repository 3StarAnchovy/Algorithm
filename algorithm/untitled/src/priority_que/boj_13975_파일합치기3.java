package priority_que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13975_파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < K; i++) {
                pq.add(Long.valueOf(st.nextToken()));
            }

            long sum = 0;
            while (pq.size() >= 2){
                long num1 = pq.poll();
                long num2 = pq.poll();
                sum += num1 + num2;
                pq.add(num1 + num2);
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
