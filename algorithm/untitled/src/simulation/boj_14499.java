package simulation;

import java.util.Scanner;

public class boj_14499 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dice_for_EW = {3,1,4,6}; //동쪽서쪽
    static int[] dice_for_SN = {1,2,5,6}; //남쪽북쪽
    static int ew_cnt;
    static int sn_cnt;
    static int x,y; // start
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //info init
        N = scanner.nextInt();
        M = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        int command_cnt = scanner.nextInt();

        // map init
        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j ++)
                map[i][j] = scanner.nextInt();

        //command init
        for(int i = 0; i < command_cnt; i ++)
        {
            int command = scanner.nextInt();
            dice(x,y,command);
        }
    }

    private static void dice(int x, int y, int command) {


        // 동쪽 1, 서쪽 2
        if(command == 1 || command == 2)
        {
            
            ew_cnt ++;
            dice_for_EW[(ew_cnt - 1) % 4]
        }

        //남쪽, 북쪽
        else
        {

        }
    }
}
