package samsung_a_type;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_2382 {
    static int N;
    static int M;
    static int K;

    static class Virus implements Comparable<Virus> {
        int num;
        int i;
        int j;
        int cnt;
        int dir;

        public Virus(int num, int i, int j, int cnt, int dir) {
            this.num = num;
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Virus o) {
            if (this.num == o.num) {
                return o.cnt - this.cnt;
            }
            return this.num - o.num;
        }

    }
    static List<Virus> list;
    static int[] delta_i = {0,-1,1,0,0};
    static int[] delta_j = {0,0,0,-1,1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            K = scanner.nextInt();

            list = new ArrayList<>();
            for(int k = 0; k < K; k ++)
            {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                int cnt = scanner.nextInt();
                int dir = scanner.nextInt();
                list.add(new Virus(i * N + j, i, j, cnt, dir));
            }

            for(int time = 0; time < M; time ++)
            {
                for(int idx = 0; idx < list.size(); idx ++)
                {
                    Virus virus = list.get(idx);
                    virus.i = virus.i + delta_i[virus.dir];
                    virus.j = virus.j + delta_j[virus.dir];
                    virus.num = (virus.i * N) + virus.j;

                    //바이러스 약품에 위치하면 절반 뒤지고, 방향 반대로 바뀜
                    if(virus.i == 0 || virus.j == 0 || virus.i == N -1 || virus.j == N - 1)
                    {
                        virus.cnt /= 2;
                        virus.dir = changeDir(virus.dir);

                    }
                }
            }
        }
    }

    private static int changeDir(int dir) {
        int change_dir;

        switch (dir)
        {
            case 1:
                change_dir = 2;
                break;
            case 2:
                change_dir = 1;
                break;
            case 3:
                change_dir = 4;
                break;
            case 4:
                change_dir = 3;
                break;
        }

        return change_dir;
    }
}
