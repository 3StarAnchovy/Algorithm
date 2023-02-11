package dfs_bfs;
import java.util.*;


public class boj_1260 {
    static int N;
    static int M;
    static int V;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 노드 개수
        M = scanner.nextInt(); // 간선 개수
        V = scanner.nextInt(); // 처음 방문할 노드

        graph = new ArrayList<>();
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i ++)
            graph.add(new ArrayList<Integer>());
        for(int i = 0; i < M; i ++)
        {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            inputGraph(x,y);
        }

        for(int i = 1; i <= N; i ++)
            Collections.sort(graph.get(i));
        DFS_1260(V);
        System.out.println();
        visited = new boolean[N + 1];
        BFS_1260(V);
    }

    private static void DFS_1260(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> temp = graph.get(v).listIterator();
        while(temp.hasNext())
        {
            v = temp.next();
            if(!visited[v])
                DFS_1260(v);
        }
    }

    private static void BFS_1260(int v) {
        Queue<Integer> queue = new LinkedList<>();

        //정점 정보 추가, 방문 체킹
        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(queue.size() != 0) {
            v = queue.poll();

            Iterator<Integer> iterator = graph.get(v).listIterator();
            while(iterator.hasNext())
            {
                v = iterator.next();
                if(!visited[v])
                {
                    queue.add(v);
                    visited[v] = true;
                    System.out.print(v + " ");
                }
            }
//            for (int i = 0; i < graph.get(v).size(); i++)
//            {
//                v = graph.get(v).get(i);
//                if(!visited[v])
//                {
//                    queue.add(v);
//                    visited[v] = true;
//                    System.out.println(v);
//                }
//            }
        }
    }


    private static void inputGraph(int x, int y)
    {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
