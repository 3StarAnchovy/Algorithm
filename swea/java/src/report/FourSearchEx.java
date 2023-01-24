package report;

public class FourSearchEx {
    public static void main(String[] args)
    {
        int[][] map = { { 1, 2, 3, 4 },
                { 5, -1, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, -1, 16 } };

        //상하좌우
        int[] delta_i = {-1, 1, 0, 0};
        int[] delta_j = {0, 0, -1, 1};

        int sum = 0;
        for(int i = 0; i < 4; i ++)
        {
            for(int j = 0; j < 4; j ++)
            {
                if(map[i][j] == -1)
                {
                    for(int d = 0; d < 4; d ++)
                    {
                        int nr = i + delta_i[d];
                        int nc = j + delta_j[d];
                        //인덱스 체킹
                        if (nr >= 0 && nr < 4 && nc >=0 && nc < 4 && map[nr][nc] != -1)
                            sum += map[nr][nc];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
