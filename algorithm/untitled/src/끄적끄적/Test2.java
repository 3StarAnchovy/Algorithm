package 끄적끄적;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            start = new Pos(scanner.nextInt(), scanner.nextInt());
            end = new Pos(scanner.nextInt(), scanner.nextInt());

            int time = bfs(start) + 1;
            System.out.println("#" + tc + " " + time);
        }
    }

    private static int bfs(Pos start) {
        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(start);
        visited[start.i][start.j] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pos cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = cur.i + delta_i[d];
                    int nj = cur.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                        //다음 행선지가 도착지인 경우
                        if (ni == end.i && nj == end.j)
                            return time;

                        //다음 행선지가 물인 경우
                        else if (map[ni][nj] == 0) {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                        }

                        //다음 행선지가 소용돌이인 경우
                        else if(map[ni][nj] == 2) {
                            if (time % 3 != 2) // 소용돌이가 있어서 갈수 없는 경우
                                queue.add(cur);
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

        return -2;
    }
}
