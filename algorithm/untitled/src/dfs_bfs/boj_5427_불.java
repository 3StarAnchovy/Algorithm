package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5427_불 {
    static int TC;
    static int W, H;
    static char[][] map;
    static boolean[][] visited;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] delta_i = {0, 0, -1, 1};
    static int[] delta_j = {-1, 1, 0, 0};

    static ArrayDeque<Pos> fireQue;
    static ArrayDeque<Pos> sangQue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc ++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            visited = new boolean[H][W];

            fireQue = new ArrayDeque<>();
            sangQue = new ArrayDeque<>();

            // 입력받기
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                for (int w = 0; w < W; w++) {
                    map[h][w] = input.charAt(w);

                    if (map[h][w] == '@') {
                        sangQue.add(new Pos(h, w));
                        visited[h][w] = true;
                    }

                    if (map[h][w] == '*') {
                        fireQue.add(new Pos(h, w));
                    }
                }
            }

            int result = bfs();
            sb.append(result == -1 ? "IMPOSSIBLE" : result).append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs() {
        int time = 0;
        while(!sangQue.isEmpty()) {
            time ++;
            //불 이동
            moveFire();
            //상근이 이동
            if(moveSang()) return time;
        }
        return -1;
    }

    private static boolean moveSang() {
        int sQsize = sangQue.size();

        while(sQsize -- > 0) {
            Pos pos = sangQue.poll();

            for(int d = 0 ; d < 4; d ++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];

                if(0 <= ni && ni < H && 0 <= nj && nj < W) {
                    if(!visited[ni][nj] && map[ni][nj] == '.') {
                        sangQue.add(new Pos(ni,nj));
                        map[ni][nj] = '@';
                        map[pos.i][pos.j] = '.';
                        visited[ni][nj] = true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static void moveFire() {
        int fQsize = fireQue.size();

        while(fQsize -- > 0) {
            Pos pos = fireQue.poll();

            for(int d = 0 ; d < 4; d ++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];

                if(0 <= ni && ni < H && 0 <= nj && nj < W) {
                    if(map[ni][nj] == '.' ) {
                        fireQue.add(new Pos(ni,nj));
                        map[ni][nj] = '*';
                    }
                }
            }
        }
    }
}

/*
불은 동서남북
벽에 불 x, 1초 걸림
 */