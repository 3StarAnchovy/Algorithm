package dfs_bfs;

import java.util.*;

public class boj_2606 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new ArrayList<>();

        //init
        for(int i = 0; i < N + 1; i ++)
            graph.add(new ArrayList<Integer>());
        visited = new boolean[N + 1];
        //input
        for(int i = 0; i < M; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            insertGraph(x,y);
        }

        int result = BFS(1);

        System.out.println(result);
    }

    private static int BFS(int v) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (queue.size() != 0)
        {
            v = queue.poll();
            Iterator<Integer> iterator = graph.get(v).listIterator();
            while(iterator.hasNext())
            {
                v = iterator.next();
                if(!visited[v])
                {
                    visited[v] = true;
                    queue.add(v);
                    cnt ++;
                }
            }
        }

        return cnt ++;
    }

    private static void insertGraph(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
