package samsung_a_type;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
문제 해석
운영 비용 = K * K + (K - 1) * (K - 1)
보안회사의 이익 = 서비스 제공받는 집들을 통해 얻는 수익(서비스 영역 내 집 개수 * 집마다 내는 요금 - 운영비용)
보안회사가 손해를 보지않고(보안회사의 이익 >= 0) 서비스 가능한 최대 집의 수를 구하는 문제
 */
/*
접근
bfs
배열 전체 탐색 중 집을 발견하면 bfs 시작

    보안회사가 손해를 보지 않고 서비스 가능한 최대 집의 수
 */

public class swea_2117_홈방범서비스 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int house_max = 1;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    bfs(new Pos(i, j));
                }
            }

            System.out.println("#" + tc + " " + house_max);
            house_max = 1;
        }
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();

        visited[pos.i][pos.j] = true;
        queue.add(pos);
        int k = 1; // 맨처음엔 1
        int house_cnt = 0;
        if (map[pos.i][pos.j] == 1)
            house_cnt = 1;
        while (!queue.isEmpty()) {
            //이익 계산
            int profit = (house_cnt * M) - (k * k + (k - 1) * (k - 1));
            if (0 <= profit && house_max <= house_cnt) {
                house_max = house_cnt;
            }

            k++; // level
            int qSize = queue.size();
            while (qSize-- > 0) {
                pos = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                        if (map[ni][nj] == 1) {
                            house_cnt++;
                        }
                        queue.add(new Pos(ni, nj));
                        visited[ni][nj] = true;
                    }
                }
            }


        }
    }
}
