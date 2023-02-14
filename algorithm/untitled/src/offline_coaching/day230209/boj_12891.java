package offline_coaching.day230209;

import java.util.Scanner;

public class boj_12891 {
    static int S;
    static int P;
    static int[] check;
    static char[] need = {'A','C','G','T'};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        S = scanner.nextInt();
        P = scanner.nextInt();
        check = new int[4];

        String dna = scanner.next();
        for(int i = 0; i < 4; i ++)
            check[i] = scanner.nextInt();

        //부분합 초기화
        for(int i = 0; i < P; i ++)
        {
            ;
        }
    }
}
