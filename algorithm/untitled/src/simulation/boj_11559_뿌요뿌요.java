package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11559_뿌요뿌요 {
    static char[][] map;
    static int N = 12;
    static int M = 6;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] delta_i = {-1, 1, -0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean flag = true;
        int cnt = 0;

        while (flag) {
            flag = false;
            boolean[][] visited = new boolean[N][M];
            //뿌요 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        int boyoCnt = bfs(map[i][j], visited, i, j);

                        if (boyoCnt >= 4) {
                            boom(map[i][j], i, j);
                            flag = true;
                        }
                    }
                }
            }

            //flag 체킹
            if (flag)
                cnt++;

            for(int j = 0; j < M; j ++){
                for(int i = N -1; i > 0; i --){
                    if(map[i][j] == '.'){
                        for(int k = i - 1; k > 0; k --){
                            if(map[k][j] != '.'){
                                map[i][j] = map[k][j];
                                map[k][j] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static void boom(char color, int start_i, int start_j) {
        boolean[][] visited;
        visited = new boolean[N][M];

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(start_i, start_j));
        visited[start_i][start_j] = true;
        map[start_i][start_j] = '.';

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            while (qSize-- > 0) {
                Pos pos = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (map[ni][nj] == color) {
                            map[ni][nj] = '.';
                            visited[ni][nj] = true;
                            queue.add(new Pos(ni, nj));
                        }
                    }
                }
            }
        }

    }

    private static int bfs(char color, boolean[][] visited, int start_i, int start_j) {
        visited[start_i][start_j] = true;

        Queue<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(start_i, start_j));

        int cnt = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- > 0) {
                Pos pos = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int ni = pos.i + delta_i[d];
                    int nj = pos.j + delta_j[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]) {
                        if (map[ni][nj] == color) {
                            queue.add(new Pos(ni, nj));
                            visited[ni][nj] = true;
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    /*
    여러가지 색깔의 뿌요가 있다. 중력의 영향을 받아, 바닥이나 다른 뿌요가 나올때까지 아래로 떨어진다.
    같은 색 뿌요가 4개이상 상하좌우로 연결되어있으면, 같은색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.

    뿌요들이 없어지고 나서 위에 다른 뿌요들이 있따면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
    아래로 떨어지고 나서, 다시 같은색의 뿌요들이 4개이상 모여있으면 또 터지는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할때마다 1연쇄씩 늘어난다.
    "터질수 있는 뿌요가 여러 그룹이 있다면, 동시에 터져야 하고, 여러 그룹이 터지더라도 한번에 연쇄가 추가된다."

    while(flag){
    flag = false;
    뿌요 탐색
     -> 같은색 인접이 4개 이상이야?
        ㅇㅇ 터쳐 (터치는 함수)
        플래그 true로 바꿔
    -> 같은색 인접이 4개 미만이야?
        => 넘겨
    flag가 true야?
        연쇄 올려잇
    중력
    }
     */
}
