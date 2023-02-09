package offline_coaching;

import java.util.Scanner;

public class boj_1926 {
    static int n; // 세로
    static int m; // 가로
    static int[][] map;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new int[n][m];
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                map[i][j] = scanner.nextInt();
    }
}
