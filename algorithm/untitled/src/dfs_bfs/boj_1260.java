package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class boj_1260 {
    public static void inputEdge(ArrayList<ArrayList<Integer>> graph, int x, int y)
    {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M, V;

        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        //init
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        //input
        for(int i = 0; i < 5; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            inputEdge(graph,x,y);
        }
    }
}
