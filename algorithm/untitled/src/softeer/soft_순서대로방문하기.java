package softeer;

import java.io.*;
import java.util.*;

/*
백 트래킹

step1 입력받기

step2 시작점부터 백트래킹 돌리기
기저조건 변수 == m && 현재 위치 == 마지막 목표위치
    카운팅 리턴하기


현재 위치 == 다음 목표위치
변수 늘려서 다음 딥스 넘어가기
else
걍 넘어가기
*/
public class soft_순서대로방문하기 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] delta_i = {-1, 1, 0, 0};
    private static int[] delta_j = {0, 0, -1, 1};

    private static class Des {
        int i, j;

        public Des(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    private static ArrayList<Des> des_arr = new ArrayList<>();
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            des_arr.add(new Des(i, j));
        }
        /*
        step2 시작점부터 백트래킹 돌리기
        기저조건 변수 == m && 현재 위치 == 마지막 목표위치
            카운팅 리턴하기


        현재 위치 == 다음 목표위치
        변수 늘려서 다음 딥스 넘어가기
        else
        걍 넘어가기
        */

        //현재 위치, 목표로 하는 위치
        visited[des_arr.get(0).i][des_arr.get(0).j] = true;
        back(des_arr.get(0).i, des_arr.get(0).j, 1);

        System.out.println(result);
    }

    private static void back(int i, int j, int des_idx) {
        if (des_idx == M && i == des_arr.get(M - 1).i && j == des_arr.get(M - 1).j) {
            result++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + delta_i[d];
            int nj = j + delta_j[d];

            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                if (map[ni][nj] == 0) {
                    if (ni == des_arr.get(des_idx).i && nj == des_arr.get(des_idx).j) {
                        visited[ni][nj] = true;
                        back(ni, nj, des_idx + 1);
                        visited[ni][nj] = false;
                    } else {
                        visited[ni][nj] = true;
                        back(ni, nj, des_idx);
                        visited[ni][nj] = false;
                    }
                }
            }
        }

    }
}
