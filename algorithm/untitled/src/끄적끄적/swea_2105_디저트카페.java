package 끄적끄적;

import java.util.Scanner;

public class swea_2105_디저트카페 {
    /*
    접근 1.
    1. 전체 탐색
    2. dfs 돌림
        꺾는 경우
        안꺾는 경우
        다음거 탐색할때, 이전에 방문했던 적이 있는 카페는 가면 안됨.
    3. 최대값 갱신
     */

    static int[][] map;
    static int N;
    static int max = -1;
    static int[] delta_i = {1, 1, -1, -1};
    static int[] delta_j = {1, -1, -1, 1};
    static boolean[] visited;

    static class Pos {
        int i;
        int j;
        int d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            visited = new boolean[101];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dfs(new Pos(i, j, 0), new Pos(i, j, 0), 0); // 현재 위치, 출발점, cnt
                }
            }

            System.out.println("#" + tc + " " + max);
            max = -1;
        }

    }

    private static void dfs(Pos current, Pos start, int cnt) {
        if (start.i == current.i && start.j == current.j && cnt > 1) {
            max = Math.max(cnt, max);
        }
        if (current.d == 4) {
            return;
        }

        if (current.d < 3) {
            //꺾는 경우
            int ni = current.i + delta_i[current.d + 1];
            int nj = current.j + delta_j[current.d + 1];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]]) {
                //방문체크
                visited[map[ni][nj]] = true;
                dfs(new Pos(ni, nj, current.d + 1), start, cnt + 1);
                visited[map[ni][nj]] = false;
                //Restore
            }
        }
        //안 꺾는 경우

        int ni = current.i + delta_i[current.d];
        int nj = current.j + delta_j[current.d];
        if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[map[ni][nj]]) {
            //방문체크
            visited[map[ni][nj]] = true;
            dfs(new Pos(ni, nj, current.d), start, cnt + 1);
            visited[map[ni][nj]] = false;
            //Restore
        }
    }
}
