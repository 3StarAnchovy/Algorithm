package dfs_bfs;

import java.util.*;

/*
접근

정점 입력 받고
1000m 거리 이하인 부분만 연결
연결 정점들이 시작점부터 도착지까지 연결되어있다면 ㅇㅋ
아님 말고
 */

public class boj_9205 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Vertex[] vertexs;
    static class Vertex
    {
        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for(int tc = 0; tc < TC; tc ++)
        {
            N = scanner.nextInt();
            vertexs = new Vertex[N + 2];
            graph = new ArrayList<>();
            for(int i = 0; i < N + 2; i ++)
                graph.add(new ArrayList<>());

            //정점들 입력
            for(int i = 0; i < N + 2; i ++)
            {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                vertexs[i] = new Vertex(x,y);
            }

            //모든 정점 탐색, 거리가 1000m 이하인것들만 연결
            for(int i = 0; i < N + 2; i ++)
            {
                for(int j = i + 1; j < N + 2; j ++)
                {
                    if(getDistance(vertexs[i], vertexs[j]) <= 1000)
                    {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            visited = new boolean[N + 2];

            bfs(0); //출발지부터 start
            if(visited[N + 1])
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }

    private static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while(queue.size() != 0)
        {
            vertex = queue.poll();
            Iterator<Integer> iterator = graph.get(vertex).listIterator();
            while(iterator.hasNext())
            {
                int next = iterator.next();
                if(!visited[next])
                {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    private static int getDistance(Vertex a, Vertex b)
    {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
