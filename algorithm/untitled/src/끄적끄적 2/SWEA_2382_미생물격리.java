package 끄적끄적;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_2382_미생물격리 {
    static int N, M, K;
    static int[] delta_i = {0,-1, 1, 0, 0}; // 상하좌우
    static int[] delta_j = {0,0, 0, -1, 1};

    static class Virus implements Comparable<Virus> {
        int idx;
        int cnt;
        int d;

        public Virus(int idx, int cnt, int d) {
            this.idx = idx;
            this.cnt = cnt;
            this.d = d;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.idx == o.idx)
                return o.cnt - this.cnt;
            else return this.idx - o.idx;
        }
    }

    static List<Virus> virusList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();
            virusList = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                int cnt = scanner.nextInt();
                int d = scanner.nextInt();
                int idx = r * N + c; // 논리적 위치

                virusList.add(new Virus(idx, cnt, d));
            }

            for (int i = 0; i < M; i++) {
                moveVirus();
                sideEffect();
            }

            int sum = getCount();
            System.out.println("#"+tc+" " + sum);
        }
    }

    private static int getCount() {
        int sum = 0;
        for (int i = 0; i < virusList.size(); i++) {
            sum += virusList.get(i).cnt;
        }

        return sum;
    }

    private static void sideEffect() {
        Collections.sort(virusList);

        for (int i = 0; i < virusList.size() - 1; i++) {
            Virus cur = virusList.get(i);
            Virus next = virusList.get(i + 1);

            if (cur.idx == next.idx) {
                cur.cnt += next.cnt;
                virusList.remove(i+1);
                i--;
            }
        }
    }

    private static void moveVirus() {
        for (int i = 0; i < virusList.size(); i++) {
            Virus virus = virusList.get(i);
            int ni = (virus.idx / N) + delta_i[virus.d];
            int nj = (virus.idx % N) + delta_j[virus.d];

            virus.idx = ni * N + nj;

            //다음 위치가 셀이라면
            if (ni == 0 || nj == 0 || ni == N - 1 || nj == N - 1) {
                //절반 죽고 이동방향 돌려야됨
                virus.cnt /= 2;
                changeDir(virus);

                if (virus.cnt == 0) {
                    virusList.remove(i);
                    i--;
                }
            }
        }
    }

    private static void changeDir(Virus virus) {
        int d = virus.d;

        if (d == 1)
            virus.d = 2;
        else if (d == 2)
            virus.d = 1;
        else if (d == 3)
            virus.d = 4;
        else if (d == 4)
            virus.d = 3;
    }
}
