package simulation;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_lv2_두큐합같게만들기 {
    public static void main(String[] args) {

    }

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();

        long sum = 0;
        long que1_sum = 0;
        long qSize = queue1.length;

        //step1 : 큐의 모든 합 구하기 (long), 큐 하나 정하고 그거 합 구하기
        for (int i = 0; i < qSize; i++) {
            sum += queue1[i];
            sum += queue2[i];
            que1_sum += queue1[i];

            que1.add(queue1[i]);
            que2.add(queue2[i]);
        }

        sum /= 2;
        int cnt = 0;
        int max_size = queue1.length * 3;

        //step 2:  while (큐의 모든합 / 2 != 큐 하나 합 ) 작으면 빼오고, 크면 빼기
        while (sum != que1_sum) {
            int temp;

            if (max_size < cnt)
                return -1;

            if (sum < que1_sum) {
                temp = que1.poll();
                que1_sum -= temp;
                que2.add(temp);
            } else {
                temp = que2.poll();
                que1_sum += temp;
                que1.add(temp);
            }

            cnt++;
        }

        return cnt;
    }
}
