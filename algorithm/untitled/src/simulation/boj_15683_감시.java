package simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15683_감시 {
    static int N,M;
    static int[][] map;
    static int[] picked;
    static int cctv_size;
    static class Pos {
        int i,j;
        int cctv_num;

        public Pos(int i, int j, int cctv_num) {
            this.i = i;
            this.j = j;
            this.cctv_num = cctv_num;
        }
    }
    static ArrayList<Pos> cctv_list = new ArrayList<>();
    public static void main(String[] args)
    {
        //step1 : 입력받기
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                map[i][j] = scanner.nextInt();
                if(map[i][j] != 0)
                    cctv_list.add(new Pos(i,j,map[i][j]));
            }
        }
        cctv_size = cctv_list.size();
        picked = new int[cctv_size];

        perm(0);
    }

    private static void perm(int cnt) {
        if(cnt == cctv_size)
        {
            return;
        }

        for(int i = 0; i < 4; i ++)
        {
            //picked에 방향 담기, picked가 의미하는 것 : cctv의 방향 지정해주기 ㅇㅇ
            // 중복순열
            picked[cnt] = i;
            perm(cnt + 1);
        }
    }
}
