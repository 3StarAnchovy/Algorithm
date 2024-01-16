package 끄적끄적;

public class prac_8방탐색 {
    /*
    2. X로 표시된 항목을 둘러싸고 있는 8방면에 있는 숫자의 합을 구하여라. (단 이미 사용된 숫자는 다시 사용x)
        5 X 1 2
        X X 2 3
        4 X 5 9
        8 7 X 5

    답 : 46
     */
    static int[] delta_i = {-1, 1, 0, 0, -1, 1, 1, -1}; //상하좌우 위오, 아래오, 아래왼, 위왼
    static int[] delta_j = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) {
        char[][] grid = {{'5', 'X', '1', '2'},
            {'X', 'X', '2', '3'},
            {'4', 'X', '5', '9'},
            {'8', '7', 'X', '5'}};

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 'X') {
                    for (int d = 0; d < 8; d++) {
                        int ni = i + delta_i[d];
                        int nj = j + delta_j[d];
                        if (0 <= ni && ni < 4 && 0 <= nj && nj < 4 && grid[ni][nj] != 'X') {
                            sum += grid[ni][nj] - '0';
                            grid[ni][nj] = '0';
                        }
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
