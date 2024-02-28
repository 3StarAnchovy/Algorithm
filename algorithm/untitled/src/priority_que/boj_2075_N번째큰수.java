package priority_que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2075_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j ++){
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
            }
        }

        for(int i = 0; i < N - 1; i ++)
            pq.poll();

        System.out.print(pq.poll());
    }
}
