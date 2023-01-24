package brute_force;

import java.util.Scanner;

public class boj_17945 {
    public static void main(String[] args)
    {
        //x2  + 2Ax + B = 0 의 두 계수 A, B가 주어진다.
        //A, B는 정수이며, 이 방정식의 근은 항상 정수이다. (-1000 ≤ A, B ≤ 1000)
        Scanner scanner = new Scanner(System.in);

        double A = scanner.nextInt();
        double B = scanner.nextInt();

        double[] result = new double[2];

        result[0] = (-1 * (2 * A) + Math.sqrt((2 * A) * (2 * A) - (4 * B))) / 2 ;
        result[1] = (-1 * (2 * A) - Math.sqrt((2 * A) * (2 * A) - (4 * B))) / 2 ;

        if(result[0] != result [1])
            System.out.println(Math.min((int)result[0], (int)result[1]) + " " +  Math.max((int)result[0], (int)result[1]));
        else
            System.out.println((int)result[0]);
    }
}
