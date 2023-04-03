package samsung_a_type;

import java.util.*;

/*
문제 해석
가로 N * 세로 N //
공간안에서 도착지까지 가장 빠른길 찾으면 됨
섬, 소용돌이 장애물
소용돌이 2초동안 유지되다가 1초동안 잠잠해짐
한번 통과한 소용돌이 위에서는 머물러 있을 수 있다.
 */


/*
소용돌이 위치 백업
최저거리이므로 bfs 돌림
레벨별로 접근. 한번 돌릴때마다 time ++
time + 2 될 때마다 소용돌이 없앰
그 상태에서 ++ 되면 소용돌이 다시 생김
도착지 도착 할때 타임 출력
 */
public class swea_4193 {
    static int N;
    static int[][] map;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static Pos start;
    static Pos end;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            visited = new boolean[N][N];
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
            start = new Pos(scanner.nextInt(), scanner.nextInt());
            end = new Pos(scanner.nextInt(), scanner.nextInt());

            int result = bfs(start, end); //start,
            System.out.println("#" + tc + " " + (result + 1));
        }
    }

    private static int bfs(Pos start, Pos end) {
        Queue<Pos> queue = new LinkedList<>();

        queue.add(start);
        visited[start.i][start.j] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                start = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int ni = start.i + delta_i[d];
                    int nj = start.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                        // 도착지 도착하면 종료
                        if (ni == end.i && nj == end.j) return time;
                        // 다음 방향이 섬도아니고 소용돌이도 아닐 때
                        if (map[ni][nj] == 0) {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }
                        // 다음 방향이 소용돌이 일 때, 소용돌이 있으면 기다려야됨 -> 자기 자리 큐 추가
                        // 소용돌이 없으면 가도 됨
                        else if (map[ni][nj] == 2) {
                            // 소용돌이 못들어가는 경우
                            if (time < 2 || (time - 2) % 3 != 0) queue.add(start);
                            //소용돌이 들어가는 경우
                            else {
                                queue.add(new Pos(ni, nj));
                                visited[ni][nj] = true;
                            }
                        }
                    }
                }
            }
            time++;
        }

        //도착 할 수 없는 경우 -1 출력
        return -2;
    }

}
