package dfs_bfs;


/*
접근
현재 위치로부터 버튼 누를때마다 움직이는 상태도 그림
최소값이므로 bfs 탐색하면서 목표층에 도달하면 Cnt 출력
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_5014 {
    static int F,S,G,U,D;
    static boolean[] visited;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        F = scanner.nextInt();
        S = scanner.nextInt();
        G = scanner.nextInt();
        U = scanner.nextInt();
        D = scanner.nextInt();

        visited = new boolean[F + 1]; // 1 base;
        visited[0] = true; //0층은 없는층이니까 그냥 트루 -> dummy

        bfs(S); //s층에서 스타트
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        int cnt = 0;

        while(!queue.isEmpty())
        {
            cnt ++;
            int q_size = queue.size();
            while(q_size -- > 0)
            {
                start = queue.poll();
                if(start == G)
                {
                    System.out.println(cnt - 1);
                    System.exit(0);
                }
                // 올라가는거
                if(1 <= start + U && start + U <= F && !visited[start + U]) {
                    queue.add(start + U);
                    visited[start + U] = true;
                }
                // 내려가는거
                if(1 <= start - D && start - D <= F && !visited[start - D]) {
                    queue.add(start - D);
                    visited[start - D] = true;
                }
            }
        }
        System.out.println("use the stairs");
    }
}
