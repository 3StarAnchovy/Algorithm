package samsung_2025.sample;

public class RotateArr {
    static int N,M;
    static int[][] arr;
    public static void main(String[] args) {
        N = 5;
        M = 5;

        arr = new int[N][M];

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                arr[i][j] = i*M + j;
            }
        }

        printArr();
        rotateArrBorder();
        printArr();
    }
    public static void printArr() {
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < M; j ++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateArrBorder() {
        int n = N;
        int m = M;

        // 왼쪽 위 값 저장
        int temp = arr[0][0];

        // 위쪽 행 이동
        for (int j = 0; j < m - 1; j++) {
            arr[0][j] = arr[0][j + 1];
        }

        // 오른쪽 열 이동
        for (int i = 0; i < n - 1; i++) {
            arr[i][m - 1] = arr[i + 1][m - 1];
        }

        // 아래쪽 행 이동
        for (int j = m - 1; j > 0; j--) {
            arr[n - 1][j] = arr[n - 1][j - 1];
        }

        // 왼쪽 열 이동
        for (int i = n - 1; i > 1; i--) {
            arr[i][0] = arr[i - 1][0];
        }

        // 저장해둔 값 삽입
        arr[1][0] = temp;

        System.out.println("================시계방향으로 회전 ===============");
    }
}
