package dfs_bfs;


import java.util.Scanner;

/*
접근 1
N!로 모든 거리 측정 후 최소거리 도출
 */
public class swea_1247 {
    static class Position
    {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Position[] input;
    static Position[] picked;
    static boolean[] visited;
    static int N;
    static int min;
    static int com_y,com_x;
    static int home_y,home_x;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int tc = 1; tc <= T; tc ++)
        {
            N = scanner.nextInt();
            min = Integer.MAX_VALUE;
            input = new Position[N];
            picked = new Position[N];
            visited = new boolean[N];

            //회사 집 입력
            com_y = scanner.nextInt();
            com_x = scanner.nextInt();

            home_y = scanner.nextInt();
            home_x = scanner.nextInt();

            for(int i = 0; i < N; i ++)
            {
                int y = scanner.nextInt();
                int x = scanner.nextInt();
                input[i] = new Position(y,x);
            }

            perm(0); //cnt

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void perm(int cnt) {
        if (cnt == N) {
            int sum = 0;
            sum += getDistance(new Position(com_y,com_x), picked[0]);
            for(int i = 0; i < N - 1; i ++)
                sum += getDistance(picked[i], picked[i + 1]);
            sum+= getDistance(picked[N - 1],new Position(home_y,home_x));

            if(sum < min)
                min = sum;
            return;
        }

        for (int i = 0; i < N; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                picked[cnt] = input[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int getDistance(Position a, Position b)
    {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
