package mid;

import java.util.Scanner;

public class CheckSudoko {
    public static int checkRow(int[][] inputArray)
    {
        for(int i = 0; i < 9; i ++)
        {
            int[] row_check = new int[9];
            for(int j = 0; j < 9; j ++)
            {
                row_check[j] ++;
                if(row_check[j] != 1)
                    return 0;
            }
        }
        return 1;
    }
    public static int checkCol(int[][] inputArray)
    {
        int[][] col_check = new int[9][9];
        for(int i = 0; i <9; i ++)
        {
            for(int j = 0; j <9; j ++)
            {
                col_check[i][j] ++;
            }
        }
        return 1;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int k = 1; k <= T; k ++) {
            int[][] inputArray = new int[9][9];

            int[] col_check = new int[9];
            int[] box_check = new int[9];

            int result = 1;
            //input
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    inputArray[i][j] = scanner.nextInt();

            for (int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j ++)
                {

                }
            }
//            if(checkRow(inputArray) == 0)
//                result = 0;

        }
    }
}
