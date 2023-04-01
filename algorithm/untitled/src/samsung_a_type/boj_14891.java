package samsung_a_type;

import java.util.Scanner;

/*
톱니바퀴 4개 고정, 톱날 8개 고정 -> 배열
배열 [4][8]
step 1 입력
    문자열로 날라옴 찢어서 배열에 저장
step 입력된 방향으로 시계 회전
    사이드 이펙트는 재귀로 구현 -> visited 필요해보임. 한방향으로 쭉가야되는데, visted 안찍으면 다시 돌아올수도 있음
    왼쪽으로 뻗어 갈 때
    오른쪽으로 뻗어 갈때
    극이 다르면 회전, 회전방향 역수 취해서 건내줌
    기저조건 ? 다음방향이 없을 때 ㅇㅇ
step3 배열에 있는 값 기준으로 점수 계산
 */
public class boj_14891 {
    static int[][] magnet;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        magnet = new int[5][8]; //1 base
        for (int i = 1; i <= 4; i++) {
            temp = scanner.next();
            for (int j = 0; j < 8; j++) {
                magnet[i][j] = temp.charAt(j) - '0';
            }
        }

        int K = scanner.nextInt();
        for (int k = 0; k < K; k++) {
            int magnet_num = scanner.nextInt();
            int rotate = scanner.nextInt();

            visited = new boolean[5]; // 1base
            rotateMagnet(magnet_num, rotate);
        }

        int result = getScore(magnet);

        System.out.println(result);
    }

    private static int getScore(int[][] magnet) {
        int sum = 0;

        if(magnet[1][0] == 1) sum ++;
        if(magnet[2][0] == 1) sum +=2;
        if(magnet[3][0] == 1) sum +=4;
        if(magnet[4][0] == 1) sum +=8;

        return sum;
    }

    private static void rotateMagnet(int magnet_num, int rotate) {
        if (magnet_num == 0 || magnet_num == 5) // 자석의 양쪽 끝부분. 사이드이펙트가 없어도되므로 리턴
            return;

        visited[magnet_num] = true;
        //자석 미리 백업해놔야함.
        int[] copy = copyArr(magnet[magnet_num]);
        int current_left = magnet[magnet_num][6]; // 현재 자석의 왼쪽 부분
        int current_right = magnet[magnet_num][2]; // 현재 자석의 오른쪽 부분

        //본인 회전
        if (rotate == 1) {
            //시계 방향
            for (int i = 0; i < 8; i++) {
                magnet[magnet_num][i] = copy[(i - 1 + 8) % 8];
            }
        } else if (rotate == -1) {
            //반시계 방향
            for (int i = 0; i < 8; i++) {
                magnet[magnet_num][i] = copy[(i + 1 + 8) % 8];
            }
        }

        //사이드이펙트, 다음재귀, 방문한적없고, 범위가 유효하고, 맞닿아있는 자석의 자성이 같지 않다면
        //왼쪽으로 뻗어나갈 경우
        if(1 <= magnet_num - 1 && !visited[magnet_num - 1] && current_left != magnet[magnet_num - 1][2])
        {
            rotateMagnet(magnet_num - 1, rotate * -1);
        }
        //오른쪽으로 뻗어나갈 경우
        if(magnet_num + 1 < 5 && !visited[magnet_num + 1] && current_right !=  magnet[magnet_num + 1][6])
        {
            rotateMagnet(magnet_num + 1, rotate * -1);
        }
    }

    public static int[] copyArr(int[] origin) {
        int[] copy = new int[8];
        for (int i = 0; i < 8; i++) {
            copy[i] = origin[i];
        }

        return copy;
    }
}
