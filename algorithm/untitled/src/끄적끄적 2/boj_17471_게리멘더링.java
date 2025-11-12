package 끄적끄적;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_17471_게리멘더링 {
    static int N;
    static int[] pop;
    static int[] area;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        pop = new int[N + 1];
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        area = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
            pop[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                graph.get(i).add(scanner.nextInt());
            }
        }

        //step1 : 구역 나누기
        powerset(1);
    }

    private static void powerset(int num) {
        if(num == N + 1)
        {
            int area1 = 0;
            int area2 = 0;

            for(int i = 1; i <= N; i ++)
            {
                if(area[i] == 1) area1 += pop[i];
                else area2 += pop[i];
            }
            return;
        }

        area[num] = 1;
        powerset(num + 1);

        area[num] = 2;
        powerset(num + 1);

    }
}
