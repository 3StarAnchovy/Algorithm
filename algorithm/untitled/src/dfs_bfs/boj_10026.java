package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    private int i;
    private int j;

    public Pair(int i, int j) {
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

public class boj_10026 {
    static int N;
    static boolean[][] visitied;
    static char[][] map;
    static char[][] weak_map;
    static Queue<Pair> queue;
    static int person_cnt = 0;
    static int weak_cnt = 0;

    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new char[N][N];
        weak_map = new char[N][N];
        visitied = new boolean[N][N];
        for (int i = 0; i < N; i++)
        {
            String input = scanner.next();
            for(int j = 0; j < N; j ++)
            {
                char cInput = input.charAt(j);
                map[i][j] = cInput;
                if(cInput == 'B')
                    weak_map[i][j] = cInput;
                else
                    weak_map[i][j] = 'R';

            }
        }

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(!visitied[i][j])
                {
                    char color = map[i][j];
                    dfs_person(new Pair(i,j), color, map);
                    person_cnt ++;
                }
            }
        }
        System.out.print(person_cnt + " ");

        visitied = new boolean[N][N];

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                if(!visitied[i][j])
                {
                    char color = weak_map[i][j];
                    dfs_person(new Pair(i,j), color, weak_map);
                    weak_cnt ++;
                }
            }
        }

        System.out.println(weak_cnt);
    }

    private static void dfs_person(Pair pair, char color, char[][] map) {
        queue = new LinkedList<>();

        queue.add(pair);
        int __i = pair.getI();
        int __j = pair.getJ();
        visitied[__i][__j] = true;

        while (queue.size() != 0)
        {
            Pair temp = queue.poll();
            __i = temp.getI();
            __j = temp.getJ();
            for(int i = 0; i < 4; i ++)
            {
                int ni = __i + delta_i[i];
                int nj = __j + delta_j[i];
                if(0 <= ni && ni < N && 0 <= nj && nj < N)
                {
                    if(!visitied[ni][nj] && map[ni][nj] == color)
                    {
                        queue.add(new Pair(ni,nj));
                        visitied[ni][nj] = true;
                    }
                }
            }
        }
    }

}
