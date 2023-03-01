package samsung_a_type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static class Stair
    {
        int r;
        int c;
        int k;

        public Stair(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    static class Person
    {
        int r;
        int c;
        int stair_time;
        int arrive_time;
        int stair;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private void getArriveTime()
        {

        }
    }

    static int T;
    static int N;
    static Queue<Person>[] qs;
    static ArrayList<Person> ps;
    static Stair[] stairs;
    static boolean[] visited;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for(int t = 1; t <= T; t ++)
        {
            N = scanner.nextInt();

            qs = new LinkedList[2];
            qs[0] = new LinkedList<>();
            qs[1] = new LinkedList<>();
            stairs = new Stair[2];
            ps = new ArrayList<>();

            int stairIdx = 0;
            for(int r = 1; r <= N; r ++)
            {
                for(int c = 1; c <= N; c ++)
                {
                    int num = scanner.nextInt();
                    if(num == 0)
                        continue;
                    else if(num == 1)
                        ps.add(new Person(r,c));
                    else
                    {
                        stairs[stairIdx] = new Stair(r,c,num);
                        stairIdx ++;
                    }
                }
            }

            dfs(0); // cnt;
        }
    }

    private static void dfs(int cnt) {
        if(cnt == ps.size())
        {
            return;
        }

        //첫번째 계단 방문
        ps.get(cnt).stair = 0;
        ps.get(cnt).getArriveTime();
        dfs(cnt + 1);

        //두번째 계단 방문
        ps.get(cnt).stair = 0;
        ps.get(cnt).getArriveTime();
        dfs(cnt + 1);
    }
}
