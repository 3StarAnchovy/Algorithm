package 끄적끄적;

/*
bfs 로 접근
공기와 인접해있는 치즈 -> 0으로 바꿔버리고 그 횟수만큼 cnt ++

step1.
(0,0)에서부터 탐색 시작 -> 외곽엔 치즈가 무조건 없으므로 여기부터 출발해서 인접한 치즈는 무조건 외곽임

step2.
사방탐색하다가 치즈를 만난다? 0으로 바꾸고 cnt ++
해당 cnt를 리스트에 저장

step3.
리스트에 마지막꺼 꺼내와서 출력하면 될듯
 */

import java.util.*;

public class boj_2636_치즈 {
    static int R;
    static int C;

    static int[][] map;
    static int[][] copy;
    static boolean[][] visited;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int time;
    static int total;
    static List<Integer> result = new ArrayList<Integer>();

    static class Pos{
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        R = scanner.nextInt();
        C = scanner.nextInt();

        map = new int[R][C];
        //copy = new int[R][C];

        for(int r = 0; r < R; r ++)
        {
            for(int c = 0; c < C; c ++)
            {
                map[r][c] = scanner.nextInt();
                if(map[r][c] == 1)
                    total ++;
            }
        }

        while(total != 0) {
            visited = new boolean[R][C];
            bfs(new Pos(0, 0));
        }

        //System.out.println("time : " + time);
        //System.out.println(Arrays.toString(result.toArray()));
        System.out.println(time);
        System.out.println(result.get(result.size() - 1));
    }

    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        time ++;
        visited[pos.i][pos.j] = true;
        queue.add(pos);
        int cnt = 0;
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            while(qSize -- > 0)
            {
                pos = queue.poll();
                for(int d = 0; d < 4; d ++)
                {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];
                    if(0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && map[ni][nj] == 0)
                    {
                        // 공기인 경우
                        visited[ni][nj] = true;
                        queue.add(new Pos(ni,nj));
                    }
                    else if(0<=ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && map[ni][nj] == 1)
                    {
                        // 치즈인 경우
                        // 큐에 넣으면 안됨
                        visited[ni][nj] = true;
                        cnt ++;
                        map[ni][nj] = 0;
                    }
                }
            }
        }
        result.add(cnt);
        total -= cnt;
        //System.out.println();
        //printMap();
    }

    public static void printMap()
    {
        for(int i = 0; i < R; i ++)
        {
            for(int j = 0; j < C; j ++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static void copyMap(int[][] origin)
    {
        ;
    }
}
