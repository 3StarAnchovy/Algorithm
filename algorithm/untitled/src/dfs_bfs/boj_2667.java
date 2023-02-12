package dfs_bfs;

import java.util.*;

class Position_2667
{
    private int i;
    private int j;

    public Position_2667(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

public class boj_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int danji_cnt = 0;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        map = new int [N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i ++)
        {
            String input = scanner.next();
            for(int j = 0; j < N; j ++)
            {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(!visited[i][j] && map[i][j] == 1) {
                    danji_cnt ++;
                    result.add(BFS(new Position_2667(i,j)));
                }
            }
        }

        System.out.println(danji_cnt);
        Collections.sort(result);
        for(int i = 0; i < result.size(); i ++)
            System.out.println(result.get(i));
    }

    private static int BFS(Position_2667 v)
    {
        int house_cnt = 1;
        Queue<Position_2667> queue = new LinkedList<>();
        queue.add(v);
        int __i = v.getI();
        int __j = v.getJ();
        visited[__i][__j] = true;

        while(queue.size() != 0)
        {
            Position_2667 temp = queue.poll();
            __i = temp.getI();
            __j = temp.getJ();
            //사방 탐색 시행
            for(int i = 0; i < 4; i ++)
            {
                int ni = __i + delta_i[i];
                int nj = __j + delta_j[i];
                //인덱스 체킹
                if(0 <= ni && ni < N && 0 <= nj && nj < N)
                {
                    //방문했는지 체킹하고 값이 1이면 큐에 담음
                    if(!visited[ni][nj] && map[ni][nj] == 1)
                    {
                        //큐에 담으면서 house cnt ++;
                        queue.add(new Position_2667(ni,nj));
                        visited[ni][nj] = true;
                        house_cnt ++;
                    }
                }
            }
        }
        return house_cnt;
    }
}
