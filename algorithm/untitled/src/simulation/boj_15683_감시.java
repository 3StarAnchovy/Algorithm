package simulation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class boj_15683_감시 {
    static int N, M;
    static int[][] map;
    static int[][] copyArr;
    static int[] picked;
    static int cctv_size;
    static int[] delta_i = {-1, 0, 1, 0}; //상우하좌
    static int[] delta_j = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    static class Pos {
        int i, j;
        int cctv_num;

        public Pos(int i, int j, int cctv_num) {
            this.i = i;
            this.j = j;
            this.cctv_num = cctv_num;
        }
    }
    static ArrayList<Pos> cctv_list = new ArrayList<>();

    public static void main(String[] args) {
        //step1 : 입력받기
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        copyArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6)
                    cctv_list.add(new Pos(i, j, map[i][j]));
            }
        }
        cctv_size = cctv_list.size();
        picked = new int[cctv_size];

        perm(0);
        System.out.println(min);
    }

    private static void perm(int cnt) {
        if (cnt == cctv_size) {
            //배열 백업따기
            copyArray(map);

            //지정된 방향 기준으로 감시 따기
            for (int i = 0; i < cctv_size; i++)
                setDir(cctv_list.get(i), picked[i]);

            //감시 땄으면 개수 세고, 최소값 갱신
            getCount();
            return;
        }

        for (int i = 0; i < 4; i++) {
            //picked에 방향 담기, picked가 의미하는 것 : cctv의 방향 지정해주기 ㅇㅇ
            // 중복순열
            picked[cnt] = i;
            perm(cnt + 1);
        }
    }

    private static void getCount() {
        int cnt = 0;
        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j ++)
                if(copyArr[i][j] == 0)
                    cnt ++;

        min = Math.min(cnt, min);
    }

    private static void setDir(Pos cctv, int d) {
        if (cctv.cctv_num == 1) { //cctv가 1번일때는 상하좌우
            watch(cctv, d);
        } else if (cctv.cctv_num == 2) {
            if (d == 1 || d == 3) {
                watch(cctv, 1); //상 하 따야됨
                watch(cctv, 3);
            } else if (d == 0 || d == 2) //좌 우 따야됨
            {
                watch(cctv, 2);
                watch(cctv, 0);
            }
        } else if (cctv.cctv_num == 3) {
            if (d == 0) { //상우, 우하, 하좌, 좌상
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (d == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cctv.cctv_num == 4) {
            if (d == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 3);
            } else if (d == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 0);
            } else if (d == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
                watch(cctv, 1);
            } else if (d == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
                watch(cctv, 2);
            }
        } else {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    private static void watch(Pos cctv, int d) {
        Queue<Pos> queue = new ArrayDeque<>();
        //boolean[][] visited = new boolean[N][M];

        queue.add(cctv);
        //visited[cctv.i][cctv.j] = true;
        while (!queue.isEmpty()) {
            cctv = queue.poll();
            int ni = cctv.i + delta_i[d];
            int nj = cctv.j + delta_j[d];
            if (0 > ni || 0 > nj || N <= ni || M <= nj || map[ni][nj] == 6)
                break;
            if (map[ni][nj] == 0) {
                queue.add(new Pos(ni, nj, cctv.cctv_num));
                copyArr[ni][nj] = -1;
            } else {
                queue.add(new Pos(ni, nj, cctv.cctv_num));
            }
        }
    }


    private static void copyArray(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyArr[i][j] = map[i][j];
            }
        }
    }
}
