package dfs_bfs;

import java.util.*;

public class basic_BFS {
    public static void inputGraph(ArrayList<ArrayList<Integer>> graph, int x, int y)
    {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public static void bfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited)
    {
        // 1. 큐를 생성하고 시작 노드 v의 값을 큐에 넣는다.
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty())
        {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> iterator = graph.get(v).listIterator();
            while(iterator.hasNext())
            {
                int w = iterator.next();
                if(!visited[w])
                {
                    visited[w] = true;
                    queue.add(w);
                }
            }
        }

        // 2. 조건에 맞는 정점을 찾는다면 해당 정점을 방문했음으로 표시 후, 큐에 넣는다.
        // 3. 큐가 소진될때까지 무한 반복
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //정점의 개수
        int n = scanner.nextInt();
        for(int i = 0; i < n + 1; i ++)
            graph.add(new ArrayList<>());
        boolean[] visited = new boolean[n + 1];
        //간선의 개수, 개수 만큼 인풋
        int m = scanner.nextInt();
        for(int i = 0; i < m; i ++)
        {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            inputGraph(graph,v1,v2);
        }

        //방문 순서를 위해 오름차순 정렬
        for(int i = 1; i <= n; i ++)
            Collections.sort(graph.get(i));

        System.out.println("BFS");

        //첫 방문 노드 지정
        int v = scanner.nextInt();
        bfs(v,graph,visited);
    }
}
