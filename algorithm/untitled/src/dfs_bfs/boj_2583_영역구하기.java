package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/*
step1 : 직사각형 그리기 -> 1로 채우기
    for(int i = 왼꼭 i; i < 오꼭-왼꼭; i ++)

step2 : 완탐하며 직사각형의 시작점에서 bfs 돌리기 (영역 cnt ++)

step3 : bfs 돌면서 poll 할때마다 카운터 세기 -> 최대값이면 값 갱신하기
 */
public class boj_2583_영역구하기 {
    static int M;
    static int N;
    static int K;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> result;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        result = new ArrayList<>();

        //input
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];

        //step1 : 직사각형 그리기 -> 1로 채우기
        //     for(int i = 왼꼭 i; i < 오꼭-왼꼭; i ++)
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int left_j = Integer.parseInt(st.nextToken());
            int left_i = Integer.parseInt(st.nextToken());
            int right_j = Integer.parseInt(st.nextToken());
            int right_i = Integer.parseInt(st.nextToken());

            for (int i = left_i; i < right_i; i++) {
                for (int j = left_j; j < right_j; j++) {
                    map[i][j] = 1;
                }
            }
        }

        int area_cnt = 0;
        int max_size = 0;
        // step2 : 완탐하며 직사각형의 시작점에서 bfs 돌리기 (영역 cnt ++)
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    area_cnt++;
                    result.add(bfs(i, j));
                }
            }
        }

        System.out.println(area_cnt);
        Collections.sort(result);
        for (int a : result) {
            System.out.print(a + " ");
        }

        //draw(map);
    }

    // step3 : bfs 돌면서 poll 할때마다 카운터 세기 -> 최대값이면 값 갱신하기
    private static int bfs(int i, int j) {
        Queue<Pos> queue = new ArrayDeque<>();
        visited[i][j] = true;

        queue.add(new Pos(i, j));

        int area = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();

            while (qSize-- > 0) {
                Pos pos = queue.poll();
                area++;

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < M && 0 <= nj && nj < N && !visited[ni][nj]) {
                        if (map[ni][nj] == 0) {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }
        return area;
    }

    private static void draw(int[][] map) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
