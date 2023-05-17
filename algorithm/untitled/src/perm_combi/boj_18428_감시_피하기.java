package perm_combi;

import java.util.*;

public class boj_18428_감시_피하기 {
    static int N;
    static char[][] map;
    static int[] delta_i = {-1,1,0,0};
    static int[] delta_j = {0,0,-1,1};
    static String result = "NO";
    static List<Pos> teacher_list = new ArrayList<>();
    static class Pos {
        int i,j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //step 1 : 입력받기
        N = scanner.nextInt();
        map = new char[N][N];

        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N ; j ++)
            {
                String temp = scanner.next();
                map[i][j] = temp.charAt(0);
                if(map[i][j] == 'T')
                    teacher_list.add(new Pos(i,j));
            }
        }

        combi(0,0); //cnt, start;
        System.out.println(result);
    }

    private static void combi(int cnt, int start) {
        if(cnt == 3)
        {
            Queue<Pos> queue = new ArrayDeque<>();
            for(int i = 0; i < teacher_list.size(); i ++)
                queue.add(teacher_list.get(i));
            //step3 : 감시 따기
            bfs(queue);
            return;
        }

        for(int i = start; i < N * N; i ++)
        {
            int r = i / N;
            int c = i % N;

            if(map[r][c] == 'X') {
                map[r][c] = 'O';
                combi(cnt + 1, i + 1);
                map[r][c] = 'X';
            }
        }
    }

    private static void bfs(Queue<Pos> queue) {
        while(!queue.isEmpty())
        {
            Pos pos = queue.poll();
            for(int d = 0; d < 4; d ++)
            {
                int ni = pos.i + delta_i[d];
                int nj = pos.j + delta_j[d];
                while(0 <= ni && ni < N && 0 <= nj && nj < N)
                {
                    if(map[ni][nj] == 'S')
                        return;
                    else if(map[ni][nj] == 'O')
                        break;
                    ni += delta_i[d];
                    nj += delta_j[d];
                }
            }
        }

        result = "YES";
        System.out.println(result);
        System.exit(0);
    }


    private static void printArr(char[][] map)
    {
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
            {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
