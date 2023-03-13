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

    static class Egg {
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
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        visited = new boolean[N];
        eggs = new Egg[N];
        picked = new int[N];

        for (int i = 0; i < N; i++) {
            int hp = scanner.nextInt();
            int weight = scanner.nextInt();
            eggs[i] = new Egg(hp, weight);
        }

        dfs(0); // cnt;
        System.out.println(max);
    }

    private static void dfs(int cnt) {
        int break_cnt = 0;
        for(int i = 0; i < N; i ++)
        {
            if(eggs[i].hp <= 0)
                break_cnt ++;
        }
        max = Math.max(max,break_cnt);

        if (cnt == N) {
            //여기까지 못오는 가지가 있음 여기서 계산하면 안돼 시발
            return;
        }

        if (eggs[cnt].hp > 0) {
            for(int i = 0; i < N; i ++)
            {
                if(eggs[i].hp > 0 && i != cnt)
                {
                    eggs[cnt].hp -= eggs[i].weight;
                    eggs[i].hp -= eggs[cnt].weight;
                    dfs(cnt + 1);
                    eggs[cnt].hp += eggs[i].weight;
                    eggs[i].hp += eggs[cnt].weight;
                }
            }
        }

        else
            dfs(cnt + 1);
    }

    //깨졌을 때 false
    //안깨졌을 때 true
    private static boolean isBroken(Egg egg) {
        if (egg.hp <= 0)
            return false;
        return true;
    }

}
