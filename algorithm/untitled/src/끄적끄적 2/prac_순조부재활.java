package 끄적끄적;

import java.util.Arrays;
import java.util.Scanner;

public class prac_순조부재활 {
    static int N;
    static int R;
    static int[] picked;
    static int[] arr;
    static boolean[] isSelected;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        R = scanner.nextInt();
        picked = new int[R];
        arr = new int[N];
        isSelected = new boolean[N];

        getPerm(0);
    }

    private static void getCombi(int cnt, int start) {
        if (cnt == R) {
            return;
        }

        for (int i = start; i < N; i++) {
            if (!isSelected[cnt]) {
                picked[cnt] = arr[i];
                isSelected[cnt] = true;
                getCombi(cnt + 1, start + 1);
            }
        }
    }

    private static void getPerm(int cnt) {
        if (cnt == R) {
            System.out.println(Arrays.toString(picked));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                continue;

            picked[cnt] = arr[i];

            isSelected[i] = true;
            getPerm(cnt + 1);
            isSelected[i] = false;
        }
    }
}