package backtracking;

import java.util.Scanner;

/*
접근 1
승 패 무 합쳐서 5
팀별로 총 30경기
완전탐색으로 할 수 있지 않을까
무승부가 너무 까다로움

접근 2
승 무 패 토탈을 알고 있음
dfs로 접근할 수 있을거같다.
 */
public class boj_6987 {
    static int[] win;
    static int[] lose;
    static int[] draw;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        for(int tc  = 0; tc < 4; tc ++)
        {
            win = new int[6];
            lose = new int[6];
            draw = new int[6];
            for(int t = 0; t < 6; t ++) // team
            {
                win[t] = scanner.nextInt();
                draw[t] = scanner.nextInt();
                lose[t] = scanner.nextInt();

                dfs(0,0, 1); //cnt, team, enemy
            }
        }
    }

    /*
    - 총 경기는 15경기
    a - b c d e f
    b - c d e f
    c - d e f
    d - e f
    e - f

    경기의 상태는 3이므로 3 ^ 15 (승 무 패)
    테스트 케이스 하나당 O(3 ^ 15)

    한 경기에서 어떻게든 승 패 무가 나옴
    cnt를 늘리면서 재귀 호출 -> 승 패 무의 경우를 나눠서 호출
    승 패 무 세개중에 하나라도 딸리면 불가능
    cnt가 15일 때 승패무가 전부 0이면 가능
     */
    private static void dfs(int cnt, int team, int enemy) {
        //종료조건
        if(cnt == 0) // 승패
        {
            return;
        }

        if(cnt == 0)
        {
            return;
        }
        if (cnt == 15) //모든 경기 (15) 경기를 마치고 나서
        {
            return;
        }

        //유도파트
        //cnt가 5, 9, 12, 14 일때 team 증가 enemy idx를 1로 초기화
        if(cnt == 5) {// a 경기 다 끝날 때
            team++;
            enemy = 1;
        }
        if(cnt == 9) {// b 경기 다 끝날 때
            team++;
            enemy = 1;
        }
        if(cnt == 12) {// c 경기 다 끝날 때
            team++;
            enemy = 1;
        }
        if(cnt == 14) {
            team++;
            enemy = 1;
        }
        if(cnt == 15) {
            team++;
            enemy = 1;
        }
        //승리
        win[team] --;
        lose[team + enemy] --;
        dfs(cnt + 1, team, enemy + 1);
        win[team] ++;
        lose[team + enemy] ++;

        //무승부
        draw[team] --;
        draw[team + enemy] --;
        dfs(cnt + 1, team, enemy + 1);
        draw[team] ++;
        draw[team + enemy] ++;

        //패배
        win[team] --;
        lose[team + enemy] --;
        dfs(cnt + 1, team, enemy + 1);
        win[team] ++;
        lose[team] ++;
    }
}
