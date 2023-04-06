package dfs_bfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*문제해석
매 분마다 고슴도치는 인접한 네칸으로 이동할 수 있음, 물도 움직임
고슴도치는 물로 차 있는 구역으로 이동할 수 없고, 물도 비버의 소굴로 갈 수 없음
 */

/*접근
가중치 없는 최소거리 - bfs
물이 찰 예정인 칸으로 이동할 수 없다 -> 물 먼저 퍼트리고 너구리 움직이면 될 듯
map 탐색하다가 d 있으면 bfs 시작,

너구리 큐에 값이 없을때까지 ㅇㅇ
    레벨별
        물 퍼뜨리기
        너구리 움직이기
            너구리가 도착하면? 타임 출력
 */
public class boj_3055_탈출 {
    static char[][] map;
    static int R;
    static int C;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static boolean[][] visited;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static Pos raccoon_start;
    static Pos water_start;
    static Queue<Pos> raccoon_queue = new ArrayDeque<>();
    static Queue<Pos> water_queue = new ArrayDeque<>();
    static int time = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();
        map = new char[R][C];
        visited = new boolean[R][C];

        //init
        for (int i = 0; i < R; i++) {
            String temp = scanner.next(); // 너구리 위치, 물 위치 백업해줘야됨
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'S')
                    raccoon_start = new Pos(i, j);
                if (map[i][j] == '*')
                    water_queue.add(new Pos(i,j));
            }
        }

        action();
    }

    private static void action() {
        visited[raccoon_start.i][raccoon_start.j] = true;
        raccoon_queue.add(raccoon_start);

        while (!raccoon_queue.isEmpty()) {
            time ++;
            water(); // 물 먼저 띄우고
            raccoon();
        }
        //while 끝내고 여기까지 와버리면 답 없는거
        System.out.println("KAKTUS");
    }

    private static void raccoon() {
        int qSize = raccoon_queue.size();

        while(qSize -- > 0)
        {
            Pos current = raccoon_queue.poll();
            for(int d = 0; d < 4; d++)
            {
                int ni = current.i + delta_i[d];
                int nj = current.j + delta_j[d];
                if(0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj])
                {
                    if(map[ni][nj] == '.') {
                        visited[ni][nj] = true;
                        raccoon_queue.add(new Pos(ni, nj));
                    }
                    else if(map[ni][nj] == 'D')
                    {
                        System.out.println(time);
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void water() {
        int qSize = water_queue.size();

        while(qSize --  > 0)
        {
            Pos current = water_queue.poll();
            for(int d = 0; d < 4; d++)
            {
                int ni = current.i + delta_i[d] ;
                int nj = current.j + delta_j[d];
                if(0 <= ni && ni < R && 0 <= nj && nj < C && map[ni][nj] == '.')
                {
                    map[ni][nj] = '*';
                    water_queue.add(new Pos(ni,nj));
                }
            }
        }
    }
}
