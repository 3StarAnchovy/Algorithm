package dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class boj_17471_게리맨더링 {
    static int N;
    static int[] pop;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] area;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        pop = new int[N + 1];
        area = new int[N + 1];
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());
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

        //구역 나누기
        powerset(1);
        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    private static void powerset(int area_num) {
        if(area_num == N + 1)
        {
            int area_1 = 0;
            int area_2 = 0;
            for(int i = 1; i <= N; i ++)
            {
                if(area[i] == 1) area_1 += pop[i];
                else area_2 += pop[i];
            }

            visited = new boolean[N + 1];
            int check = 0;
            for(int i = 1; i <= N; i ++)
            {
                if(!visited[i])
                {
                    check ++;
                    bfs(i, area[i]);
                }
            }

            if(check == 2) min = Math.min(min, Math.abs(area_1 - area_2));
            return;
        }

        area[area_num] = 1; //
        powerset(area_num + 1);
        area[area_num] = 2;
        powerset(area_num + 1);
    }

    private static void bfs(int i, int num) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[i] = true;

        queue.add(i);
        while(!queue.isEmpty())
        {
            int cur = queue.poll();
            for(int k = 0; k < graph.get(cur).size(); k ++)
            {
                int nxt = graph.get(cur).get(k);
                if(area[nxt] == num && !visited[nxt])
                {
                    visited[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
    }
}
