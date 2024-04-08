package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149_RGB거리 {
    static int N;
    static int[] red;
    static int[] blue;
    static int[] green;
    static int[][] memo; //

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        red = new int[N + 1];
        blue = new int[N + 1];
        green = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N + 1][3]; // 0 red 1 green 2 blue
        memo[1][0] = red[1];
        memo[1][1] = green[1];
        memo[2][2] = blue[1];

        for(int i = 1; i <= N; i ++){
            memo[i][0] = Math.min(memo[i - 1][1], memo[i - 1][2]) + red[i];
            memo[i][1] = Math.min(memo[i - 1][0], memo[i - 1][2]) + green[i];
            memo[i][2] = Math.min(memo[i - 1][0], memo[i - 1][1]) + blue[i];
        }

        int min = Math.min(memo[N][0], memo[N][1]);
        min = Math.min(memo[N][2], min);
        System.out.println(min);
    }
}

/*
rgb거리에는 집이 N개 있다. 거리는 선분으로 나타낼수 있고, 1번 집부터 N집이 순서대로 있다. (1base)

집은 빨강 초록 파랑 중 하나의 색으로 칠해야한다. 각각 비용이 주어졌을때, 모든집을 칠하는 최소비용을 구해보자

1번 집의 색은 2번 집의 색과 같지 않아야한다.
n번 집의 색은 n-1번 집의 색과 같지 않아야한다.
i번 집의 색은 i-1번, i +1번 집의 색과 같지 않아야한다.
 */

/*
백트래킹? 3^1000 오바임
 */

/*
테이블 정의하기
memo[i][j] = i가 무조건 j일때(빨,초,파), i까지의 최소비용
점화식 짜기
memo[i][1] = min(memo[i-1][2], memo[i-1][3]) + red[i];
초기값 박기
memo[0][1] = 각 시작 색
memo[1][1] = 나머지중 작은거
 */