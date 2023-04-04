package samsung_a_type;

import java.util.*;

/*
문제 - 각 벌통에 있는 꿀의 양이 주어졌을 때, 벌꿀을 채휘하여 최대한 많은 수익 얻으려함
 */

/*
접근
조합으로 하려함, visted를 곁들인

step1
    조합으로 벌통 선택
    벌통 N * N 완전탐색 시행
        벌통을 연속해서 픽할수 없으면? -> 거름
        벌통이 이전에 선택된적이 있다면? -> 거름

step2
    기저조건 찍히면 이익 계산 -> 최대값이면 갱신
    유효한 벌통 조합들이 picked에 저장되어있다.
    해당 picked를 행 단위로 부분집합을 이용하여, 각 행의 최대 이익을 구하여 다 더해보자
 */
public class swea_2115_벌꿀채취 {
    static int N, M, C; // n : 벌통 크기, M : 선택할 수 있는 벌통 개수, c : 꿀을 채취할 수 있는 최대 양
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            C = scanner.nextInt();
        }
    }
}
