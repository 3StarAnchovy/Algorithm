package 끄적끄적;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_1767_프로세스_연결하기_2트 {
    static int N;
    static int[][] map;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static class Pos {
        int i,j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static List<Pos> core_list;
    static int list_size;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for(int tc = 1; tc <= TC; tc ++)
        {
            core_list = new ArrayList<>();
            N = scanner.nextInt();
            map = new int[N][N];

            for(int i = 0; i < N; i ++)
            {
                for(int j = 0; j < N; j ++)
                {
                    map[i][j] = scanner.nextInt();
                    if(map[i][j] == 1) {
                        core_list.add(new Pos(i, j));
                    }
                }
            }

            list_size = core_list.size();

            powerset(0); // cnt
        }
    }

    private static void powerset(int cnt) {
        if(cnt == list_size)
        {
            return ;
        }

        Pos pick = core_list.get(cnt);
    }
}
