package samsung_a_type;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2023.04.10.월 모의 AD 역량테스트 1번. 업무 완료하기
 * <p>
 * 난이도 상? 디버깅 많이 했음
 */
public class Solution_업무완료하기 {
    private static ArrayList<Integer>[] pre;
    private static int[] memo;
    private static int[] time;
    private static boolean[] visited;
    private static boolean cycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine()); // 50개의 테스트 케이스
        for (int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine()); // 완료해야 하는 업무의 수 N, (1 ≤ N ≤ 50)
            time = new int[N + 1]; // 업무 소요시간, 0번은 안씀 (업무의 index로 추적해야해서, 1번부터 저장)
            pre = new ArrayList[N + 1]; // 미리 완료해야하는 업무번호
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                time[i] = Integer.parseInt(st.nextToken()); // 업무별 소요시간은 2이상 1,000 이하
                int M = Integer.parseInt(st.nextToken()); // 미리 완료해야 하는 업무들의 개수 M, (0 ≤ M ≤ N-1)
                pre[i] = new ArrayList<Integer>();
                for (int j = 0; j < M; j++) {
                    pre[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            cycle = false; // 순환관계, 업무 전체에서 일부분이라도 순환관계가 있다면, 김수석 도움과 상관없이 순환관계 발생함 -1출력
            int minTotalTime = Integer.MAX_VALUE; // 모든 업무를 완료하기 위해 필요한 최소 소요시간
            ex:
            for (int help = 1; help <= N; help++) { // 김수석이 도와주는 업무 번호
                memo = new int[N + 1]; // 업무를 수행하는 소요시간 저장
                visited = new boolean[N + 1]; // 순환 체크하기 위한 방문배열, 각 업무별로 새로 다시 체크 [순환체크배열 초기화를 for문 한단계 위로 하면 안맞음]
                int totalTime = 0; // 전체 업무를 완료 소요시간 = 각 업무별 가장 오래 걸리는 시간임

                for (int i = 1; i <= N; i++) { // i번째 업무의 시간 구함
                    visited[i] = true;
                    int iTime = check(i, help); // i번째 업무의 시간
                    visited[i] = false;
                    if (cycle) { // 순환관계 발생시 탈출
                        minTotalTime = -1;
                        break ex;
                    }
                    if (totalTime < iTime) totalTime = iTime;
                }
                if (minTotalTime > totalTime) minTotalTime = totalTime; // 모든 업무를 완료하기 위해 필요한 최소 소요시간 업데이트
            } // end of for help

            sb.append("#").append(testCase).append(" ").append(minTotalTime).append("\n");
        } // end of for testCase
        System.out.print(sb.toString());
    } // end of main

    /**
     * index 번째 업무를 수행하는 소요시간 리턴, help 김수석이 도와줄 업무번호
     */
    private static int check(int index, int help) {
        if (cycle) return -1;
        if (memo[index] > 0) return memo[index];

        int maxPreWorkTime = 0; // index 번째 업무를 하기위해 미리 완료해야하는 업무들의 최대값 저장
        for (int i = 0; i < pre[index].size(); i++) {
            if (visited[pre[index].get(i)]) { // 이미 방문했다면 순환관계 [if 체크하는 코드를 check 재귀함수 처음으로 빼면 안맞음]
                cycle = true; // 순환관계
                return 0;
            }

//		업무번호 		1	2	3	4
//		선행업무목록	24	3	4	-
//		1업무의 작업시간을 구하는과정에서, 2,4업무가 미리 완료되어야함
//			이때 2, 4 미리 완료할 업무도 따로 방문체크를 해함. 
//			위 예시에서 보면, 순환관계는 아니지만, 2번 업무 4번업무를 (방문체크 원복안하고) 함께 처리하면 순환관계로 나옴

            visited[pre[index].get(i)] = true;
            int workTime = check(pre[index].get(i), help); // pre[index].get(i) 업무하기 위한 작업시간
            if (maxPreWorkTime < workTime) maxPreWorkTime = workTime;
            visited[pre[index].get(i)] = false;
        }

        return memo[index] = maxPreWorkTime + (index == help ? time[index] / 2 : time[index]);
    }
} // end of class

/*
[input]
5
3
194 0
755 0
3 0
5
676 0
586 1 3
544 0
365 2 3 5
541 0
5
826 2 3 5
673 2 4 5
863 1 2
87 0
654 2 3 4
30
434 18 23 3 19 24 2 22 14 17 9 27 10 21 20 5 28 12 30 11
276 8 11 6 17 28 9 10 20 19
897 14 2 17 6 21 11 24 14 5 22 9 12 30 28 20
890 20 20 10 9 12 14 24 28 23 30 13 27 6 19 21 11 17 18 26 5 3
860 12 24 27 19 21 28 22 9 2 11 23 6 12
923 2 17 12
935 16 17 14 10 26 12 28 30 19 6 20 27 21 2 1 11 22
933 24 4 14 10 18 26 7 11 28 5 24 1 20 29 3 9 12 22 16 2 6 13 27 30 23
731 6 24 17 11 10 19 12
879 0
256 4 24 12 10 6
147 1 17
774 16 21 20 10 11 19 5 28 6 14 1 26 27 3 2 30 9
302 10 17 11 10 24 2 9 12 19 27 20
145 27 17 9 12 5 1 16 29 11 27 8 21 18 3 22 14 13 10 30 28 6 23 24 19 2 7 26 4
165 19 20 2 17 26 11 21 13 27 14 28 4 19 22 7 10 30 5 3 1
590 0
866 17 14 30 5 21 1 19 12 6 28 20 17 11 10 3 2 24 13
352 6 27 12 11 20 10 24
21 0
244 12 23 30 12 14 28 2 22 11 24 10 20 6
485 10 28 10 2 9 20 14 12 19 17 27
823 12 9 6 17 12 19 30 24 11 27 22 14 20
632 3 12 17 10
105 21 14 7 5 18 10 6 20 3 15 4 28 1 12 13 8 26 22 24 19 16 23
89 18 21 27 10 5 12 30 3 6 20 24 23 28 9 17 1 19 2 11
452 3 24 12 10
65 9 9 17 6 11 20 19 24 27 12
951 23 26 6 30 10 14 17 22 16 2 7 18 24 13 27 5 20 19 12 4 3 21 9 1
3 11 14 10 6 11 22 9 27 24 19 2 17
30
586 20 4 21 22 14 8 15 29 10 19 28 18 23 5 7 6 26 24 2 30 9
296 19 4 9 22 10 7 21 30 14 19 24 18 23 28 6 5 29 8 26 15
878 28 20 21 25 19 2 17 10 4 11 23 29 6 12 1 18 26 24 27 28 30 15 13 8 7 22 9 5 14
241 18 5 7 8 23 24 28 18 19 30 6 10 9 15 21 14 22 29 26
274 10 22 15 6 30 14 9 19 8 10 24
52 7 15 24 9 19 14 22 10
590 17 22 9 24 26 14 19 18 6 21 30 23 10 28 5 15 29 8
51 9 9 24 19 22 14 10 30 15 6
171 5 14 15 22 19 24
733 6 14 15 9 22 24 19
193 22 15 18 30 7 9 13 14 1 4 8 29 19 21 10 24 6 5 2 23 22 26 28
807 26 4 30 22 23 11 5 15 21 18 9 24 7 8 19 26 1 27 25 6 29 28 14 17 13 2 10
676 21 19 21 2 15 29 23 28 30 26 14 7 6 9 22 1 8 18 4 10 5 24
454 4 24 22 15 19
5 1 19
578 29 10 19 7 11 30 1 25 14 22 29 28 2 5 18 24 26 6 21 23 20 27 12 13 3 17 9 15 4 8
944 24 8 13 9 23 21 18 15 7 22 6 5 4 26 29 14 1 27 11 30 24 2 28 19 10
895 13 28 30 15 9 5 23 22 6 14 24 19 10 8
954 0
272 27 13 5 21 8 17 2 1 28 12 26 29 6 22 10 23 24 14 27 7 9 15 18 11 19 4 25 30
162 15 24 23 9 10 22 15 5 19 26 28 14 8 6 18 30
580 2 15 19
241 12 30 9 14 28 24 10 19 22 15 6 5 8
174 3 22 19 15
228 25 24 23 19 21 10 2 8 18 17 30 27 9 5 26 14 11 15 7 13 22 29 28 4 6 1
502 14 24 30 5 19 22 10 23 28 18 9 15 6 8 14
365 23 9 14 8 1 7 23 15 30 10 13 29 5 6 21 24 22 18 19 28 11 26 4 2
336 11 9 22 14 5 30 19 24 8 10 6 15
911 16 30 8 28 5 10 6 24 18 22 26 21 15 14 23 9 19
606 8 15 9 14 24 22 10 6 19

[output]
#1 377
#2 906
#3 -1
#4 11877
#5 13278

*/