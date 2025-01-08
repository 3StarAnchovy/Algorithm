package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_20055_컨베이어벨트위의로봇 {
    static class Pos {
        int hp;
        boolean hasPos;

        public Pos(int hp, boolean hasPos) {
            this.hp = hp;
            this.hasPos = hasPos;
        }
    }

    static int N, K;
    static Pos[] arr;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int upIdx;
    static int downIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        downIdx = N - 1;
        upIdx = 0;
        K = Integer.parseInt(st.nextToken());

        arr = new Pos[2 * N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            int hp = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(hp, false);
        }

        int cnt = 0;
        int step = 0;
        while (cnt < K) {
            step++;
            move();
            print(1);
            cnt += step2();
            print(2);
            cnt += step3();
            print(3);


        }

        System.out.println(step);
    }

    public static void print(int step) {
        System.out.println(upIdx + " " + downIdx);
        System.out.println("step : " + step);
        for(int i = 0; i < 2 * N; i ++) {
            System.out.print(arr[i].hp + " ");
        }
        System.out.println();
    }

    //1.벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전.
    public static void move() {
        int len = 2 * N;
        upIdx = (upIdx + 1 + len) % len; //올리는 위치의 넘버
        downIdx = (downIdx + 1 + len) % len;

        //내리는 위치에 로봇 있으면 내리기
        arr[downIdx].hasPos = false;
    }

    //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한칸 이동할수 있다면 이동함.
    //이동할수 없으면 가만히 있음
    public static int step2() {
        int res = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i].hasPos) {
                if (!arr[i + 1].hasPos && arr[i + 1].hp >= 1) {
                    arr[i].hasPos = false;
                    arr[i + 1].hasPos = true;
                    arr[i + 1].hp -= 1;

                    if (i == downIdx)
                        arr[downIdx].hasPos = false;

                    if (arr[i + 1].hp == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }

    //올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    public static int step3() {
        if (arr[upIdx].hp > 0) {
            arr[upIdx].hp--;
            arr[upIdx].hasPos = true;

            if (arr[upIdx].hp <= 0)
                return 1;
        }
        return 0;
    }
}

    /*
    로봇을 올리는 위치에 올리거나, 어떤칸으로 이동하면 내구도는 1만큼 감소

    로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며,
    그 칸의 내구도가 1이상남아있어야함.

    4. 내구도가 0인 칸의 개수가 k개 이상이라면 과정 종료함
        아니면 1번으로 돌아감
     */
