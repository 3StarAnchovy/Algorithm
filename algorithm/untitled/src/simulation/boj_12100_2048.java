package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_12100_2048 {
    static int[] delta_i = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] delta_j = {0, 0, -1, 1};
    static Pos[][] map;
    static int N;
    static int max = 0;
    static int[] order;

    static class Pos {
        int value;
        boolean visited;

        public Pos(int value, boolean visited) {
            this.value = value;
            this.visited = visited;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Pos[N][N];
        order = new int[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = new Pos(Integer.parseInt(st.nextToken()), false);
            }
        }

        bactracking(0);
        System.out.println(max);
    }

    private static void mixBlock() {
        //카피 따기
        Pos[][] copy = new Pos[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = new Pos(map[i][j].value, false);
            }
        }

        // 블럭 합치기
        for (int o = 0; o < 5; o++) {
            int d = order[o];

            //한번의 이동때마다 합쳐진거 초기화 하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    copy[i][j].visited = false;
            }

            // 상, 좌 처음부터 시작
            if (d == 0 || d == 2) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        move(i, j, d, copy);
                    }
                }
            }
            // 하 우 끝부터 시작
            else if (d == 1 || d == 3) {
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = N - 1; j >= 0; j--) {
                        move(i, j, d, copy);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(copy[i][j].value, max);
            }
        }

    }

    private static void move(int i, int j, int d, Pos[][] copy) {
        int ti = i; //현재
        int tj = j;
        int ni = i + delta_i[d]; // 다음
        int nj = j + delta_j[d];

        while (0 <= ni && ni < N && 0 <= nj && nj < N) {
            if (copy[ni][nj].value == 0) { //다음 블록이 0이면 계속 올라가야함.
                copy[ni][nj].value = copy[ti][tj].value;
                copy[ni][nj].visited = copy[ti][tj].visited;
                copy[ti][tj].value = 0;
                copy[ti][tj].visited = false;
            } else if (copy[ti][tj].value == copy[ni][nj].value && !copy[ni][nj].visited && !copy[ti][tj].visited) {
                copy[ni][nj].value *= 2;
                copy[ni][nj].visited = true;
                copy[ti][tj].value = 0;
                copy[ti][tj].visited = false;
            } else {
                break;
            }

            ti = ni;
            tj = nj;
            ni += delta_i[d];
            nj += delta_j[d];
        }
    }

    private static void bactracking(int cnt) {
        if (cnt == 5) {// 총 다섯번
            mixBlock();
            return;
        }

        //상하좌우로 싹다 돌리기

        for (int i = 0; i < 4; i++) {
            order[cnt] = i;
            bactracking(cnt + 1);
        }
    }

}

/*
한번의 이동은 전체 블록을 상하좌우 네 방향 중 하나로 이동 시킴
같은 값이라면 두 블록은 하나로 합쳐짐.
"한 번의 이동에서 이미 합쳐진 블록은 또다른 블록과 합쳐질 수 없다."
"예를 들어 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼져 합쳐지게 된다."
백트래킹,,

최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.

백트래킹 (cnt == 5)
기저 조건에서 합치기 구현
    합치기
    00 ~ nn까지 주어진 방향으로 값이 같고, 합쳐지지 않은 블록이라면 합치기.

 */
