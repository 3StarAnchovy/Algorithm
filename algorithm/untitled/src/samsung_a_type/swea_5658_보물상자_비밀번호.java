package samsung_a_type;

import java.util.Comparator;
import java.util.HexFormat;
import java.util.Scanner;
import java.util.TreeSet;

/*
문제 해석
보물상자 숫자 시계방향으로 한칸씩 돌릴 수 있음
서로 다른 회전에서 동일한 수 중복으로 있을 수 있음. 이거 주의하면서 풀어보자
 */

/*
배열돌리기처럼 풀어보자 ((i - 1 + N) % N)
한번 돌릴때마다 문자열 만들어서 treeset에 집어넣고 맨 위에 짜르면서 값 도출해보자
몇번 돌려야됨? 3번 ㅇㅇ
 */
public class swea_5658_보물상자_비밀번호 {
    static int N;
    static int K; // k번째로 큰 수 찾아야함
    static char[] input;
    static TreeSet<String> tree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TC = scanner.nextInt();

        for (int tc = 1; tc <= TC; tc++) {
            N = scanner.nextInt();
            K = scanner.nextInt();
            String temp = scanner.next();
            input = new char[N];
            tree = new TreeSet<>(Comparator.reverseOrder());
            input = temp.toCharArray();

            for (int r = 0; r < N / 4; r++) {
                //step 01. 3개씩 짤라서 문자열 만들고 tree에 집어넣기
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < N; i++) {
                    sb.append(input[i]);
                    if ((i + 1) % (N / 4) == 0) {
                        tree.add(String.valueOf(sb));
                        sb = new StringBuilder();
                    }
                }

                //System.out.println(tree);
                //step 02. 돌리기
                rotateArray();

            }

            //System.out.println(tree);
            for (int i = 0; i < K - 1; i++)
                tree.pollFirst();

            //step3 string - > 16진수 -> 10 진수로 바꾸기
            int result = Integer.parseInt(tree.pollFirst(), 16);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static char[] copyArray(char[] origin) {
        char[] copy = new char[N];
        for (int i = 0; i < N; i++) {
            copy[i] = origin[i];
        }

        return copy;
    }

    private static void rotateArray() {
        char[] copy = copyArray(input);

        for (int i = 0; i < N; i++) {
            input[i] = copy[((i - 1 + N) % N)];
        }
    }

}
