package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class boj_1941_소문난칠공주_재활 {
    static boolean[] dfsVisited;
    static char[][] map;
    static int result;
    static int[] delta_i = {0,0,-1,1};
    static int[] delta_j = {1,-1,0,0};
    private static class Pos { //bfs 좌표
        int i,j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        dfsVisited = new boolean[25];

        //입력
        for(int i = 0; i < 5; i ++) {
            String s = br.readLine();
            for(int j= 0; j < 5; j ++) {
                map[i][j] = s.charAt(j);
            }
        }

        //조합
        dfs(0,0,0);

        System.out.println(result);
    }

    private static boolean bfs(int idx) {
        int row = idx / 5;
        int col = idx % 5;
        Queue<Pos> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        //System.out.println(row);
        //System.out.println(col);
        visited[row][col] = true;
        que.add(new Pos(row,col));

        int cnt = 1;
        while(!que.isEmpty()) {
            int qSize = que.size();

            while(qSize -- > 0) {
                Pos pos = que.poll();

                for(int d = 0; d < 4; d ++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    int nidx = ni * 5 + nj;

                    if(0 <= ni && ni < 5 && 0 <= nj && nj < 5 && !visited[ni][nj]) {
                        if(dfsVisited[nidx]) {
                            cnt ++;
                            visited[ni][nj] = true;
                            que.add(new Pos(ni,nj));
                        }
                    }
                }
            }
        }

        return cnt == 7;
    }

    //vtx = row * 5 + col

    private static void dfs(int cnt, int idx, int yCnt) {
        if(yCnt == 4)
            return;

        if(cnt == 7) { // 조합 다 뽑았으면 bfs
            if(bfs(idx - 1)) {
                result ++;
            }
            return;
        }

        for(int i = idx; i < 25; i ++) {
            if(!dfsVisited[i]) {
                dfsVisited[i] = true;
                if(map[i / 5][i % 5] == 'Y') {
                    dfs(cnt + 1, i + 1, yCnt + 1);
                } else {
                    dfs(cnt + 1, i + 1, yCnt);
                }
                dfsVisited[i] = false;
            }
        }
    }
}

/*
25명 학생들로 이루어진 5 * 5 격자 형태

1. 7명의 학생들로 구성되어야함
2. 7명은 서로 인접해있어야함
3. 반드시 s로 이루어지진 않아도 되나, 4명이상은 s가 포함되어있어야함

 */

/*
step 1 : 입력
step 2 : 조합
step 3 : bfs
 */