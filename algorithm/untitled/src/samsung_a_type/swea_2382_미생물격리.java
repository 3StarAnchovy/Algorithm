package samsung_a_type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
문제 해석
N * N map -> 0 base
가장자리에 약품 칠해져있음
1시간마다 이동방향에 있는 다음셀로 이동
약품 칠해져있으면 -> 미생물 절반 죽고 대가리 반대로 돌림
미생물 수가 0이되면 군집 삭제

이동 후 군집이 한 셀에 모여있으면 합쳐짐. 이동방향이 많은 군집의 방향 따라감
m시간 동안 m시간 후 남아 있는 미생물 수의 총합 ㄱㄱ
 */
public class swea_2382_미생물격리 {
    static int N; // 셀 개수
    static int M; // 격리 시간
    static int K; // 군집 개수
    static int[] delta_i = {0, -1, 1, 0, 0}; // 맨앞 dummy
    static int[] delta_j = {0, 0, 0, -1, 1};

    static class Micro implements Comparable<Micro> {
        int i;
        int j;
        int cnt; // 미생물 수
        int dir;
        int idx; // 좌표를 기반한 아이디, (i * N) + j


        public Micro(int i, int j, int cnt, int dir, int idx) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
            this.idx = idx;
        }

        @Override
        public int compareTo(Micro o) {
            if (this.idx == o.idx) {
                //idx가 같으면 cnt 큰게 앞에 오게끔
                return o.cnt - this.cnt;
            } else
                return this.idx - o.idx;
        }
    }

    static List<Micro> microList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            microList = new ArrayList<>();
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();

            //i,j,cnt,dir, idx
            for (int k = 0; k < K; k++) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                int idx = (i * N) + j;
                microList.add(new Micro(i, j, scanner.nextInt(), scanner.nextInt(), idx));
            }
            for (int i = 0; i < M; i++) {
                //step 01 이동방향에 맞게끔 이동 구현  (이때, 군집 내 미생물 절반 죽고, 이동방향 바꾸기),
                moveMicro();
                //step 02 미생물 합치기
                sideEffect();
            }
            //step 03 미생물 수 총합 구하기
            int result = getCount();
            System.out.println("#" + tc + " " + result);
        }
    }

    private static int getCount() {
        int sum = 0;

        for (Micro micro : microList) {
            sum += micro.cnt;
        }

        return sum;
    }

    //군집 합치기
    private static void sideEffect() {
        //정렬하고 for문 돌리면서 current, next 같으면 큰거로 값 바꾸기
        Collections.sort(microList);

        for (int i = 0; i < microList.size() - 1; i++) {
            Micro current = microList.get(i);
            Micro next = microList.get(i + 1);
            if (current.idx == next.idx) {
                current.cnt += next.cnt;
                microList.remove(i + 1);
                i--;
            }
        }
    }

    private static void moveMicro() {
        for (int i = 0; i < microList.size(); i++) {
            Micro micro = microList.get(i);
            int ni = micro.i + delta_i[micro.dir];
            int nj = micro.j + delta_j[micro.dir];

            micro.i = ni;
            micro.j = nj;
            micro.idx = (ni * N) + nj;
            //셀이라면
            if (ni == 0 || nj == 0 || ni == N - 1 || nj == N - 1) {
                //절반 죽이고 대가리 돌림
                micro.cnt /= 2;
                changeDir(micro);
                //이때 micro가 0이면 리스에서 삭제해야함
                if (micro.cnt == 0) {
                    microList.remove(i);
                    i--;
                }
            }
        }
    }

    private static void changeDir(Micro micro) {
        //상하좌우, 1234
        int dir = micro.dir;

        if (dir == 1)
            micro.dir = 2;
        else if (dir == 2)
            micro.dir = 1;
        if (dir == 3)
            micro.dir = 4;
        else if (dir == 4)
            micro.dir = 3;
    }
}
