package priority_que;

/*
절대값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
절대값이 가장 작은값이 여러개일때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_11286_절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);

                if (a == b) {
                    return o1 - o2;
                } else
                    return a - b;
            }
        });
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.add(num);
            } else {
                if (queue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
