package samsung_a_type;

import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
    static int N;
    static int[][] map;
    static int max = 0;

    static class Ball {
        int i, j, d;

        public Ball(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    static int[] delta_i = {-1, 0, 1, 0}; //상좌하우
    static int[] delta_j = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            max = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            //모든 위치에서 탐색 시작
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    for (int d = 0; d < 4; d++)
                        if (map[i][j] == 0)
                            playGame(new Ball(i, j, d), new Ball(i, j, d));

            System.out.println("#"+ tc + " " + max);
        }
    }


    private static void playGame(Ball ball, Ball start) {
        int score = 0;
        int cnt =0;
        while (true) {
            //System.out.println(start.i + " " + start.j + " " + start.d);
            int ni = ball.i + delta_i[ball.d];
            int nj = ball.j + delta_j[ball.d];

            //다음 볼의 위치가 범위 밖인 경우
            if (0 > ni || 0 > nj || N <= ni || N <= nj) {
                int nd = (ball.d + 2 + 4) % 4;
                ball.d = nd;
                score++;
                System.out.println("범위 밖 " + ball.i + " " + ball.j + " " + ball.d);
            }

            //다음위치가 아무것도 아닌 경우
            else if(map[ni][nj] == 0)
            {
                ball.i = ni;
                ball.j = nj;
                System.out.println("0임 " + ni + " " + nj + " " + ball.d);
            }
            //다음 위치가 블록인 경우
            else if (map[ni][nj] >= 1 && map[ni][nj] <= 5) {
                score++;
                blockAction(ball, ni, nj);
                System.out.println("블록만남 " + ni + " " + nj + " " + ball.d);
            }

            //다음 위치가 웜홀인 경우
            else if (map[ni][nj] >= 6 && map[ni][nj] <= 10) {
                intoHole(ni, nj, ball);
                System.out.println("t");
            }

            else if(map[ni][nj] == -1 || (ni == start.i && nj == start.j)) {
                System.out.println("break");
                break;
            }
        }

        max = Math.max(max, score);
    }

    private static void intoHole(int ni, int nj, Ball ball) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[ni][nj] == map[i][j] && (ni != i || nj != j))
                {
                    ball.i = i;
                    ball.j = j;
                }
            }
        }
    }

    private static void blockAction(Ball ball, int ni, int nj) {
        switch (map[ni][nj]) {
            case 1:
                //2일때 3으로 바뀌어야함
                if (ball.d == 2) ball.d = 3;
                    //1일때 0으로 바뀌어야함
                else if (ball.d == 1) ball.d = 0;
                    //나머지는 역주
                else ball.d = (ball.d + 2 + 4) % 4;
                break;
            case 2:
                //0이면 3
                if (ball.d == 0) ball.d = 3;
                    //1이면 2
                else if (ball.d == 1) ball.d = 2;
                    //나머지는 역주
                else ball.d = (ball.d + 2 + 4) % 4;
                break;
            case 3:
                //0이면 1
                if (ball.d == 0) ball.d = 1;
                    //3이면 2
                else if (ball.d == 3) ball.d = 2;
                    //나머지는 역주
                else ball.d = (ball.d + 2 + 4) % 4;
                break;
            case 4:
                //3이면 0
                if (ball.d == 3) ball.d = 0;
                    //2이면 1
                else if (ball.d == 2) ball.d = 1;
                    //나머지는 역주
                else ball.d = (ball.d + 2 + 4) % 4;
                break;
            case 5:
                //걍 다 역주
                ball.d = (ball.d + 2 + 4) % 4;
                break;
        }
        ball.i = ni;
        ball.j = nj;
    }
}
