package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_15486_퇴사 {
    static class Pos {
        int num;
        String com;

        public Pos(int num, String com) {
            this.num = num;
            this.com = com;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(bfs(start, end));
        }
    }

    private static String bfs(int start, int end) {
        Queue<Pos> que = new ArrayDeque<>();
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        hashMap.put(start, true);
        que.add(new Pos(start,""));

        while (!que.isEmpty()) {
            int qSize = que.size();

            while (qSize-- > 0) {
                Pos pos = que.poll();
                int num = pos.num;

                if(pos.num == end) {
                    return pos.com;
                }

                //d
                if (num * 2 > 9999 && isVisited(2 * num % 10000, hashMap)) {
                    que.add(new Pos(2 * num % 10000,pos.com+"D"));
                    hashMap.put(2 * num % 10000, true);
                } else if(isVisited(num*2,hashMap)) {
                    que.add(new Pos(num * 2,pos.com+"D"));
                    hashMap.put(num * 2, true);
                }

                //s
                if (num == 0 && isVisited(9999, hashMap)) {
                    que.add(new Pos(9999,pos.com + "S"));
                    hashMap.put(9999,true);
                } else if (isVisited(num-1,hashMap)) {
                    que.add(new Pos(num - 1, pos.com+"S"));
                    hashMap.put(num -1 ,true);
                }

                //l
                int nPos = rotate(pos.num,'l');
                if(isVisited(nPos, hashMap)) {
                    que.add(new Pos(nPos, pos.com + "L"));
                    hashMap.put(nPos,true);
                }

                //r
                nPos = rotate(pos.num,'r');
                if(isVisited(nPos, hashMap)) {
                    que.add(new Pos(nPos, pos.com + "R"));
                    hashMap.put(nPos,true);
                }
            }
        }

        return "";
    }

    private static boolean isVisited(int num, HashMap<Integer, Boolean> hash) {
        return hash.get(num) == null;
    }

    private static int rotate(int num, char dir) {
        int[] d = new int[4];

        for (int i = 3; i >= 0; i--) {
            d[i] = num % 10;
            num /= 10;
        }

        int sum = 0;
        if (dir == 'l') {
            sum += d[1] * 1000;
            sum += d[2] * 100;
            sum += d[3] * 10;
            sum += d[0];
        } else if(dir == 'r') {
            sum += d[3] * 1000;
            sum += d[0] * 100;
            sum += d[1] * 10;
            sum += d[2];
        }

        return sum;
    }
}

/*
네개의 명령어 D,S,L,R

d는 n을 두배로 바꿈
근데 결과값이 9999보다 큰 경우 10000으로 나눈 나머지

s는 n-1 1을 뺀 저장
근데 n이 0이면 9999가 대신 저장됨

l은 각 자리수를 왼편으로 이동

r은 각 자리수를 오른편으로 회전시킴

a->b 최소 명령어 : bfs

 */