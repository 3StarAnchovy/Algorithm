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
    static int N, M, R, G;
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int result = 0;
    static class Pos
    {
        int i,j,color,time;

        public Pos(int i, int j, int color, int time) {
            this.i = i;
            this.j = j;
            this.color = color;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        R = scanner.nextInt();
        G = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];
        //step1. 배열 입력 (0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅을 의미한다.)
        //3은 초록색, 4는 빨강으로 하자!
        //-1은 꽃으로 해야지
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        //step2. 초록색 배양하기!
        greenCombi(0,0); // cnt, start
        System.out.println(result);
    }

    private static void greenCombi(int cnt, int start) {
        if(cnt == G)
        {
            redCombi(cnt,0);
            return;
        }

        for(int i = start; i < N * M; i ++)
        {
            //idx = (i * N) + M;
            int r = i / M;
            int c = i % M;

            if(map[r][c] == 2 && !visited[r][c])
            {
                visited[r][c] = true; //빨간색 배양할때 중복 배양 방지
                map[r][c] = 3; // 초록색 배양하기
                greenCombi(cnt + 1, i + 1);

                //restore
                visited[r][c] = false;
                map[r][c] = 2;
            }
        }
    }

    //print
    private static void print(int[][] map)
    {
        for(int i = 0; i < N; i ++)
        {
            for(int j= 0; j < M; j ++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    private static void redCombi(int cnt, int start) {
        if(cnt == R + G)
        {
            //bfs 돌리기 전에 백업따기
            int [][] copy = copyArr();
            //print(copy);
            //원본에 영향을 끼치지 않도록 Copy로 bfs 시행
            int flower_cnt = bfs(copy);
            result = Math.max(flower_cnt,result);
            return;
        }

        for(int i = start; i < N * M; i ++)
        {
            //idx = (i * N) + M;
            int r = i / M;
            int c = i % M;

            if(map[r][c] == 2 && !visited[r][c])
            {
                visited[r][c] = true;
                map[r][c] = 4;

                redCombi(cnt + 1, i + 1);

                // restore
                visited[r][c] = false;
                map[r][c] = 2;
            }
        }
    }

    private static int bfs(int[][] map) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        int[][] time_table = new int[N][M];

        //배양액 뿌린거 전부 큐에 담기
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < M; j ++)
            {
                if(map[i][j] == 3 || map[i][j] == 4) {
                    queue.add(new Pos(i, j, map[i][j], 0));
                    visit[i][j] = true;
                }
            }
        }

        int time = 0;
        int cnt = 0;
        //bfs 탐색 시작
        while(!queue.isEmpty())
        {
            int qSize = queue.size();
            time ++;
            while(qSize -- > 0)
            {
                Pos cur = queue.poll();
                for(int d = 0; d < 4; d++)
                {
                    int ni = cur.i + delta_i[d];
                    int nj = cur.j + delta_j[d];

                    //여기 수정하기
                    if(0 <= ni && ni < N && 0 <= nj && nj < M)
                    {
                        //1 또는 2일때
                        if((map[ni][nj] == 1 || map[ni][nj] == 2) && !visit[ni][nj])
                        {
                            visit[ni][nj] = true;
                            map[ni][nj] = cur.color;
                            time_table[ni][nj] = time;
                            queue.add(new Pos(ni,nj,cur.color,time));
                        }

                        //현재 노드가 3인데 다음 노드가 4일 떄
                        else if(map[ni][nj] == 4 && cur.color == 3 && time_table[ni][nj] == cur.time + 1)
                        {
                            cnt ++;
                            map[ni][nj] = -1;

                        }

                        else if(map[ni][nj] == 3 && cur.color == 4 && time_table[ni][nj] == cur.time + 1)
                        {
                            cnt ++;
                            map[ni][nj] = -1;
                            break;
                        }
                    }
                }
            }
        }

        //print(map);
        if(cnt == 6) {
            print(map);
            System.out.println("------------------------");
        }
        if(cnt == 5) {
            print(map);
            System.out.println("-------------------------");
        }
        return cnt;
    }

    private static int[][] copyArr() {
        int[][] copy = new int[N][M];

        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j ++)
                copy[i][j] = map[i][j];

        return copy;
    }
}
