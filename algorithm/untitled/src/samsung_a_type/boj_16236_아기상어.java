package samsung_a_type;

import java.util.*;

/*
N * N 크기
물고기 m마리와 상어 1마리
응애 상어 크기 2, 1초에 인접한 한칸이동
자기보다 큰 물고기가 있는 칸은 지날 수 없고, 자기보다 작은 물고기만 먹을 수 있음. -> 크기 같은거는 먹을수 없고, 지나갈 수는 있음

- 더 이상 먹을 수 있는 물고기가 없다면 엄마한테 헬프 -> 종료
- 먹을 수있는거 있으면 그거 먹으러감
    - 칸 최소값으로 이동함 -> bfs
    - 동일한 거리에 여러개 있으면, "상, 좌 우선으로 먹음" -> 델타 신경쓰면서 선언하자
 */

/*
접근 - bfs
입력받고, 9 있으면 따로 백업
9 위치에서 bfs 시작

가장 가까운거로 이동 delta 상 좌 먼저
while, flag
flag -> true 먹을거 있음

queue 두개 쓰는것도 괜찮을듯?
 */

public class boj_16236_아기상어 {
    static class Pos implements Comparable<Pos> {
        int i;
        int j;
        int size; // 상어의 사이즈
        int distance;
        int eat_cnt;

        public Pos(int i, int j, int size, int distance, int eat_cnt) {
            this.i = i;
            this.j = j;
            this.size = size;
            this.distance = distance;
            this.eat_cnt = eat_cnt;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.distance == o.distance) {
                if (this.i == o.i) // 거리도 같고 i도 같다면 더 왼쪽에 있는거
                    return this.j - o.j;
                return this.i - o.i; // 거리가 같다면 더 위에 있는거
            }
            return this.distance - o.distance; // 거리 작은거
        }
    }

    static boolean[][] visited;
    static int[][] map;
    static int N;
    static boolean flag = true;
    static int time;
    static int[] delta_i = {-1, 0, 1, 0}; //상좌하우
    static int[] delta_j = {0, -1, 0, 1};
    static Queue<Pos> eat_queue = new LinkedList<>(); // 먹을거 위치, 상어 다음 위치 담을 큐

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        Pos baby_shark = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 9) {
                    baby_shark = new Pos(i, j, 2, 0,0);
                    map[i][j] = 0;
                }
            }
        }

        eat_queue.add(baby_shark);
        bfs(baby_shark);
        System.out.println(time);

    }

    private static void bfs(Pos pos) {
        int result = 0;
        while (!eat_queue.isEmpty()) {
            Queue<Pos> queue = new LinkedList<>(); // 탐색을 위한 큐
            visited = new boolean[N][N];
            boolean checkEat = false;

            pos = eat_queue.poll();
            queue.add(pos);
            visited[pos.i][pos.j] = true;
            List<Pos> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                checkEat = false;
                int qSize = queue.size();

                while (qSize-- > 0) {
                    pos = queue.poll(); // 얘 이따 수정, pos랑 temp 분리해야될듯

                    for (int d = 0; d < 4; d++) {
                        int ni = pos.i + delta_i[d];
                        int nj = pos.j + delta_j[d];

                        if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                            //먹을수 있는 사이즈라면? -> 일단 리스트에 추가 얘는 나중에 먹을거 우선순위로 정렬하고, eat_queue에 담을거임
                            if (map[ni][nj] < pos.size && map[ni][nj] != 0) {
                                list.add(new Pos(ni, nj, pos.size, pos.distance + 1, pos.eat_cnt + 1));
                                checkEat = true;
                            }
                            //자기보다 사이즈가 같으면 이동할 수 있음
                            else if (map[ni][nj] == pos.size || map[ni][nj] == 0) {
                                queue.add(new Pos(ni, nj, pos.size, pos.distance + 1, pos.eat_cnt));
                                visited[ni][nj] = true;
                            }
                        }
                    }
                }
                if(checkEat)
                    break;
            }
            Collections.sort(list);
            if (checkEat) {
                Pos next = list.get(0);
                if(next.eat_cnt == next.size)
                    eat_queue.add(new Pos(next.i, next.j, next.size + 1, 0,0)); // 처먹은거 초기화
                else
                    eat_queue.add(new Pos(next.i, next.j, next.size, 0, next.eat_cnt)); // 거리는 다시 0으로 초기화
                map[next.i][next.j] = 0;
                time += next.distance;
            }
            //다 끝났으면 엄마한테 헬프 -> 종료
        }
    }
}
