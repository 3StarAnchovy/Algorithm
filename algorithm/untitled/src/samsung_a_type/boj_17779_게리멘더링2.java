package samsung_a_type;

import java.util.Arrays;
import java.util.Scanner;

/*
접근 1.
d1,d2 구하는게 핵심임
    브루트포스 - dfs로 쭉 탐색 시작
    꺾는 경우
    안꺾는 경우 탐색
    d -> 0,1,2,3

    d = 0; d = 2 d1 ++
    d= 1, d= 3 d2 ++

    d= 4 -> return
    출발점이랑 current 같을 때 d1, d2 기준으로
    각 구역 구하면 됨
    1,2,3,4 다 구하고, 5번은 1~4 빼면 될듯
 */

/*
접근 2.
조합으로 사각형 꼭짓점 구하는 경우?
좌표 지정 하고, 평행하는 변의 길이가 일치할때만 getArea()호출하는 방식?
 */

public class boj_17779_게리멘더링2 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int map_sum = 0;
    static int min = Integer.MAX_VALUE;

    static class Pos {
        int i;
        int j;
        int d;

        public Pos(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    static int[] delta_i = {1, 1, -1, -1};
    static int[] delta_j = {-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                map_sum += map[i][j];
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 1; j <= N - 2; j++) {
                //이따 틀릴수도 있는 부분
                dfs(new Pos(i, j, 0), new Pos(i, j, 0), 0, 0);
            }
        }

        System.out.println(min);
    }

    private static void dfs(Pos current, Pos start, int d1, int d2) {
        //기저조건 네번 꺾었으면 종료, d==3인 상태에서 출발점 마주하면 계산시작
        if (start.i == current.i && start.j == current.j && d1 != 0) {
            visited[start.i][start.j] = true;
            getArea(start, d1, d2);
            visited[start.i][start.j] = false;
            return;
        }
        if (current.d == 4)
            return;

        //이거 Restore해야되나? 이따 고민해보자, 이따 틀릴수도 있는 부분
        if (current.d == 0) d1++;
        if (current.d == 1) d2++;

        //안꺾는 경우
        int ni = current.i + delta_i[current.d];
        int nj = current.j + delta_j[current.d];
        if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
            visited[ni][nj] = true;
            dfs(new Pos(ni, nj, current.d), start, d1, d2);
            visited[ni][nj] = false; // restore
        }

        //꺾는 경우
        if (current.d < 3) {
            ni = current.i + delta_i[current.d + 1];
            nj = current.j + delta_j[current.d + 1];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                visited[ni][nj] = true;
                dfs(new Pos(ni, nj, current.d + 1), start, d1, d2);
                visited[ni][nj] = false; // restore
            }
        }

        //restore
//        if (current.d == 0) d1--;
//        if (current.d == 1) d2--;
    }

    /*
    1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y -> 0 <= r < x d1 && 0 <= c <= y - 1
    2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
    3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
    4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
     */
    private static void getArea(Pos start, int d1, int d2) {
        int[] area = new int[5];
        int x = start.i;
        int y = start.j;

        d1 -= 1; //...
        //d2 -= 1;
        //1base -> zero base 조심 ㅅㅂ
        for (int i = 0; i < x + d1; i++) { //1
            for (int j = 0; j <= y; j++) {
                if (visited[i][j]) break;
                area[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) { //2
            for (int j = N -1; j > y; j--) {
                if (visited[i][j]) break;
                area[1] += map[i][j];
            }
        }

        for (int i = x + d1; i <= N - 1; i++) { //3
            for (int j = 0; j < y + d2 - d1; j++) {
                if (visited[i][j]) break;
                area[2] += map[i][j];
            }
        }

        for (int i = x + d2 + 1; i <= N - 1; i++) {
            for (int j = N - 1; j >= y + d2 - d1; j--) {
                if (visited[i][j]) break;
                area[3] += map[i][j];
            }
        }

        area[4] = map_sum - area[0]- area[1]- area[2]- area[3];
        Arrays.sort(area);

        int result = area[4] - area[0];
        min = Math.min(min,result);
    }

}
