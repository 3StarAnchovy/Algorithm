package samsung_a_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 - 각 벌통에 있는 꿀의 양이 주어졌을 때, 벌꿀을 채휘하여 최대한 많은 수익 얻으려함
 */

/*
접근
조합으로 하려함, visted를 곁들인

step1
    조합으로 벌통 선택
    벌통 N * N 완전탐색 시행
        벌통을 연속해서 픽할수 없으면? -> 거름
        벌통이 이전에 선택된적이 있다면? -> 거름

step2
    기저조건 찍히면 이익 계산 -> 최대값이면 갱신
    유효한 벌통 조합들이 picked에 저장되어있다.
    해당 picked를 행 단위로 부분집합을 이용하여, 각 행의 최대 이익을 구하여 다 더해보자
 */
public class swea_2115_벌꿀채취 {
    static int N, M, C; // n : 벌통 크기, M : 선택할 수 있는 벌통 개수, c : 꿀을 채취할 수 있는 최대 양
    static boolean[] visited;
    static int[][] map;
    static int[][] picked;
    static int maxRevenue;

    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            //visited = new boolean[N * N];
            picked = new int[2][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxRevenue = 0;
            combi(0, 0); // cnt, start
            sb.append("#").append(tc).append(' ').append(maxRevenue).append('\n');
            //System.out.println("#" + tc + " " + maxRevenue);
        }

        System.out.println(sb);
    }

    private static void combi(int cnt, int start) {
        if (cnt == 2) //벌꿀 인원 두명이니까!
        {
            //첫번째 픽 계산
            //honey, cnt, sum, revenue
            subset1(picked[0], 0, 0, 0);
            return;
        }

        for (int i = start; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            if (c > N - M)
                continue;

            for (int j = 0; j < M; j++) {
                picked[cnt][j] = map[r][c + j];
            }
            combi(cnt + 1, i + M);
        }
    }

    private static void subset1(int[] honey, int cnt, int sum, int revenue) {
        if (sum > C)
            return;

        if (cnt == M) {
            subset2(picked[1], 0, 0, revenue);
            return;
        }

        //cnt 번째 선택
        subset1(honey, cnt + 1, sum + honey[cnt], revenue + honey[cnt] * honey[cnt]);
        //cnt 번째 비선택
        subset1(honey, cnt + 1, sum, revenue);
    }

    private static void subset2(int[] honey, int cnt, int sum, int revenue) {
        if (sum > C)
            return;

        if (cnt == M) {
            maxRevenue = Math.max(maxRevenue, revenue);
            return;
        }
        //cnt 번째 선택
        subset2(honey, cnt + 1, sum + honey[cnt], revenue + honey[cnt] * honey[cnt]);
        //cnt 번째 비선택
        subset2(honey, cnt + 1, sum, revenue);
    }
}
