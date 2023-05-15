package dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1938_통나무_옮기기 {
    static int N;
    static char[][] map;
    static boolean[][][] visited; //i,j,dir
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    static class Pos {
        int i;
        int j;
        int dir;

        public Pos(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    static Pos[] bArr = new Pos[3];
    static Pos[] eArr = new Pos[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //step1 : 입력받기
        N = scanner.nextInt();

        map = new char[N][N];
        visited = new boolean[N][N][2];
        int b_idx = 0;
        int e_idx = 0;
        for (int i = 0; i < N; i++) {
            String temp = scanner.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp.charAt(j);

                //출발지, 도착지 백업
                if (map[i][j] == 'B')
                    bArr[b_idx++] = new Pos(i, j, 0);
                else if (map[i][j] == 'E')
                    eArr[e_idx++] = new Pos(i, j, 0);
            }
        }

        //출발지 통나무가 가로인지 세로인지 체킹하기
        // 0 : 가로, 1 : 세로
        int start_dir = 0;
        if (bArr[0].i + 1 == bArr[1].i)
            start_dir = 1;

        //System.out.println(start_dir);
        //step2 : bfs 시행
        bfs(new Pos(bArr[1].i, bArr[1].j, start_dir));
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(pos);
        visited[pos.i][pos.j][pos.dir] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            time++;
            while (qSize-- > 0) {
                pos = queue.poll();
                //현재 노드가 도착지라면 출력하고 끝내버리기
                if (pos.i == eArr[1].i && pos.j == eArr[1].j) {
                    if (pos.dir == 0 && pos.j - 1 == eArr[0].j && pos.j + 1 == eArr[2].j) {
                        System.out.println(time - 1);
                        System.exit(0);
                    } else if (pos.dir == 1 && pos.i - 1 == eArr[0].i && pos.i + 1 == eArr[2].i) {
                        System.out.println(time - 1);
                        System.exit(0);
                    }
                }
                //4방향으로 가는 경우
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if (checkRange(ni, nj, pos.dir) && !visited[ni][nj][pos.dir]) {
                        visited[ni][nj][pos.dir] = true;
                        queue.add(new Pos(ni, nj, pos.dir));
                    }
                }

                //회전해서 가는 경우
                int ndir = pos.dir == 0 ? 1 : 0;
                if (checkRotate(pos.i, pos.j, ndir) && !visited[pos.i][pos.j][ndir]) {
                    visited[pos.i][pos.j][ndir] = true;
                    queue.add(new Pos(pos.i, pos.j, ndir));
                }

            }
        }
        System.out.println(0);
    }

    private static boolean checkRotate(int i, int j, int dir) {
        for (int r = i - 1; r <= i + 1; r++) {
            for (int c = j - 1; c <= j + 1; c++)
            {
                if (r < 0 || c < 0 || r >= N || c >= N)
                    return false;
                if (map[r][c] == '1')
                    return false;
            }
        }
        return true;
    }

    private static boolean checkRange(int i, int j, int dir) {
        int[] wood_side = {-1, 1};

        // 현재 위치가 범위 밖이거나 통나무면 false
        if (i < 0 || j < 0 || i >= N || j >= N)
            return false;
        if (map[i][j] == '1')
            return false;

        //통나무 중심의 양쪽 범위 및 통나무 체크
        if (dir == 0) { //가로인 경우
            for (int d = 0; d < 2; d++) {
                int nj = j + wood_side[d];
                if (nj < 0 || nj >= N)
                    return false;
                if (map[i][nj] == '1')
                    return false;
            }
        } else { // 세로인 경우
            for (int d = 0; d < 2; d++) {
                int ni = i + wood_side[d];
                if (ni < 0 || ni >= N)
                    return false;
                if (map[ni][j] == '1')
                    return false;
            }
        }

        return true;
    }
}
