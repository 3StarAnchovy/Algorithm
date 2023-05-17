package simulation;

import java.util.Scanner;

public class boj_10836_여왕벌 {
    static int N, M; //M이 크기임!
    static int[][] map;
    static int[][] origin;
    static int[][] diff_map;
    static int[] delta_i = {0,-1,-1}; //왼쪽, 왼쪽 위, 위
    static int[] delta_j = {-1,-1,0};
    static int[] grow_arr;
    public static void main(String[] args)
    {
        //step1 입력받기
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        map = new int[M][M];
        origin = new int[M][M];
        diff_map = new int[M][M];
        grow_arr = new int[2 * M - 1]; //성장값 입력받을 배열

        //애벌레 크기 1로 초기화
        for(int i = 0; i < M; i ++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = 1;
                origin[i][j] = 1;
            }
        }
        //성장값 입력
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < (2 * M - 1); j ++)
                grow_arr[j] = scanner.nextInt();
            //성장값 다 입력 받았으면 성장 시행
            growLarva();
        }
    }

    private static void growLarva() {
        copyArr();
        //입력값 토대로 왼쪽 외곽 열, 행 성장
        int grow_idx = 0;
        for(int i = M - 1; i >= 0; i --)
            map[i][0] += grow_arr[grow_idx ++];
        for(int i = 1; i < M; i ++)
            map[0][i] += grow_arr[grow_idx ++];

        int t = 1;
        while(t < M)
        {
            sideEffect(t);

        }
        //sideEffect 구현
        //printArr(map);
        //입력값 토대로 왼쪽 외곽 열, 행 성장
    }

    private static void sideEffect(int t) {
        getDiff();
    }

    private static void getDiff() {
        for(int i = 0; i < M; i ++)
            for(int j = 0; j < M; j ++)
                diff_map[i][j] = map[i][j] - diff_map[i][j];
    }

    private static void printArr(int[][] map)
    {
        for(int i = 0; i < M; i ++)
        {
            for(int j = 0; j < M; j ++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
    private static void copyArr() {
        for(int i = 0; i < M; i ++)
            for(int j = 0; j < M; j ++)
                diff_map[i][j] = map[i][j];
    }
}
