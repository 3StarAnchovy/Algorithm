package 끄적끄적;

/*
1. X로 표시된 항목의 상하좌우 숫자의 합을 구하여라. (단 이미 사용된 숫자는 다시 사용x)
5 X 1 2
X X 2 3
4 X 5 9
8 7 X 5

답 : 29
 */

public class prac_4방탐색 {
    static int[] delta_i = {-1, 1, 0, 0}; //상,하
    static int[] delta_j = {0, 0, -1, 1}; // 좌, 우

    public static void main(String[] args) {
        char[][] grid = {{'5', 'X', '1', '2'},
            {'X', 'X', '2', '3'},
            {'4', 'X', '5', '9'},
            {'8', '7', 'X', '5'}};

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 'X') {
                    for (int d = 0; d < 4; d++) {
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
