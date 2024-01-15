package simulation;

import java.util.Scanner;

public class boj_1259_팰린드롬수 {
    /*
    뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라함
    입력된 숫자가 팰린드롬인지 확인하기

    step 1
    문자열 입력받기, 사이즈 체크하기

    step 2
    사이즈의 절반만큼 시행하기
    시행수와 사이즈 - 시행수 비교해서 같으면 패스 아니면 no 뱉기
     */

    static String N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            N = scanner.next();

            String answer = "yes";
            if (N.equals("0"))
                break;

            int size = N.length();
            int try_size = size / 2;
            for (int i = 0; i < try_size; i++) {
                if (N.charAt(i) != N.charAt(size - i - 1)) {
                    answer = "no";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
