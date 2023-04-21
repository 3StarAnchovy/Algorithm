package dfs_bfs;

import java.util.*;

/*
문제 접근
조합, bfs, 구현
step 1. 입력. 입력받을 때 뿌릴수 있는 땅 좌표 백업 (K개), 맵 입력받을 때 백업하나 해놓기

step 3. 모든 pick이 끝났으면, bfs 시뮬 돌리기
    - 초록 먼저 퍼뜨리고, 맵 바꿔버리기
    - 빨강 퍼뜨리고, 바뀐 맵에 도달했다면 cnt ++
    - 이게 최대값이면 갱신
 */
public class boj_18809_Gaaaaarden {
    static int N,M; // 격자 행, 열
    static int G;
    static int R;
    static int[][] map;
    static int[][] backup;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static boolean[] visited;
    static class Pos
    {
        int i;
        int j;
        int idx; // 2차원 조합을 위한, 좌표의 논리적 위치
        char color;

        public Pos(int i, int j, int idx) {
            this.i = i;
            this.j = j;
            this.idx = idx;
        }
        public Pos(int i, int j, int idx, char color) {
            this.i = i;
            this.j = j;
            this.idx = idx;
            this.color = color;
        }
    }
    static List<Pos> available_list = new ArrayList<>();
    static Pos[] picked;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        G = scanner.nextInt();
        R = scanner.nextInt();

        map = new int[N][M];
        backup = new int[N][M];
        picked = new Pos[G + R];

        //step 1.입력.입력받을 때 뿌릴수 있는 땅 좌표 백업 (K개),맵 입력받을 때 백업하나 해놓기
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                map[i][j] = scanner.nextInt();
                backup[i][j] = scanner.nextInt();
                if(map[i][j] == 2) // 배양액을 뿌릴수 있는 땅은 cnt++;
                    available_list.add(new Pos(i,j, (i * N) + j));
            }
        }

        greenCombi(0,0); //cnt, start
    }

    private static void greenCombi(int cnt, int start) {
        if(cnt == G)
        {
            return;
        }

        for(int i = start; i < available_list.size(); i ++)
        {

        }


    }
}
