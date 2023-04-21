package simulation;

import java.util.Scanner;


/*
문제 리뷰
N * M 크기의 직사각형으로 나타낼수 있음
k개의 cctv 설치되어있음.
1번 씨티는 한 쪽 방향만 감시가능
2번 3번은 두 방향, 2번은 서로 반대방향이어야함.
3번은 직각, 4번은 세방향, 5번은 4방향
감시할 수 있는 방향에 있는 칸 전체 감시 가능, 근데 벽은 통과 x
회전은 항상 90도 방향으로.. 감시하려고 하는 방향이 가로 또는 세로방향이어야함
0은 빈칸, 6은 벽, 벽을 통과할수 없고 cctv는 통과 할 수 있음
사각지대 최소크기 구해보자
 */

/*
접근
dfs, 백트래킹, 완전탐색
map을 입력받다가 카메라라면 따로 리스트에 저장

리스트들에 있는것들을 기준으로 완탐 시행
dfs()
    기저조건 -> 리스트 사이즈만큼
    리스트가 1일때 경우의 수 4, restore
    리스트가 2일때 경우의 수 2, restore
    리스트가 3일때 경우의 수 4, restore
    리스트가 4일때 경우의 수 4, restore
 */
public class boj_15683_감시 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
    }
}
