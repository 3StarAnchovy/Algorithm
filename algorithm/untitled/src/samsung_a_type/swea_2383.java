package samsung_a_type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_2383 {
    static int T;
    static int N;

    static class Stair {
        int r;
        int c;
        int k;

        public Stair(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    static class Person {
        int r;
        int c;
        int stair;
        int arr_time;
        int stair_time;

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private void calArriveTime()
        {
            this.arr_time = Math.abs(r - stairs[stair].r) + Math.abs(c - stairs[stair].c);
        }
    }

    static ArrayList<Person> persons;
    static Queue<Person>[] qs;
    static boolean[] visited;
    static Stair[] stairs;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            N = scanner.nextInt();
            persons = new ArrayList<>();
            qs = new LinkedList[2];
            qs[0] = new LinkedList<>();
            qs[1] = new LinkedList<>();
            stairs = new Stair[2];
            result = Integer.MAX_VALUE;

            int stairIdx = 0;

            //init
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    int num = scanner.nextInt();
                    if (num == 0)
                        continue;
                    else if (num == 1)
                        persons.add(new Person(r, c));
                    else {
                        stairs[stairIdx] = new Stair(r, c, num);
                        stairIdx++;
                    }
                }
            }

            dfs(0); //cnt;
            System.out.println(result);
        }
    }

    private static int simulation()
    {
        int cnt = 0;
        int time = 1;

        while(true)
        {
            for(Queue<Person> q : qs)
            {
                int size = q.size();

                for(int i = 0; i < size; i ++)
                {
                    Person p = q.poll();
                    Stair s= stairs[p.stair];

                    if(p.stair_time + s.k <= time)
                        continue;
                    q.offer(p);
                }

            }
            if(cnt == persons.size() && qs[0].isEmpty() && qs[1].isEmpty())
            {
                return time;
            }

            for(int i = 0; i < persons.size(); i ++)
            {
                if(visited[i])
                    continue;

                Person p = persons.get(i);
                Queue<Person> q = qs[p.stair];

                if(p.arr_time + 1 <= time && q.size() < 3)
                {
                    p.stair_time = time;
                    visited[i] = true;
                    q.offer(p);
                    cnt ++;
                }
            }

            time ++;
            //while 한번당 1초
        }
    }

    private static void dfs(int cnt) {
        if(cnt == persons.size())
        {
            visited = new boolean[persons.size()];

            int cur = simulation();
            if(result > cur)
                result = cur;
            return;
        }

        //부분집합
        //첫번째 계단 이용
        persons.get(cnt).stair = 0;
        persons.get(cnt).calArriveTime();
        dfs(cnt + 1);

        //두번째 계단 이용
        persons.get(cnt).stair = 1;
        persons.get(cnt).calArriveTime();
        dfs(cnt + 1);
    }
}
