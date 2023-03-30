package samsung_a_type;

import java.util.*;

//비슷한 문제 백준 톱니바퀴
/*
접근
화살표가 가리키는 방향 = 배열의 첫번째 요소

화살표 idx -2, idx + 2 = 다른 자석과 맞닿아 있는 요소
해당 요소들이 다르다면? -> 현재 회전한 자석의 반대방향으로 회전 돌리기
            같다면? -> 회전 x
 */
public class swea_4013_특이한자석 {
    static int K;
    static int[][] magnet_arr; // r = 마그넷 넘버, c = 자성
    static int[] copy;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        for (int tc = 1; tc <= TC; tc++) {
            K = scanner.nextInt();

            //magnet init
            magnet_arr = new int[4 + 1][8]; //1base 맨 왼쪽 더미
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j < 8; j++) {
                    magnet_arr[i][j] = scanner.nextInt();
                }
            }

            for (int k = 0; k < K; k++) {
                int magnet_num = scanner.nextInt();
                int rotate = scanner.nextInt();
                visited = new boolean[4 + 1]; //
                rotate(magnet_num, rotate);
            }

            int result = getScore();
            System.out.println("#" +tc + " " + result);

            //print();
        }
    }

    private static int getScore() {
        int sum = 0;
        if(magnet_arr[1][0] == 1) sum ++;
        if(magnet_arr[2][0] == 1) sum +=2;
        if(magnet_arr[3][0] == 1) sum +=4;
        if(magnet_arr[4][0] == 1) sum +=8;
        return sum;
    }

    private static void print()
    {
        for(int i = 1; i <= 4; i ++)
        {
            for(int j = 0; j < 8; j ++)
            {
                System.out.print(magnet_arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // rotate = 1 -> 시계방향
    // rotate = -1 -> 반시계
    private static void rotate(int magnet_num, int rotate) {
        //end
        if (magnet_num == 0 || magnet_num == 5) {
            return;
        }

        visited[magnet_num] = true;
        //action
        int current_l = magnet_arr[magnet_num][6];
        int current_r = magnet_arr[magnet_num][2];
        //int left = magnet_arr[magnet_num - 1][2];
       // int right = magnet_arr[magnet_num + 1][6];

        //copy = copyMagnet(magnet_arr[magnet_num]);
        if (rotate == 1) {
            //System.out.println("ㅎㅇ");
            copy = copyMagnet(magnet_arr[magnet_num]);
            for (int i = 0; i < 8; i++) {
                magnet_arr[magnet_num][i] = copy[(i - 1 + 8) % 8];
            }
        } else if (rotate == -1) {
            //System.out.println("tt");
            copy = copyMagnet(magnet_arr[magnet_num]);
            for (int i = 0; i < 8; i++) {
                magnet_arr[magnet_num][i] = copy[(i + 1 + 8) % 8];
            }
        }

        //next
        //왼쪽으로 뻗어갈때
        if ( 1 <= magnet_num - 1 && current_l != magnet_arr[magnet_num - 1][2] && !visited[magnet_num - 1]) {
            //System.out.println("여기 들어옴 , left");
            rotate(magnet_num - 1, rotate * -1);
        }

        //오른쪽으로 뻗어갈때 여기 왜 호출 안돼 시발
        if (magnet_num + 1 <= 4 && current_r != magnet_arr[magnet_num + 1][6] && !visited[magnet_num + 1]) {
            //System.out.println("여기 들어옴 , right");
            rotate(magnet_num + 1, rotate * -1);
        }
        //이외의 경우 같은게 없으므로 자기만 돌고 끝남

    }

    private static int[] copyMagnet(int[] origin) {
        int[] copy = new int[8];
        for (int i = 0; i < 8; i++) {
            copy[i] = origin[i];
        }
        return copy;
    }
}
