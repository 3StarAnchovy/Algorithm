package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569_재활 {
    static int M,N,H;
    static int[] delta_i = {-1,1,0,0,0,0}; //상하좌우앞뒤
    static int[] delta_j = {0,0,-1,1,0,0};
    static int[] delta_k = {0,0,0,0,-1,1};
    static int[][][] arr;
    static ArrayDeque<Pos> que = new ArrayDeque<>();
    static class Pos {
        int i,j,k;
        public Pos(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    static boolean visited[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());


        visited = new boolean[H][N][M];
        arr = new int[H][N][M];

        for(int k = 0; k < H; k ++) {
            for(int i = 0; i < N; i ++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < M; j ++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if(arr[k][i][j] == 1) {
                        que.add(new Pos(i,j,k));
                        visited[k][i][j] = true;
                    }
                }
            }
        }

        A:
        for(int k = 0; k < H; k ++) {
            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < M; j ++) {
                    if(arr[k][i][j] == 0) {
                        bfs();
                        break A;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static void bfs() {
        int day = 0;
        while(!que.isEmpty()) {
            int qSize = que.size();
            day ++;
            while(qSize -- > 0) {
                Pos pos = que.poll();

                for(int d = 0; d < 6; d ++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    int nk = pos.k + delta_k[d];

                    if(0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nk && nk < H) {
                        if(!visited[nk][ni][nj] && arr[nk][ni][nj] == 0) {
                            visited[nk][ni][nj] = true;
                            arr[nk][ni][nj] = 1;
                            que.add(new Pos(ni,nj,nk));
                        }
                    }
                }
            }

            //다 익었는지 체크
            boolean flag = true;
            A:
            for(int k = 0; k < H; k ++) {
                for(int i = 0; i < N; i ++) {
                    for(int j = 0; j < M; j ++) {
                        if(arr[k][i][j] == 0) {
                            flag = false;
                            break A;
                        }
                    }
                }
            }

            //다 익었으면
            if(flag) {
                System.out.println(day);
                System.exit(0);
                return;
            }

        }
        System.out.println(-1);
        System.exit(0);
        //print();
    }

    private static void print() {
        System.out.println("print");
        for(int k = 0; k < H; k ++) {
            for(int i = 0; i < N; i ++) {
                for(int j = 0; j < M; j ++) {
                    System.out.print(arr[k][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

/*
보관 후 하루가 지나면, 익은토마토랑 인접한건 익게 됨
며칠이 지나야 다 익는지 알고싶어
 */