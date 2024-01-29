package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이 문제의 해결 방법은 브루트포스로 0층 부터 256층까지 모든 블럭을 평평하게 만드는데 필요한 시간의 최소를 매번 비교하면 된다.
조금 더 생각을 해보면 0층 부터가 아니라 존재하는 블록 중 가장 작은 층 에서 존재하는 블록중 가장 높은 층 사이에 범위만 가능하므로 입력을 받을 때 최소와 최대 높이를 각각 지정하고 층수 반복을 돌 때 해당 최대 최소를 기준으로 돌면 된다.
 */

//step 1 : 입력받기, 입력받으면서 최대높이 최소높이 갱신하기
//step 2: 최소부터 최대까지 다 만들어보기 이때 걸리는 시간이 최소값이면 갱신하기
public class boj_18111_마인크래프트_최적화 {
    private static int N, M, B; // n = i, m = j
    private static int[][] map;
    private static int[][] copy;
    private static int max;
    private static int min;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        max = 0;
        min = 255;
        result = Integer.MAX_VALUE;
        int result_h = 0;
        map = new int[N][M];
        copy = new int[N][M];

        //step 1 : 입력받기, 입력받으면서 최대높이 최소높이 갱신하기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                max = Math.max(max, input);
                min = Math.min(min, input);
            }
        }

        //step 2: 최소부터 최대까지 다 만들어보기 이때 걸리는 시간이 최소값이면 갱신하기
        //생각해보니까 배열 카피가 리소스가 너무 많이든다.
        //차이를 이용해서 계산해야지,,
        for(int h = min; h <= max; h ++){
            //init
            int inven = B;
            int time = 0;

            for(int i = 0; i < N; i ++){
                for(int j = 0; j < M; j ++){
                    int diff = map[i][j] - h;
                    if(diff == 0) continue;
                    else if (diff > 0) {
                        inven += diff;
                        time += 2 * diff;
                    } else if (diff < 0) {
                        inven += diff;
                        time += Math.abs(diff);
                    }
                }
            }

            if(inven >= 0){
                if(result >= time){
                    result = time;
                    result_h = h;
                }
            }
        }

        System.out.println(result + " "+ result_h);
    }

    private static void makeArr(){
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < M; j ++){
                copy[i][j] = map[i][j];
            }
        }
    }
}
