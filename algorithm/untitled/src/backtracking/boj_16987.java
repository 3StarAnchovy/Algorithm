package backtracking;

import java.util.*;

/*
게란으로 계란을 치면, 각 계란의 내구도는 상대 계란의 무게만큼 깎임

접근
- 배열에 담음
- 계란 순서에 대한 상태도를 그려야하므로 순열로 접근
- 계란 action 수행 후 계란 깨진 횟수 cnt ++
 */
public class boj_16987 {
    static int N;
    static class Egg
    {
        int hp;
        int weight;

        public Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }

    }
    static Egg[] eggs;
    static int[] picked;
    static boolean[] visited;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        visited = new boolean[N];
        eggs = new Egg[N];
        picked = new int[N];

        for(int i = 0; i < N; i ++)
        {
            int hp = scanner.nextInt();
            int weight = scanner.nextInt();
            eggs[i] = new Egg(hp,weight);
        }

        perm(0); //cnt
    }

    private static void perm(int cnt) {
        if(cnt == N)
        {
            eggAction();
            return;
        }

        for(int i = 0; i < N; i ++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                picked[cnt] = i;
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    /*

     */
    private static void eggAction() {
        ArrayList<Egg> egg_order = new ArrayList<>();

        for(int i = 0; i < 3; i ++)
        {
            egg_order.add(eggs[picked[i]]);
        }
        //게란이 다 깨질 때까지 ㅇㅇ
        for(int i = 0; i < N -1; i ++)
        {
            for(int j = 1; j < N; j ++)
            {

            }
        }
    }
}
