package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class basic_BFS_Martix {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //정점 개수
        int m = scanner.nextInt(); //간선 개수
        int v = scanner.nextInt(); // 처음 방문할 노드

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        //input
        for(int i = 1; i <= m; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            inputGraph(graph,x,y);
        }

        bfs_martix(graph,v,visited);
    }

    private static void bfs_martix(int[][] graph, int v, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while(queue.size() != 0)
        {
            v = queue.poll();
            System.out.print(v + " ");
            for(int i = 0; i <= graph.length - 1; i ++)
            {
                if(!visited[i] && graph[v][i] == 1)
                {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void inputGraph(int[][] graph, int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }
}
