package priority_que;

/*
각 묶음의 카드의 수를 A,B라하면 A+B번의 비교를 해야함.

10 20 40
1 2 5 7

1 2 3 / 3
3 5 / 11
8 7 / 26
10 20 = 30
30 40 = 70

하나가 될 떄 까지?
작은것들끼리 더해야함.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_1715_카드정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1 == o2) return 0;
                else return o1 < o2 ? -1 : 1;
            }
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Integer.parseInt(br.readLine());

            queue.add(num);
        }

        long sum = 0;

        while (queue.size() >= 2){
            long num1 = queue.poll();
            long num2 = queue.poll();
            sum += num1 + num2;

            queue.add(num1 + num2);
        }

        System.out.println(sum);
    }
}
