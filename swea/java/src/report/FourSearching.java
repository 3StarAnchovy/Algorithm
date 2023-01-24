package report;

public class FourSearching {
    public static void main(String[] args)
    {
        int[][] map = {
                {2,3,1,4},
                {1,0,3,2},
                {3,4,0,0},
                {0,4,1,5}
        };

        int sum = 0;
        int[][] detals = {{-1,0},{1,0},{0,-1},{0,1}}; //상하좌우

        for(int i = 0; i < 4; i ++)
        {
            for(int j = 0; j < 4; j ++)
            {
                if(map[i][j] == 0)
                {
                    for(int d = 0; d < 4; d ++)
                    {
                        int n_row = i + detals[d][0];
                        int n_col = j + detals[d][1];
                        if(n_row >= 0 && n_row < 4 && n_col >= 0 && n_col < 4 && map[n_row][n_col] != 0) {
                            sum += map[n_row][n_col];
                            map[n_row][n_col] = 0;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
