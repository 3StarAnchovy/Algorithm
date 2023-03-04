package samsung_a_type;

/*
1. 구슬 떨어뜨리기 : 중복순열 (재귀 순열)
2. 구슬이 떨어지는 첫 벽돌 찾기
3. 첫 벽돌 기준 4방(cnt - 1 ) 연쇄적으로 boom
4. 벽돌 내리기
5. 1~4 구슬 횟수만큼 반복
 */

/*
구현 문제 풀 때 출력용 메소드 하나 기가막히게..
단계별 처리 결과 확인
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class swea_5656 {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int N, H, W, min;

    private static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            W = scanner.nextInt();
            H = scanner.nextInt();
            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++)
                    map[r][c] = scanner.nextInt();
            }

            min = Integer.MAX_VALUE;

            System.out.println("#" + tc + " " + min);
        }

    }

    // 구슬 던지기
    private static boolean go(int count, int[][] map) // 구슬이 던져진 횟수
    {
        int[][] newMap = new int[H][W];
        int result = getRemain(map);

        if (result == 0) {
            min = 0;
            return true;
        }

        if (count == N) {
            if (min > result)
                min = result;
            return false;
        }

        //던지기 전에 벽돌 남아있는거 확인 -> 벽돌 x -> return;
        //모든 열에 구슬 던져보기
        for (int c = 0; c < W; c++) // c :  구슬을 던지는 열
        {
            // 구슬에 처음 맞는 벽돌 찾기 (위쪽에서)
            int r = 0;
            while (r < H && map[r][c] == 0)
                r++;

            if (r == H) // 맞는 벽돌이 없으면 다음 열에 던져보기
                continue;

            // 배열 원본의 상태로 초기화
            copy(map, newMap);

            boom(newMap, r, c);

            down(newMap);

            if (go(count + 1, newMap))
                return true;
        }

        return false;
    }

    private static Stack<Integer> stack = new Stack<>();

    private static void down(int[][] map) {
        // 맨 아래행 부터 위쪽 들여다 보며 빈칸 만날때마다 내려놓을 벽돌 찾기 -> arr
        // 맨 위부터 각 열에 대해 윗 행부터 아래행까지 벽돌만 스택에 넣어두고 빼서 아래 행 부터 채우기
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < H; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }
            int r = H - 1;
            while (!stack.isEmpty()) {
                map[r--][c] = stack.pop();
            }
        }
    }

    //bfs
    private static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();

        if (map[r][c] > 1) {
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0;

        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            // 현 벽돌의 cnt - 1만큼 4방을 체크
            for (int d = 0; d < 4; d++) {
                int nr = current.r;
                int nc = current.c;
                for (int k = 1; k <= current.cnt - 1; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (0 <= nr && nr < H && 0 <= nc && nc < W && map[nr][nc] > 0) {
                        if (map[nr][nc] > 1)
                            queue.offer(new Point(nr, nc, map[nr][nc]));
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }

    private static int getRemain(int[][] map) {
        int cnt = 0;

        for (int r = 0; r < H; r++)
            for (int c = 0; c < W; c++)
                if (map[r][c] > 0)
                    cnt++;

        return cnt;
    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++)
            for (int c = 0; c < W; c++)
                newMap[r][c] = map[r][c];
    }
}
