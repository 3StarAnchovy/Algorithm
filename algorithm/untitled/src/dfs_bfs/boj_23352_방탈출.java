package dfs_bfs;

import java.util.*;

public class boj_23352_방탈출 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int[] max_list;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        //step1 : 입력
        map = new int[N][M];
        visited = new boolean[N][M];
        max_list = new int[N * N + 1];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                map[i][j] = scanner.nextInt();

        //step2 : 모든 방 출발점으로 bfs 시행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs(new Pos(i, j)); // i, j, start
                visited = new boolean[N][M];
            }
        }

        int find_idx = 1;
        for(int i = N * N; i > 0; i --)
        {
            if(max_list[i] != 0)
                find_idx = i;
        }

        System.out.println(max_list[find_idx]);
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();
        Pos next = null;
        //bfs 시행하기
        visited[pos.i][pos.j] = true;
        queue.add(pos);
        int time = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            time++;
            while (qSize-- > 0) {
                next = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (map[ni][nj] != 0) {
                            visited[ni][nj] = true;
                            queue.add(new Pos(ni, nj));
                        } else if (ni == pos.i && nj == pos.j) {
                            visited[ni][nj] = true;
                            queue.add(new Pos(ni, nj));
                        }
                    }
                }
            }
        }
        //bfs가 다 끝났을떄, 최단경로로 이동한 가장 긴 경로를 알 수 있음. pos ~ next
        //시작과 끝 합 구하기
        int sum = map[pos.i][pos.j] + map[next.i][next.j];

        //최대값 갱신하기
        max_list[time] = Math.max(max_list[time], sum);

    }
}
