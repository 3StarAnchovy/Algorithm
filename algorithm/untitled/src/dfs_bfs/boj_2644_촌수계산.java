package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2644_촌수계산 {
    static int N, M;
    static int start, end;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> que = new ArrayDeque<>();
        visited[start] = true;
        que.add(start);

        int result = -1;
        while (!que.isEmpty()) {
            int qSize = que.size();
            result ++;
            while (qSize -- > 0) {
                int num = que.poll();

                if(num == end) {
                    return result;
                }

                for(int n : arr.get(num)) {
                    if(!visited[n]) {
                        que.add(n);
                        visited[n] = true;
                    }
                }
            }
        }

        return -1;
    }
}
