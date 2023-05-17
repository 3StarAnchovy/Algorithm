package samsung_a_type;

import java.util.*;

public class boj_16235_나무_재테크 {
    static int N, M, K;
    static int[][] map;
    static int[][] input;
    static int[] delta_i = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] delta_j = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Pos implements Comparable<Pos> {
        int i, j, age;

        public Pos(int i, int j, int age) {
            this.i = i;
            this.j = j;
            this.age = age;
        }

        @Override
        public int compareTo(Pos o) {
            return this.age - o.age;
        }
    }

    static Deque<Pos> tree_list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        map = new int[N + 1][N + 1];
        input = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                input[i][j] = scanner.nextInt();
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int age = scanner.nextInt();
            tree_list.add(new Pos(r, c, age));
        }

        while (K-- > 0) {
            //봄, 여
            spring_summer();
            //가을
            fall();
            //겨울
            winter();
        }

        System.out.println(tree_list.size());
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += input[i][j];
            }
        }
    }

    private static void fall() {
        Deque<Pos> temp_list = new LinkedList<>();

        for (Pos tree : tree_list) {
            if (tree.age % 5 == 0) {
                temp_list.add(tree);
            }
        }

        for (Pos tree : temp_list) {
            for (int d = 0; d < 8; d++) {
                int ni = tree.i + delta_i[d];
                int nj = tree.j + delta_j[d];
                if (1 <= ni && ni <= N && 1 <= nj && nj <= N) {
                    tree_list.addFirst(new Pos(ni, nj, 1));
                }
            }
        }
    }

    private static void spring_summer() {
        Deque<Pos> dead_tree_list = new LinkedList<>();

        //자신의 나이만큼 양분을 먹고, 나이가 1 증가함
        //여기 나중에 수정
        for (int i = 0; i < tree_list.size(); ) {
            Pos tree = tree_list.poll();
            if (tree.age <= map[tree.i][tree.j]) {//양분이 자신의 나이보다 많다면
                map[tree.i][tree.j] -= tree.age;
                tree.age++;
                tree_list.add(tree);
                i++;
            } else { //반대의 경우 죽어야함
                dead_tree_list.add(tree);
            }
        }

        //여름
        // 봄에 죽은 나무가 양분으로 변함
        // 각각의 죽은 나무마다 나이를 2로 나눈값이 나무가 있던 칸에 양분으로 추가됨
        for (Pos tree : dead_tree_list) {
            map[tree.i][tree.j] += tree.age / 2;
        }
    }
}
