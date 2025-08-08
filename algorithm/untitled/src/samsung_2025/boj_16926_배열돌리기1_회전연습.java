package samsung_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926_배열돌리기1_회전연습 {
    static int N,M,R;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //step0. 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //step1 n,m 중 작은거 찾아서 2로 나누기 -> 해당 몫이 반복횟수
        int cnt = Math.min(N,M);
        cnt /= 2;

        //step2. 회전수만큼 반복
        for(int i = 0; i < R; i ++) {
            rotateArr(cnt);
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void rotateArr(int cnt) {
        //몫만큼 반복
        for(int i = 0; i < cnt; i ++) {
            //꼭지점 카피
            int copy = arr[i][i];

            //위
            for(int j = i + 1; j < M - i; j ++) {
                arr[i][j-1] = arr[i][j];
            }

            //오른쪽
            for(int j = i + 1; j < N - i; j ++) {
                arr[j - 1][M - 1 - i] = arr[j][M - 1 - i];
            }

            //아래 // 역방향으로 해야함 시발 ;
            for (int j = M - 2 - i; j >= i; j--) {
                arr[N - 1 - i][j + 1] = arr[N - 1 - i][j];
            }

            //왼쪽
            for (int j = N - 2 - i; j >= i; j--) {
                arr[j + 1][i] = arr[j][i];
            }

            arr[i + 1][i] = copy;
        }
    }
}

/*
step0
입력받기

step1
n,m 중 작은거 찾아서 2로 나누기
 -> 해당 몫이 반복횟수

step2
회전 수 만큼 반복
 - 몫만큼 반복
 - 꼭지점 카피 따고
 - 반시계 방향으로 돌리기
   * 위,오른쪽,아래,왼쪽 왼쪽 마지막에는 카피딴거 넣기

 */
