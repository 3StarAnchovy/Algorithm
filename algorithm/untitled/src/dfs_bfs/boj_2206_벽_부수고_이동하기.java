package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_2206_벽_부수고_이동하기 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    static class Pos {
        int i;
        int j;
        int wall_cnt;

        public Pos(int i, int j, int wall_cnt) {
            this.i = i;
            this.j = j;
            this.wall_cnt = wall_cnt;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M][2];

        // step1 : 입력받기
        for (int i = 0; i < N; i++)
        {
            String temp = scanner.next();
            for (int j = 0; j < M; j++)
                map[i][j] = temp.charAt(j);
        }

        // step 2 : bfs 시행
        bfs(new Pos(0, 0, 0));
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(pos);
        visited[pos.i][pos.j][0] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            time++;
            while (qSize-- > 0) {
                pos = queue.poll();
                //현재 위치가 도착지일때
                if(pos.i == N - 1 && pos.j == M - 1)
                {
                    System.out.println(time);
                    System.exit(0);
                }

                //이동하기
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj][pos.wall_cnt]) {
                        if(map[ni][nj] == '0')
                        {
                            queue.add(new Pos(ni,nj, pos.wall_cnt));
                            visited[ni][nj][pos.wall_cnt] = true;
                        }
                        else if(map[ni][nj] == '1' && pos.wall_cnt == 0)
                        { // 다음 노드가 벽인데, 벽을 한번도 부수지 않았다면
                            queue.add(new Pos(ni,nj, 1));
                            visited[ni][nj][1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
