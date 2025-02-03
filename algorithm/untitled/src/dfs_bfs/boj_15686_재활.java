package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686_재활 {
    static int[][] map;
    static boolean[] visited;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static List<Pos> chickenArr = new ArrayList<>();
    static int chickenSize;
    static List<Pos> houseArr = new ArrayList<>();
    static int[] picked;
    static int N, M;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        picked = new int[M];

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    chickenArr.add(new Pos(i, j));
                } else if (map[i][j] == 1) {
                    houseArr.add(new Pos(i, j));
                }
            }
        }

        chickenSize = chickenArr.size();

        //dfs
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == M) {
            int sum = 0;
            for (int i = 0; i < houseArr.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int distance = Math.abs(houseArr.get(i).i - chickenArr.get(picked[j]).i)
                        + Math.abs(houseArr.get(i).j - chickenArr.get(picked[j]).j);
                    min = Math.min(min, distance);
                }
                sum += min;
            }

            result = Math.min(sum, result);
            return;
        }

        for (int i = idx; i < chickenSize; i++) {
            picked[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }
}

/*
크기가 n * n인 도시가 있다.
도시의 각 칸은 빈 칸, 치킨집, 집 중 하나임
치킨 거리는 집과 가장 가까운 치킨집 사이의 거리임.
도시의 치킨거리는 모든 집의 치킨거리의 합임
 */

/*
step 1 입력
- 2의 위치는 따로 저장하기

step 2 : dfs
최대 M개를 뽑음
병신아 어케뽑을건데 ㅋㅋㅋㅋ
하나 뽑을 때마다 치킨거리 연산하기
최저값? -> 갱신
 */