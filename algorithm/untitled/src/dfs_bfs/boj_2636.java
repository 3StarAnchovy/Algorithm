package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 접근
 해당 치즈가 공기에 접촉되어있는지 어떻게 판단할까?

 아이디어 1
 치즈의 한쪽면을 쭉 바라볼때 벽이면 공기에 접촉한거 아닐까?
    -> 반례있음. 대각선

 아이디어 2
 치즈를 탐색할게 아니라, 공기를 탐색하면 되지 않을까?
 이거 맞는거같음. 맨 끝부분은 무조건 공기임. 맨끝부분에 인접한 공백은 무조건 공기임 ㅇㅇ
                공기에 인접한부분이
                    치즈면 지워버리고, 방문처리 안함
                    공기면 큐에 넣고 방문처리
모두 녹는거는 체킹 할 수 있음 ? ㅇㅇ
모두 녹기 한시간전은 어케 체킹함?
    치즈면 지워버리는게 아니라 시간을 체킹하는건 어떨까? 음수를 박아버리자 이거 근데 좀 변태같음
    치즈면 지워버리고 그때마다 카운팅을하자. 카운팅한걸 배열에 저장하면 되지 않을까?
 */


public class boj_2636 {
    static class CustomPair
    {
        int i;
        int j;

        public CustomPair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static int N; // 행
    static int M; // 열
    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = { -1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static int che_cnt = 0;
    static int tatal_cnt = 0;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i ++)
            for (int j = 0; j < M; j ++)
                map[i][j] = scanner.nextInt();

//        for(int i = 0; i < N; i ++)
//        {
//            for(int j = 0; j < M; j ++)
//            {
//                if(!visited[i][j])
//                {
//                    bfs(new CustomPair(i,j));
//                }
//            }
//        }
        bfs(new CustomPair(0,0));

        System.out.println();
        for(int[] i : map)
        {
            for(int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    private static int bfs(CustomPair customPair) {
        Queue<CustomPair> queue = new LinkedList<>();
        int cnt = 0;
        queue.add(customPair);
        int __i = customPair.i;
        int __j = customPair.j;
        visited[__i][__j] = true;

        while(queue.size() != 0)
        {
            CustomPair temp = queue.poll();
            __i = temp.i;
            __j = temp.j;
            for(int i = 0; i < 4; i ++)
            {
                int ni = __i + delta_i[i];
                int nj = __j + delta_j[i];
                if(0 <= ni && ni < N && 0 <= nj && nj < M)
                {
                    //인접한 공기면 체킹
                    if(!visited[ni][nj] && map[ni][nj] == 0)
                    {
                        visited[ni][nj] = true;
                        queue.add(new CustomPair(ni,nj));
                    }

                    //공기와 인접한 치즈면 0으로 바꿔버리고 카운팅함.
                    //이거 큐에 넣으면 안됨
                    else if(map[ni][nj] == 1)
                    {
                        map[ni][nj] = 0;
                        visited[ni][nj] = true;
                        cnt ++;
                    }
                }
            }
        }

        return cnt ++;
    }
}
