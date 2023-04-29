package simulation;

import java.util.Scanner;

public class boj_8911_거북이 {
    static class Turtle{
        int i;
        int j;
        int d;

        public Turtle(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
    static int[] delta_i = {-1,0,1,0}; //북동남서
    static int[] delta_j = {0,1,0,-1};
    static int max_i, max_j, min_i, min_j;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();

        //step 1: 입력 구현, 거북이 클래스 구현
        for(int tc = 0; tc < TC; tc ++)
        {
            //새로운 테스트 케이스가 시작 될떄마다 최소, 최대 restore
            max_i = 0; max_j = 0; min_j = 0; min_i = 0;
            String input = scanner.next();
            Turtle turtle = new Turtle(0,0,0); // 0,0에서 시작, 처음 바라보는 방향은 북쪽

            for(int i = 0; i < input.length(); i++)
            {
                char command = input.charAt(i);
                // step2 : 거북이 움직임 구현
                move(turtle, command);
            }

            //step 3: 최소, 최대값 기준으로 직사각형 도출
            int weight = Math.abs(max_j - min_j);
            int height = Math.abs(max_i - min_i);
            System.out.println(weight * height);
        }
    }

    private static void move(Turtle turtle, char command) {
        //f b : 전진, 후진
        //l r : 회전

        if(command == 'L')
            turtle.d = (turtle.d - 1 + 4) % 4;
        else if (command == 'R')
            turtle.d = (turtle.d + 1 + 4) % 4;

        //전진 회전 구현, 최소값 최대값 갱신해야됨
        else if (command == 'F')
        {
            turtle.i = turtle.i + delta_i[turtle.d];
            turtle.j = turtle.j + delta_j[turtle.d];
            // 최소값, 최대값 갱신
            updateMaxMin(turtle);
        }
        else if (command == 'B')
        {
            turtle.i = turtle.i - delta_i[turtle.d];
            turtle.j = turtle.j - delta_j[turtle.d];
            updateMaxMin(turtle);
        }
    }

    private static void updateMaxMin(Turtle turtle) {
        max_i = Math.max(turtle.i, max_i);
        max_j = Math.max(turtle.j,max_j);
        min_i = Math.min(turtle.i, min_i);
        min_j = Math.min(turtle.j, min_j);
    }
}
