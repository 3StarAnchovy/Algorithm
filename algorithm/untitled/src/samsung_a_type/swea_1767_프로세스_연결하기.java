package samsung_a_type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_1767_프로세스_연결하기 {
    static int N;
    static int[][] map;

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static List<Pos> core_list;
    static int core_cnt;
    static int max;
    static int max_cnt;
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            //step 1 : 입력받기
            N = scanner.nextInt();
            map = new int[N][N];
            max = 0;
            max_cnt = 0;
            core_list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                    if (map[i][j] == 1)
                        core_list.add(new Pos(i, j)); // 코어 백업하기
                }
            }
            core_cnt = core_list.size();

            //step 2 : powerset시행
            powerset(0, 0); // cnt, picked_cnt - 선택된 코어의 수
            System.out.println("#" + tc + " " + max_cnt);
        }
    }

    private static void powerset(int cnt, int picked_cnt) {
        if (cnt == core_cnt) {
            int temp_cnt = getLineCnt();
            if (max < picked_cnt) // 최대값이면 cnt 백업하기
            {
                max = picked_cnt;
                max_cnt = temp_cnt;
            } else if (max == picked_cnt)
                max_cnt = Math.min(max_cnt, temp_cnt);
            return;
        }

        Pos pos = core_list.get(cnt);
        //코어를 선택하는 경우
        for (int d = 0; d < 4; d++) {
            if (checkCross(pos, d)) {// 교차되어있는지 체크해야됨
                setLine(pos, d, 2);
                powerset(cnt + 1, picked_cnt + 1);
                setLine(pos, d, 0); // restore
            }
        }
        //코어를 선택하지 않는 경우
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

    private static void setLine(Pos pos, int d, int line) {
        int i = pos.i;
        int j = pos.j;

        while (true) {
            i = i + delta_i[d];
            j = j + delta_j[d];
            if (0 > i || 0 > j || N <= i || N <= j)
                break;
            map[i][j] = line;
        }
    }

    private static boolean checkCross(Pos pos, int d) {
        int i = pos.i;
        int j = pos.j;

        while (true) {
            i = i + delta_i[d];
            j = j + delta_j[d];
            if (0 > i || 0 > j || N <= i || N <= j)
                break;
            if (map[i][j] > 1)
                return false;
        }

        return true;
    }
}
