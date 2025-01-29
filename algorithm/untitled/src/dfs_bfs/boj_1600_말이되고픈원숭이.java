package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600_말이되고픈원숭이 {
    static int K, W, H;
    static boolean[][][] visited;
    static int[][] arr;

    static class Pos {
        int i, j, k;

        public Pos(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    static int[] delta_i = {0, 0, -1, 1};
    static int[] delta_j = {-1, 1, 0, 0};
    static int[] horse_i = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horse_j = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited = new boolean[K + 1][H][W];
        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(0,0,0));
        visited[0][0][0] = true;
        int time = 0;

        while(!que.isEmpty()) {
            int qSize = que.size();

            time ++;
            while(qSize -- > 0) {
                Pos pos = que.poll();

                if(pos.i == H -1 && pos.j == W - 1) {
                    System.out.println(time -1);
                    return;
                }

                //말의 힘을 쓴 경우
                if(pos.k < K) {
                    for(int d=0; d < 8 ; d ++) {
                        int ni = pos.i + horse_i[d];
                        int nj = pos.j + horse_j[d];
                        int nk = pos.k + 1;
                        if(0 <= ni && ni < H && 0 <= nj && nj < W) {
                            if(!visited[nk][ni][nj] && arr[ni][nj] == 0) {
                                que.add(new Pos(ni,nj,nk));
                                visited[nk][ni][nj] = true;
                            }
                        }
                    }
                }

                //말의 힘을 쓰지 않는 경우
                for(int d=0; d < 4 ; d ++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    int nk = pos.k;
                    if(0 <= ni && ni < H && 0 <= nj && nj < W) {
                        if(!visited[nk][ni][nj] && arr[ni][nj] == 0) {
                            que.add(new Pos(ni,nj,nk));
                            visited[nk][ni][nj] = true;
                        }

                    }
                }
            }
        }

        System.out.println(-1);
    }
}

/*
최소 동작으로 시작지점에 갈 수 있는 방법
 */