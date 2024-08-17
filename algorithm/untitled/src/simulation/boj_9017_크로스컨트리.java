package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_9017_크로스컨트리 {
    static int TC;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            HashMap<Integer, Integer> cntHash = new HashMap<>();

            for (int i = 0; i < N; i++) { // step0 입력받기
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                cntHash.put(num, cntHash.getOrDefault(num, 0) + 1);
            }

            //step 1 순회하기
            HashMap<Integer, Integer> scoreHash = new HashMap<>();
            HashMap<Integer, Integer> checkHash = new HashMap<>();
            HashMap<Integer, Integer> fifthHash = new HashMap<>();
            int score = 1;
            for (int i = 0; i < N; i++) {
                int teamNum = arr[i];
                if (cntHash.get(teamNum) != 6)
                    continue;

                checkHash.put(teamNum, checkHash.getOrDefault(teamNum, 0) + 1);
                if (checkHash.get(teamNum) < 5) {
                    scoreHash.put(teamNum, scoreHash.getOrDefault(teamNum, 0) + score);
                } else if (checkHash.get(teamNum) == 5) {
                    fifthHash.put(teamNum, score);
                }
                score++;
            }

            //step2 최소값 도출하기
            int min = Integer.MAX_VALUE;
            int minKey = 0;
            for (int teamNum : scoreHash.keySet()) {
                //System.out.println(teamNum);
                //System.out.println(scoreHash.get(teamNum));
                if (scoreHash.get(teamNum) < min) {
                    min = scoreHash.get(teamNum);
                    minKey = teamNum;
                } else if (scoreHash.get(teamNum) == min) {
                    if (fifthHash.get(teamNum) < fifthHash.get(minKey)) {
                        minKey = teamNum;
                    }
                }
            }

            sb.append(minKey).append("\n");
        }
        System.out.print(sb);
    }

    /*
    step 0 입력받기
    - 배열에 값 저장하기
    - 해쉬 만들어서 빈도수 체킹하기

    step1 순회하기
    - 해쉬 체킹해서 빈도수가 6이 아닌건 패스
    - 6인건
        4까지 합 누적하기
        5인건 따로 픽업하기

    step3 최소값 도출하기
     */
}
/*
경주코스는 4에서 12
한 팀은 여섯명의 선수
팀 점수는 사우이 네명의 주자 점수 합해서 계산
가장 낮은 점수를 얻는 팀이 우승
여섯명의 주자가 참가하지 못한 팀은 계산에서 제외
동점의 경우에는 다섯번째 주자가 가장 빨리 들어온 팀이 우승
 */