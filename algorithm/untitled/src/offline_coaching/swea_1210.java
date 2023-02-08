//package offline_coaching;
//
//import java.util.Scanner;
//
//public class swea_1210 {
//    static int col;
//    static int N;
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        for(int T = 1; T <= 10; T++)
//        {
//            N = 100;
//            int tc = scanner.nextInt();
//            int[][] ladder = new int[100][100];
//
//            //input
//            for(int i = 0; i < 100; i ++)
//            {
//                for(int j = 0; j < 100; j ++)
//                    ladder[i][j] = scanner.nextInt();
//            }
//
//            for(int i = 0; i < N; i ++)
//            {
//                if (ladder[N - 1][i] == 2)
//                    col = i;
//            }
//
//            for(int row = N - 1; row >= 0; row --)
//            {
//                if(col != 0 && ladder[row][col - 1] == 1)
//                    moveLeft();
//                else if(col != N - 1 && ladder[row][col + 1] == 1)
//                    moveRight();
//            }
//
//            System.out.println(col);
//        }
//
//        //마지막 행에서 2를 탐색하여 열 정보 저장
//
//    }
//
//    //다음칸이 경게를 넘어가지 않고, 1이라면 이동
//    private static void moveLeft(int row) {
//        while(col - 1 >= 0 && ladder[row][col - 1] == 1)
//            col --;
//    }
//
//    private static void moveLeft(int row) {
//        while(col + 1 < N && ladder[row][col + 1] == 1)
//            col ++;
//    }
//}
