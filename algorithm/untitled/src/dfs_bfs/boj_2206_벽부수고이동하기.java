package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_벽부수고이동하기 {
    static class Pos {
        int k, i, j;

        public Pos(int k, int i, int j) {
            this.k = k;
            this.i = i;
            this.j = j;
        }
    }

    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(0,0,0));
        visited[0][0][0] = true;
        //visited[1][0][0] = true;

        int time = 0;
        while(!que.isEmpty()) {
            int qSize = que.size();
            time ++;
            while(qSize -- > 0) {
                Pos pos = que.poll();
                if(pos.i == N -1 && pos.j == M - 1) {
                    System.out.println(time);
                    return;
                }

                //벽 부실때
                if(pos.k < 1) {
                    for(int d = 0; d < 4; d ++) {
                        int ni = pos.i + delta_i[d];
                        int nj = pos.j + delta_j[d];
                        int nk = pos.k + 1;

                        if(0 <= ni && ni < N && 0 <= nj&& nj < M) {
                            if(!visited[nk][ni][nj] && map[ni][nj] == 1) {
                                visited[nk][ni][nj] = true;
                                que.add(new Pos(nk,ni,nj));
                            }
                        }
                    }
                }

                //벽 안부셨을떄
                for(int d = 0; d < 4; d ++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    int nk = pos.k;

                    if(0 <= ni && ni < N && 0 <= nj&& nj < M) {
                        if(!visited[nk][ni][nj] && map[ni][nj] == 0) {
                            visited[nk][ni][nj] = true;
                            que.add(new Pos(nk,ni,nj));
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

/*
1,1에서 n,m 위치까지 이동, 최단경로

벽은 한번까지 부술수있음
 */