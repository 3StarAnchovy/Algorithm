package 끄적끄적;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import java.util.*;

class Test2 {
    static int sN;

    public int solution(int n, int[][] wires) {
        sN = n;
        for (int i = 0; i < wires.length; i++) {
            int cnt = bfs(i, wires);
        }

        return 0;
    }

    private static int bfs(int cutIdx, int[][] wires) {
        Queue<Integer> que = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited;

        visited = new boolean[sN + 1];

        for (int i = 0; i <= wires.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            if (i != cutIdx) {
                list.get(wires[i][0]).add(wires[i][1]);
                list.get(wires[i][1]).add(wires[i][0]);
            }
        }
        return -1;
    }
}

/*
0418
n개의 송전탑이 전선을 통해 하나의 트리로 있음
하나 끊어서, 전력망 네트워크를 2개로 분할하려고함
두 전력망이 갖게되는 송전탑 개수를 최대한 비슷하게 맞추려함
*/