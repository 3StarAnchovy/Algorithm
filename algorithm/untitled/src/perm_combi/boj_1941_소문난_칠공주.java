package perm_combi;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class boj_1941_소문난_칠공주 {
    static char[][] map;
    static int N = 5;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int seven_cnt = 0;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //step1 : 입력받기
        map = new char[5][5];

        for (int i = 0; i < N; i++) {
            String temp = scanner.next();
            for (int j = 0; j < N; j++)
                map[i][j] = temp.charAt(j);
        }

        // step2 : 조합으로 7명 추출
        combi(0, 0, 0); // cnt, start;
        System.out.println(seven_cnt);
    }

    private static void combi(int cnt, int start, int dasom_cnt) {
        if (cnt == 7) {
            if (dasom_cnt >= 4) { //다솜파 네명 이상이면 bfs 시행
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j] == 'O') {
                            bfs(new Pos(i, j));
                            return;
                        }
                    }
                }
            }

            return;
        }

        for (int i = start; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            //다솜인경우
            if (map[r][c] == 'S') {
                map[r][c] = 'O';
                combi(cnt + 1, i + 1, dasom_cnt + 1);
                map[r][c] = 'S';
            }
            //도연인 경우
            else if (map[r][c] == 'Y') {
                map[r][c] = 'O';
                combi(cnt + 1, i + 1, dasom_cnt);
                map[r][c] = 'Y';
            }
        }
    }
    private static void printArr(char map[][])
    {
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean [N][N];

        queue.add(pos);
        visited[pos.i][pos.j] = true;
        int cnt = 1;
        while(!queue.isEmpty())
        {
            pos = queue.poll();
            for(int d = 0; d < 4; d++)
            {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj])
                {
                    if(map[ni][nj] == 'O')
                    {
                        queue.add(new Pos(ni,nj));
                        visited[ni][nj] = true;
                        cnt ++;
                    }
                }
            }
        }

        if(cnt == 7)
            seven_cnt ++;
    }

}
