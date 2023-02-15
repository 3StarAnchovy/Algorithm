package offline_coaching.day230215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_11286 {
    static int N;
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) ->
    {
        if ( Math.abs(o1) - Math.abs(o2) > 0 )
            return  1;
        else if ( Math.abs(o1) - Math.abs(o2) == 0)
            return o1 - o2;
        else
            return  - 1;
    }));

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for(int i = 0; i < N; i ++)
        {
            int temp = scanner.nextInt();
            if(temp != 0)
                priorityQueue.add(temp);
            else
            {
                if(priorityQueue.peek() != null)
                    System.out.println(priorityQueue.poll());
                else
                    System.out.println(0);
            }
        }
    }
}
