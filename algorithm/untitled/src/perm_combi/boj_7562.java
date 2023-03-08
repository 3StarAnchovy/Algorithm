package perm_combi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
접근1.
bfs

1. 나이트가 이동할 수 있는 상태도 그림
2. 상태도대로 bfs 탐색하다가 지금있는 칸이 도착지이다? -> cnt 출력
 */
public class boj_7562 {
    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int N;
    static int to_i;
    static int to_j;
    static boolean[][] visited;
    static int[] delta_i = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] delta_j = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 0; tc < TC; tc++) {
            N = scanner.nextInt();
            int from_i = scanner.nextInt();
            int from_j = scanner.nextInt();

            to_i = scanner.nextInt();
            to_j = scanner.nextInt();
            visited = new boolean[N][N];
            bfs(new Pos(from_i, from_j));
        }
    }

    private static void bfs(Pos start) {
        Queue<Pos> queue = new LinkedList<>();

        visited[start.i][start.j] = true;
        queue.add(start);

        int cnt = 0;
        A : while (!queue.isEmpty()) {
            cnt++;
            int q_size = queue.size();

            while (q_size-- > 0) {
                start = queue.poll();
                if(start.i == to_i && start.j == to_j)
                    break A;
                for(int d = 0; d < 8; d ++)
                {
                    int ni = start.i + delta_i[d];
                    int nj = start.j + delta_j[d];
                    if(0 <= ni && ni < N && 0 <= nj && nj < N)
                    {
                        if(!visited[ni][nj])
                        {
                            queue.add(new Pos(ni,nj));
                            visited[ni][nj] = true;
                        }
                    }
                }
            }
        }
        System.out.println(cnt - 1);
    }
}
