package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260_dfs와bfs_재활 {
    private static int N, M, V;
    private static ArrayList<ArrayList<Integer>> arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr.get(i));
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int a : arr.get(start)) {
            if (!visited[a]) {
                dfs(a);
            }
        }
    }

    private static void bfs(int start) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        sb.append(start).append(' ');

        queue.add(start);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                int v = queue.poll();

                for (int a : arr.get(v)) {
                    if (!visited[a]) {
                        visited[a] = true;
                        queue.add(a);
                        sb.append(a).append(' ');
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
