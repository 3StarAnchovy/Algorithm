package samsung_a_type;

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
    static boolean[][] visited;

    static class Pos{
        int i;
        int j;
        int honey;

        public Pos(int i, int j, int honey) {
            this.i = i;
            this.j = j;
            this.honey = honey;
        }
    }

    static Pos[] picked;
    static int[][] arr;
    static int[] arr_powerset;
    static boolean[] visited_powerset;
    static int honey_sum = 0;
    static int honey_max = 0;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            C = scanner.nextInt();

            arr = new int[N][N];
            visited = new boolean[N][N];
            picked = new Pos[2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            combi(0, 0, 0); //cnt, start
            System.out.println("#" + tc + " " + max);
            max = 0;
            honey_sum = 0;
            honey_max = 0;
        }


    }

    private static void combi(int cnt, int start_i, int start_j) {
        // 일꾼 두명 다 벌통 집었을때
        if (cnt == 2) {
            //printPicked();
            getProfit();
            return;
        }

        A:
        for (int i = start_i; i < N; i++) {
            int temp;
            if (start_i == i) {
                temp = start_j;
            } else {
                temp = 0;
            }
            for (int j = temp; j < N; j++) {
                /*
                벌통을 연속해서 픽할수 없으면? -> 거름
                벌통이 이전에 선택된적이 있다면? -> 거름
                 */
                if (N < j + M)
                    continue A;
                if (!visited[i][j]) {
                    for (int m = 0; m < M; m++)
                        visited[i][j + m] = true;
                    picked[cnt] = new Pos(i, j, arr[i][j]);
                    combi(cnt + 1, i, j);
                    for (int m = 0; m < M; m++)
                        visited[i][j + m] = false;
                }
            }
        }
    }

    private static void getProfit() {
        for(Pos e : picked)
        {
            arr_powerset = new int[M];
            visited_powerset = new boolean[M];

            for(int r = 0; r < M; r ++)
            {
                arr_powerset[r] = arr[e.i][e.j + r];
            }
            honey_sum = 0;
            honey_max = 0;
            powerset(0); // cnt

            max += honey_max;
        }

    }

    private static void powerset(int cnt) {
        if(cnt == M)
        {
            int sum = 0;
            for(int i = 0; i < M; i ++)
            {
                if(visited_powerset[i])
                    sum += arr_powerset[i];
                if(sum > M)
                    return;
            }

            for(int i = 0; i < M; i ++)
            {
                if(visited_powerset[i])
                    honey_sum += arr_powerset[i] * arr_powerset[i];
            }

            honey_max = Math.max(honey_max, honey_sum);
            return;
        }

        visited_powerset[cnt] = true;
        powerset(cnt + 1);
        visited_powerset[cnt] = false;
    }

    private static void printPicked() {
        for (Pos e : picked) {
            System.out.println(e.i + " " + e.j);

        }
        System.out.println("------");
    }
}
