package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {
    static Queue<Integer> bridge = new ArrayDeque<>();
    static Queue<Integer> truck = new ArrayDeque<>();
    static int N, W, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        // step0 브릿지 큐 전부다 0으로 채우기
        for (int i = 0; i < W; i++) {
            bridge.add(0);
        }

        // step 1 입력받기
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int sum = 0; // 다리 위 트럭들의 합
        while (!bridge.isEmpty()) {
            time++;
            sum -= bridge.poll();

            if (!truck.isEmpty()) {
                int a = truck.peek();

                if (sum + a > L) {
                    bridge.add(0);
                } else {
                    bridge.add(a);
                    sum += a;
                    truck.poll();
                }
            }
        }

        System.out.println(time);
    }
}

/*
N개의 트럭이 건너가려고한다.
트럭의 순서는 바꿀수없고, 무게는 서로 같다.
다리 위에는 단지 W대의 트럭만 동시에 올라갈 수 있따. 하나의 단위시간의 하나의 단위길이만큼 이동할 수 있따.
동시에 다리위에 올라가있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야한다.
 */

/*
큐 문제
step 2 입력받은 숫자의 큐에 들어있는 트럭의 합이 최대하중보다
크면? 0 박기
작거나 같으면? 큐에 넣기

step 3 큐 빼기
 */