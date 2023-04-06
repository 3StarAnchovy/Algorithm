package samsung_a_type;


import java.util.Scanner;

/*
문제 해석
활주로를 건설할 수 있는 경우의 수
왜인지는 모르겠는데 한 줄에 여러개 설치할 수 있어도 하나로 친다.
경사로는 높이 차이가 1이고, 낮은 지형의 높이가 동일하게 경사로의 길이만큼 연속되는 곳에 설치 할 수 있다.
"각자의 행과 열에 경사로를 깔아서, 활주로를 만들수 있는지 없는지 체킹하는거!"
 */

/*
접근
각자의 행과 열에 경사로가 되는지 완전탐색해야함
행의 경우
    높이 차이가 2가 넘어가면 return
    위로 올라가는 경사로인 경우
    아래로 내려가는 경사로인 경우
열의 경우
    높이 차이가 2가 넘어가면 return
    위로 올라가는 경사로인 경우
    아래로 내려가는 경사로인 경우
 */
public class swea_4014_활주로 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();
        for(int tc = 1; tc <= TC; tc ++)
        {

        }
    }
}
