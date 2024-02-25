package dfs_bfs;

import java.util.*;

class pro_미로탈출 {
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M; // 가로 세로

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(String[] maps) {
        //step 0 입력받기
        M = maps[0].length(); // 가로
        N = maps.length; // 세로

        int first = 0;
        int second = 0;

        //step 1 출발점에서 레버로 bfs 돌리기, 이떄 이동 조건은 'X'가 아닐때
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'S') {
                    first = bfs(i, j, 'L', maps);
                }
            }
        }

        if (first == -1) {
            return -1;
        }

        //step 2 레버에서 exit로 bfs 돌리기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'L') {
                    second = bfs(i, j, 'E', maps);
                }
            }
        }
        if (second == -1) {
            return -1;
        }

        return first + second;
    }

    public static int bfs(int i, int j, char dest, String[] maps) {
        Queue<Pos> que = new ArrayDeque<>();
        visited = new boolean[N][M];

        que.add(new Pos(i, j));
        visited[i][j] = true;
        int movCnt = 0;

        while (!que.isEmpty()) {
            int qSize = que.size();
            movCnt++;
            while (qSize-- > 0) {
                Pos pos = que.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (maps[ni].charAt(nj) != 'X') {
                            if (maps[ni].charAt(nj) == dest) {
                                return movCnt;
                            }
                            que.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

}