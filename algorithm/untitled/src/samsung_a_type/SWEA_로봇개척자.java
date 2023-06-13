package samsung_a_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_로봇개척자 {
    static int N, M;

    static class Ground {
        int state; // 0, 1, 2, 3
        int K = 3;
        int day;

        void init() {
            state = 0;
            K = 3;
            day = 0;
        }
    }

    static Ground[][] map;
    static int[] delta_i = {0, -1, 0, 1}; //우앞좌뒤
    static int[] delta_j = {1, 0, -1, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new Ground[N][N];
            max = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer at = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(at.nextToken());
                    if (temp == 0)
                        map[i][j] = new Ground();
                }
            }

            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (map[i][j] == null) continue;
                    for (int d = 0; d < 4; d++) {
                        int cnt = go(i, j, d);
                        max = Math.max(max,cnt);
                        initGround();
                    }
                }
            }
            sb.append('#').append(tc).append(' ').append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static void initGround() {
        for(int i = 1; i < N - 1; i ++)
        {
            for(int j = 1; j < N -1 ; j ++)
            {
                if(map[i][j]== null) continue;
                map[i][j].init();
            }
        }
    }

    private static int go(int i, int j, int dir) {
        int cnt = 0;
        int ni = -1;
        int nj = -1;
        for (int day = 0; day < M; day++) {
            boolean isMove = false;
            //움직일수 있는지 체크
            for (int d = 0; d < 4; d++) {
                int tempDir = (dir + d) % 4;
                ni = i + delta_i[tempDir];
                nj = j + delta_j[tempDir];

                //움직일수 있는 경우 : 빈농지이고, 곡식이 열린 경우 산, 싹 x
                if (map[ni][nj] != null && map[ni][nj].state != 1 && map[ni][nj].state != 2) {
                    dir = (dir + d + 3) % 4;
                    isMove = true;
                    break;
                }
            }

            //낮
            if (map[i][j] != null && map[i][j].state == 0 && isMove) {
                map[i][j].state = 1;
            } else if (map[i][j] != null && map[i][j].state != 0 && !isMove) {

            } else if (map[i][j] != null && map[i][j].state == 3) {
                map[i][j].state = 0;
                cnt++;
            }
            //오후
            if (isMove) {
                i = ni;
                j = nj;
            }

            //씨앗 생장
            for (int r = 1; r < N - 1; r++) {
                for (int c = 1; c < N - 1; c++) {
                    if (map[r][c] == null) continue;

                    Ground g = map[r][c];

                    if (g.state == 1) {
                        g.state = 2;
                        g.K++;
                    } else if (g.state == 2) {
                        g.day++;
                        if (g.day == g.K) {
                            g.state = 3;
                            g.day = 0;
                        }
                    }
                }
            }
        }


        return cnt;
    }
}
