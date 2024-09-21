package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_10451_순열사이클 {
    static int TC, N;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= N; i++) {
                list.get(i).add(Integer.valueOf(st.nextToken()));
            }

            //bfs
            visited = new boolean[N + 1];
            int sum = 0;
            for(int i = 1; i <= N; i ++){
                if(visited[i]) continue;
                sum ++;
                bfs(i);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);

    }
    private static void bfs(int v){
        visited[v] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);

        while (!queue.isEmpty()){
            int qSize = queue.size();

            while (qSize -- > 0){
                int pos = queue.poll();
                int nxt = list.get(pos).get(0);
                if(!visited[nxt]){
                    visited[nxt] = true;
                    queue.add(nxt);
                }
            }
        }
    }
}

/*
1부터 N까지 정수 N개로 이루어진 순열

매핑하고 bfs돌리기
 */