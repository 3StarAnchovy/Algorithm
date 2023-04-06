package samsung_a_type;

import java.util.Scanner;

/*
문제 해석
활주로를 건설할 수 있는 경우의 수
왜인지는 모르겠는데 한 줄에 여러개 설치할 수 있어도 하나로 친다.
경사로는 높이 차이가 1이고, 낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치 할 수 있다.
"각자의 행과 열에 경사로를 깔아서, 활주로를 만들수 있는지 없는지 체킹하는거!"
 */

/*
접근
각자의 행과 열에 경사로가 되는지 완전탐색해야함
행의 경우
    높이 차이가 2가 넘어가면 return
    위로 올라가는 경사로인 경우
    아래로 내려가는 경사로인 경우
열의 경우
    높이 차이가 2가 넘어가면 return
    위로 올라가는 경사로인 경우
    아래로 내려가는 경사로인 경우
 */
public class swea_4014_활주로_test {
    static int N;
    static int X;
    static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            X = scanner.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (checkRow(i)) cnt++;
                if (checkCol(i)) cnt++;
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }

    private static boolean checkCol(int c) {
        boolean[] check = new boolean[N];

        for (int i = 0; i <= N - 2; i++) {
            int left = map[i][c];
            int right = map[i+1][c];
            int diff = left - right;

            if (Math.abs(diff) >= 2)
                return false;

            if (diff == 1) {
                for (int j = i + 1; j <= i + X; j++) {
                    if (N <= j || right != map[j][c]) return false;
                    check[j] = true;
                }
            }

            if (diff == -1) {
                for (int j = i; j >= i - X + 1; j--) {
                    if (j < 0 || left != map[j][c]) return false;
                    check[j] = true;
                }
            }
        }

        return true;
    }

    //행 체크
    private static boolean checkRow(int r) {
        boolean[] check = new boolean[N];

        for (int i = 0; i <= N - 2; i++) {
            int left = map[r][i];
            int right = map[r][i + 1];
            int diff = left - right;

            //높이 차이가 2보다 큰 경우 -> 경사로 생성 x
            if (Math.abs(diff) >= 2) return false;

            //오르막길 경사로 생성해야될 떄
            if (diff == 1) {
                for (int j = i + 1; j <= i + X; j++) {
                    if (N <= j || map[r][j] != right) return false;
                    check[j] = true;
                }
            }

            //내리막길 경사로 생성해야될 떄
            if (diff == -1) {
                for (int j = i; j >= i - X + 1; j--) {
                    if (j < 0 || map[r][j] != left) return false;
                    check[j] = true;
                }
            }
            //check 해야함? 이따 뺴고 보자
        }
        return true;
    }
}

