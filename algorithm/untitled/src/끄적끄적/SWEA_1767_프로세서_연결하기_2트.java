package 끄적끄적;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1767_프로세서_연결하기_2트 {
    static int N;
    static int[][] map;
    static int max_cnt;
    static int min_cnt_line;
    static int list_size;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static List<Pos> pro_list;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            max_cnt = 0;
            min_cnt_line = 0;
            map = new int[N][N];
            pro_list = new ArrayList<>();
            //step1 입력받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                    if (map[i][j] != 0) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
                            continue;
                        pro_list.add(new Pos(i, j));
                    }
                }
            }
            list_size = pro_list.size();

            //step2 : powerset 시행
            powerset(0, 0); //cnt , picked_cnt;
            System.out.println("#" + tc + " " + min_cnt_line);
        }
    }

    private static void powerset(int cnt, int picked_cnt) {
        if (cnt == list_size) {
            int temp = getLineCnt();
            if (max_cnt < picked_cnt) {
                max_cnt = picked_cnt;
                min_cnt_line = temp;
            } else if (max_cnt == picked_cnt) {
                min_cnt_line = Math.min(min_cnt_line, temp);
            }
            return;
        }

        Pos pick = pro_list.get(cnt);
        //선택하는경우
        for (int d = 0; d < 4; d++) {
            //해당 방향으로 교차되어있는지 체크
            if (check(pick, d)) {
                //선긋기
                setLine(pick, d, 2);
                powerset(cnt + 1, picked_cnt + 1);
                //restore 하기
                setLine(pick, d, 0);
            }

        }

        //선택하지 않는 경우
        powerset(cnt + 1, picked_cnt);
    }

    private static int getLineCnt() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2)
                    cnt++;
            }
        }

        return cnt;
    }

    private static void setLine(Pos pick, int d, int line) {
        int ni = pick.i + delta_i[d];
        int nj = pick.j + delta_j[d];

        while (0 <= ni && ni < N && 0 <= nj && nj < N) {
            map[ni][nj] = line;
            ni += delta_i[d];
            nj += delta_j[d];
        }
    }

    private static boolean check(Pos pick, int d) {
        int ni = pick.i + delta_i[d];
        int nj = pick.j + delta_j[d];

        while (0 <= ni && ni < N && 0 <= nj && nj < N) {
            if (map[ni][nj] >= 1)
                return false;
            ni += delta_i[d];
            nj += delta_j[d];
        }

        return true;
    }
}
