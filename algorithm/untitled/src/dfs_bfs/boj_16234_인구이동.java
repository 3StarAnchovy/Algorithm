package dfs_bfs;


import java.util.*;


/*
문제 해석
인구 이동이 없을때까지 지속
국경선을 공유하는(인접하는) 인구차이가 L명 이상 R명 이하면 국경선을 하루동안 열음
국경선 다 열었으면 인구이동 시작
 */

/*
접근
배열 완전 탐색 시행
visited false인 요소 있으면 bfs 시행
시행 될때마다 day ++
bfs 인구수에 맞춰서 다음거 계속 방문

bfs 끝나면 인구수 바꿈
인구수가 바뀌었다? flag true로 바꿈

flag가 false면 day 리턴
 */
public class boj_16234_인구이동 {
    static int N;
    static int L;
    static int R;

    static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};
    static int day = 0;
    static boolean flag = true; // 이동 변화가 있다면 true, 없다면 False;

    public static void main(String[] args) {
        //init
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        while (flag) {
            // step1. 방문안한거 있으면 bfs 시행
            flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(new Pos(i, j));
                    }
                }
            }
            if(flag) day++;

        }

        System.out.println(day);
    }

    //인구 변화가 있다면 True 반환, 없다면 False 반환
    private static void bfs(Pos pos) {
        Queue<Pos> queue = new LinkedList<>();
        //boolean[][] isOpen = new boolean[N][N];
        List<Pos> union_list = new ArrayList<>();
        boolean result = false;
        queue.add(pos);
        visited[pos.i][pos.j] = true;
        union_list.add(pos);

        int sum = map[pos.i][pos.j];
        int cnt = 1;
        while (!queue.isEmpty()) {
            pos = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                    int diff = Math.abs(map[ni][nj] - map[pos.i][pos.j]);
                    if (L <= diff && diff <= R) {
                        visited[ni][nj] = true;
                        //isOpen[ni][nj] = true; // 현재 정점과 다음 정점이 연결이 되어있음 -> 국경이 열려잇음
                        union_list.add(new Pos(ni,nj));
                        queue.add(new Pos(ni, nj));
                        sum += map[ni][nj];
                        cnt++;
                        flag = true;
                    }
                }
            }
        }

        int pop = sum / cnt;
        //bfs 탐색이 다 끝났다면, 국경 열려있는 얘들 인구 옮겨주기

        for(Pos e : union_list)
            map[e.i][e.j] = pop;

        /*
        시간초과 ;;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (isOpen[i][j])
                    map[i][j] = pop;
        */
    }
}
