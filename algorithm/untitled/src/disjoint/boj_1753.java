package disjoint;

import java.util.*;

public class boj_1753 {
    static int V;
    static int E;
    static int start;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Vertex>> graph;

    static class Vertex implements Comparable<Vertex>
    {
        int no;
        int weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }


        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        V = scanner.nextInt();
        E = scanner.nextInt();
        start = scanner.nextInt();
        graph = new ArrayList<>();

        for(int i = 0; i < V + 1; i ++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < E; i ++)
        {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(from).add(new Vertex(to,weight));
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];


        dijkstra();
        for(int v = 1; v <= V; v ++)
        {
            System.out.println(distance[v] == Integer.MAX_VALUE ? "INF" : distance[v]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        int INF = Integer.MAX_VALUE;
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.add(new Vertex(start,0));
        int cnt = 0;
        while(!pq.isEmpty())
        {

            Vertex v = pq.poll();
            int minVertex = v.no;
            if(visited[minVertex])
                continue;

            visited[minVertex] = true;

            Iterator<Vertex> iterator = graph.get(minVertex).listIterator();
            while(iterator.hasNext())
            {
                Vertex to = iterator.next();

                if(!visited[to.no] && distance[to.no] > to.weight + distance[minVertex])
                {
                    distance[to.no] = to.weight + distance[minVertex];
                    pq.offer(new Vertex(to.no, distance[to.no]));
                }
            }
        }
    }
}
