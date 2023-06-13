package samsung_a_type;

import java.util.*;

public class SWEA_사과게임 {
    static int N;
    static int[][] map;
    static int[] delta_i = {0, 1, 0, -1};//우하좌상
    static int[] delta_j = {1, 0, -1, 0};

    static class Apple implements Comparable<Apple> {
        int num; // 사과 넘버
        int i, j;

        public Apple(int num, int i, int j) {
            this.num = num;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Apple o) {
            return this.num - o.num;
        }
    }

    static class Pos {
        int i, j;
        int d;
        int d_cnt;

        public Pos(int i, int j, int d, int d_cnt) {
            this.i = i;
            this.j = j;
            this.d = d;
            this.d_cnt = d_cnt;
        }
    }

    static List<Apple> appleList;
    static int cur_d;
    static int rotate_cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            map = new int[N][N];
            appleList = new ArrayList<>();

            //step1 : 입력받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                    if (map[i][j] != 0)
                        appleList.add(new Apple(map[i][j], i, j));
                }
            }

            appleList.add(new Apple(0, 0, 0));
            Collections.sort(appleList);
            rotate_cnt = 0;
            cur_d = 0;

            //step2 : i번째부터 i + 1번째까지 bfs 탐색 시행
            for (int i = 0; i < appleList.size() - 1; i++) {
                Apple start = appleList.get(i);
                Apple target = appleList.get(i + 1);

                bfs(start, target);
            }
            System.out.println("#" + tc + " " + rotate_cnt);
        }
    }

    private static void bfs(Apple start, Apple target) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][N][4]; //i,j, 회전 횟수

        queue.add(new Pos(start.i, start.j, cur_d, 0));
        visited[start.i][start.j][cur_d] = true;

        while(!queue.isEmpty())
        {
            Pos cur = queue.poll();

            //현재위치랑 도착점이 같을때 ㅇㅇ
            if(cur.i == target.i && cur.j == target.j)
            {
                rotate_cnt += cur.d_cnt;
                cur_d = cur.d;
                return;
            }

            //그대로 갈때
            int ni = cur.i + delta_i[cur.d];
            int nj = cur.j + delta_j[cur.d];
            if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj][cur.d])
            {
                visited[ni][nj][cur.d] = true;
                queue.offer(new Pos(ni,nj,cur.d,cur.d_cnt));
            }

            //회전해서 갈때
            int nd = (cur.d + 1 + 4) % 4;
            ni = cur.i + delta_i[nd];
            nj = cur.j + delta_j[nd];
            if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj][nd])
            {
                visited[ni][nj][nd] = true;
                queue.offer(new Pos(ni,nj,nd,cur.d_cnt + 1));
            }
        }
    }
}
