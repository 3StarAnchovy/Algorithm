package dfs_bfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1389 {
    static int N; // 정점 수
    static int M; // 간선 수
    static int[][] matrix;
    static boolean[] visited;
    static int[][] distance;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        matrix = new int[N+1][N+1];
        visited = new boolean[N + 1];
        distance = new int[N + 1][N + 1];

        for(int i = 0; i < M; i ++)
        {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            insertEdge(r,c);
        }


        for(int i = 1; i <= N; i ++)
        {
            bfs(i);

            visited = new boolean[N + 1];
        }

        for(int[] i : distance) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;
        while(queue.size() != 0)
        {
            int temp = queue.poll();
            for(int i = 1; i <= N; i ++)
            {
                if(!visited[i] && matrix[v][i] == 1)
                {
                    distance[v][i] ++;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    private static void insertEdge(int r, int c) {
        matrix[r][c] = 1;
        matrix[c][r] = 1;
    }
}
