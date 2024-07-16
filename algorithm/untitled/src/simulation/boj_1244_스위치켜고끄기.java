package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1244_스위치켜고끄기 {
    static int N, M;
    static boolean[] arr;
    static int cex, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            cex = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            if(cex == 1){ // 남자일떄
                for(int j = num; j <= N; j ++){
                    if ( j % num == 0){
                        arr[j - 1] = !arr[j - 1];
                    }
                }
            } else { // 여자 일 때
                int cnt = 1;
                num --;
                while (num - cnt >= 0 && num + cnt < N && arr[num - cnt] == arr[num + cnt]){
                    arr[num - cnt] = ! arr[num - cnt];
                    arr[num + cnt] = ! arr[num + cnt];
                    cnt ++;
                }
                arr[num] = !arr[num];
            }
        }

        for(int i = 0; i < N; i ++){
            if(i % 20 == 0 && i != 0)
                System.out.println();
            System.out.print(arr[i] ? 1 : 0);
            System.out.print(" ");
        }
        //System.out.println();
    }
}

/*
1부터 연속적으로 스위치 붙어있음
1은 켜있음, 0은 꺼져있음

남학생은 스위치 번호가 자기수의 배수이면 그 스위치 상태를 바꿈
여자는 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서 바꿈
학생의 성별과 받은 수가 주어짐
학생들은 입력되는 순서대로 바꿀때 마지막 상태 출력하는 프로그램 짜기
ㅋㅋ쉽노
문제를 끝까지 읽자
 */