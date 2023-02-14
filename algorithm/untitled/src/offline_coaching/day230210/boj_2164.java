package offline_coaching.day230210;

import java.util.*;

public class boj_2164 {
    static int N;
    static int[] arr;
    static Queue<Integer> card;
    public static void main(String[] args)
    {
        card = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N];

        //init
        for(int i = 1; i <= N; i ++)
            card.add(i);

        actFunc();
        System.out.println(card.element());
    }

    private static void actFunc() {
        while(card.size() > 1) {
            card.poll();
            int temp = card.poll();
            card.offer(temp);
        }

        //System.out.println(card.poll());
    }


}
