package simulation;

/*
1.스티커를 회전시키지 않고 모눈 종이에서 떼어낸다.
2. 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일수 있는 위치를 찾는다.
    노트북의 위쪽부터 스티커를 채워나가려고해서, 붙일수있는위치가 여러곳이라면 가장 위쪽의 위지를 선택한다.
3.선택한 위치에 스티커를 붙인다. 붙일수 있는 위치가 전혀 없다면 90도 회전해서 2를 반복한다.
4. 위의 과정을 네번 반복해서 스티커를 회전시켜봤음에도 붙일수 없다면, 스티커는 버린다.
 */

// step1
//붙일수있는지 체킹하는 함수 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// step2
// 돌리기 함수 만들기
public class boj_18808_스티커붙이기 {
    static int N;
    static int M;
    static int K;
    static int sum = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        // step 0
        for (int k = 0; k < K; k++) { // 스티커 입력받기
            st = new StringTokenizer(br.readLine(), " ");

            //종이 입력받기
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < c; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            A:
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (isAttach(sticker, i, j)) {
                            attach(sticker, i, j);
                            break A;
                        }
                    }
                }
                sticker = rotate(sticker, sticker.length, sticker[0].length);
            }

        }
        System.out.println(sum);
    }

    private static boolean isAttach(int[][] sticker, int r, int c) { //r,c = 붙여야할 위치의 시작지점
        int stickerR = sticker.length;
        int stickerC = sticker[0].length;

        for (int i = 0; i < stickerR; i++) {
            for (int j = 0; j < stickerC; j++) {
                int ni = r + i;
                int nj = c + j;

                if (!(0 <= ni && ni < N && 0 <= nj && nj < M)) // 범위 벗어나서 못붙임
                    return false;

                if (sticker[i][j] == 1 && paper[ni][nj] == 1) // 이미 무언가 붙어있어서 못붙임
                    return false;
            }
        }

        return true;
    }

    private static void attach(int[][] sticker, int r, int c) {
        int stickerR = sticker.length;
        int stickerC = sticker[0].length;

        for (int i = 0; i < stickerR; i++) {
            for (int j = 0; j < stickerC; j++) {
                if (sticker[i][j] == 1) {
                    paper[i + r][j + c] = 1;
                    sum++;
                }
            }
        }
    }

    public static int[][] rotate(int[][] sticker, int r, int c) { // 5 2
        int[][] rotatedSticker = new int[c][r];

        for (int i = 0; i < r; i++) { //5
            for (int j = 0; j < c; j++) { // 2
                rotatedSticker[j][r - i - 1] = sticker[i][j]; // 2 5
            }
        }

        return rotatedSticker;
    }
}
