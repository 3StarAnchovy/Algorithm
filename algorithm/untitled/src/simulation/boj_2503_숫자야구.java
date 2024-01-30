package simulation;


/*
세자리 수의 동일한 위치에 있으면 스트라이크, 숫자는 일치하나 다른자리에 있으면 볼

가능한 숫자 123 ~ 987 만들기

입력 한줄 받을때마다 볼과 스트라이크의 수 계산하기
계산 후 입력값과 비교해서 맞으면 true 아니면 false

모든 입력이 끝나고, 가능한수 중 true인거 카운팅하기
체킹하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2503_숫자야구 {
    private static boolean[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //step 1 가능한 숫자 123 ~ 987 만들기
        num = new boolean[999];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i != j) {
                    for (int k = 1; k <= 9; k++) {
                        if (k != j && k != i) {
                            num[100 * i + 10 * j + k] = true;
                        }
                    }
                }
            }
        }

        //step2 입력 한줄 받을때마다 볼과 스트라이크의 수 계산하기
        // 계산 후 입력값과 비교해서 맞으면 true 아니면 false
        String input = null;
        int strike = 0, ball = 0;
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");

            input = st.nextToken();
            strike = Integer.parseInt(st.nextToken());
            ball = Integer.parseInt(st.nextToken());

            for (int i = 123; i <= 987; i++) {
                if (num[i]) {
                    int sCnt = 0;
                    int bCnt = 0;
                    String one = Integer.toString(i);
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            if (one.charAt(a) == input.charAt(b) && a == b) {
                                sCnt++;
                            } else if (one.charAt(a) == input.charAt(b)) {
                                bCnt++;
                            }
                        }
                    }

                    if (strike == sCnt && ball == bCnt) {
                        num[i] = true;
                    } else
                        num[i] = false;
                }
            }
        }

        int result = 0;
        for (int i = 123; i <= 987; i++) {
            if (num[i])
                result++;
        }

        System.out.println(result);
    }
}
