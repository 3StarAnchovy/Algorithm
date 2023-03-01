package dfs_bfs;

import java.util.*;

public class swea_1238 {
    static int V; // 정점 수
    static int E; // 간선 수
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int t = 1; t <= 1; t++) {
            E = scanner.nextInt();
            int start = scanner.nextInt();
            isVisited = new boolean[101];
            graph = new ArrayList<>();
            for (int i = 0; i < 101; i++)
                graph.add(new ArrayList<Integer>());
            for (int i = 0; i < E / 2; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                graph.get(from).add(to);
            }

            for(int i = 1; i < 101; i ++)
                Collections.sort(graph.get(i));

            //pritEdge(graph);

            bfs(start);
        }
    }

    public static void pritEdge(ArrayList<ArrayList<Integer>> graph)
    {
        for(int i = 1; i < graph.size(); i ++)
        {
            ArrayList<Integer> node = graph.get(i);
            System.out.print("node" + "[" + i + "] : ");
            for(int j = 0; j < node.size(); j ++)
                System.out.print(node.get(j) + " -> ");
            System.out.println();
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> max_stack = new Stack<>();

        queue.add(start);
        isVisited[start] = true;

        while(queue.size() != 0)
        {
            int max = Integer.MIN_VALUE;
            int v = queue.poll();
            System.out.println(v);
            for (Integer integer : graph.get(v)) {
                v = integer;
                if (!isVisited[v]) {
                    queue.add(v);
                    isVisited[v] = true;
                    max = Math.max(max, v);
                }
            }
            max_stack.push(max);
        }
        System.out.println();
        for(int i = 0; i < max_stack.size(); i ++)
            System.out.print(max_stack.pop());
        System.out.println(max_stack.peek());
    }
}
