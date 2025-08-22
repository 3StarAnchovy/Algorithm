package perm_combi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940_쉬운최단거리 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] delta_i = {0, 0, -1, 1};
    static int[] delta_j = {-1, 1, 0, 0};

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        //입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //bfs
        A:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    bfs(new Pos(i, j));
                    break A;
                }
            }
        }

        //printArr();

        //방문 안한거 -1 덮어씌우기
        for(int i = 0; i < N; i ++) {
            for(int j= 0; j < M; j ++) {
                if(!visited[i][j] && arr[i][j] != 0)
                    arr[i][j] = -1;
            }
        }

        printArr();

    }

    private static void bfs(Pos start) {
        Queue<Pos> que = new ArrayDeque<>();
        visited[start.i][start.j] = true;
        que.add(start);

        int step = -1;
        while (!que.isEmpty()) {
            int qSize = que.size();
            step++;
            while (qSize-- > 0) {
                Pos pos = que.poll();
                arr[pos.i][pos.j] = step;

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (arr[ni][nj] != 0) {
                            visited[ni][nj] = true;
                            que.add(new Pos(ni, nj));
                        }
                    }
                }
            }
        }

    }

    private static void printArr() {
        StringBuilder sb = new StringBuilder();
        //System.out.println("---");
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    /*
    가로세로만 움직일수 있음
    bfs 그리면 될듯 ?
     */
}
