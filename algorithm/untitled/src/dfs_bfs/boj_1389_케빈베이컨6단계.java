package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1389_케빈베이컨6단계 {
    private static int N, M;
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int sum = bfs(i);
            if(sum < min){
                min = sum;
                result = i;
            }
        }
        System.out.println(result);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        int depth = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            depth++;
            while (qSize-- > 0) {
                int v = queue.poll();
                for (int a : graph.get(v)) {
                    if (!visited[a]) {
                        visited[a] = true;
                        queue.add(a);
                        sum += depth;
                    }
                }
            }
        }
        //System.out.println(sum + " sum " + start);

        return sum;
    }
}
