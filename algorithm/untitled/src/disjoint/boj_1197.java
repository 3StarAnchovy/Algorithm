package disjoint;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1197 {
    static int V;
    static int E;
    static int[] arr;
    static Edge[] edgeList;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        V = scanner.nextInt();
        E = scanner.nextInt();

        arr = new int[V + 1];
        edgeList = new Edge[E];
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            edgeList[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeList); //nlogn
        makeSet();
        int cnt = 0;
        int sum = 0;
        for(Edge edge : edgeList)
        {
            if(union(edge.from, edge.to))
            {
                cnt ++;
                sum += edge.weight;

                if(cnt == V - 1) //정점이 v라면 최소스패닝트리의 간선은 v - 1
                {
                    System.out.println(sum);
                    System.exit(0);
                }
            }
        }
    }

    private static boolean union(int a, int b)
    {
        int rootA = findSet(a);
        int rootB = findSet(b);

        if(rootA == rootB)
            return false;

        arr[rootB] = rootA;
        return true;
    }

    private static int findSet(int a) {
        if(arr[a] == a)
            return a;
        return arr[a] = findSet(arr[a]);
    }

    private static void makeSet() {
        for (int i = 1; i <= V; i++)
            arr[i] = i;
    }
}
