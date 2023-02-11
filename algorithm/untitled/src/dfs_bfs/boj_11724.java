package dfs_bfs;

import java.util.Scanner;

public class boj_11724 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[][] matrix;
    static int cnt = 0;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        matrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i ++)
        {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            insertEdge(u,v);
        }

        int result = 0;
        for(int i = 1; i <= N; i ++)
        {
            if(!visited[i])
            {
                DFS(i);
                result ++;
            }
        }

        System.out.println(result);
    }

    private static void DFS(int v) {
        visited[v] = true;

        for(int i = 1; i < N + 1; i ++)
        {
            if(!visited[i] && matrix[v][i] == 1)
            {
                DFS(i);
                cnt ++;
            }
        }
    }

    private static void insertEdge(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }
}
