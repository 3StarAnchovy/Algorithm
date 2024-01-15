package stack_queue;

/*
        1번 부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 정수 k가 주어짐 -> 1base
        순서대로 k번째 사람을 제거함.
        결론
        K번 쨰 수가 되기 직전까지 맨 앞의 원소를 K-1 번 꺼내오고(poll) 꺼내온 원소들을 맨 뒤로 넣는다.(offer)
        그리고 K번째로 뽑힌(poll) 원소는 출력하면 되는 것이다.
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_11866_요세푸스 {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();

        //step 1. 입력받기
        N = scanner.nextInt();
        K = scanner.nextInt();

        //step2. 큐에 값 넣기
        for (int i = 1; i <= N; i++)
            queue.add(i);

        System.out.print("<");
        while (!queue.isEmpty()) {
            //step2. K번째 수가 되기 직전까지 꺼내기
            for (int i = 0; i < K - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            System.out.print(queue.poll());

            if(queue.size() >= 1)
                System.out.print(", ");
        }
        System.out.println(">");
    }
}
