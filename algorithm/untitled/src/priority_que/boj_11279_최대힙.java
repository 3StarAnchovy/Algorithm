package priority_que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for(int i = 0; i < N; i ++){
            int num = Integer.parseInt(br.readLine());

            if(num != 0){
                queue.add(num);
            }else {
                if(queue.isEmpty())
                    sb.append(0).append("\n");
                else sb.append(queue.poll()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
