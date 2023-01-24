package baisic;

import java.util.Scanner;

public class boj_2440 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = N; i >= 1; i --)
        {
            for(int j = i; j >= 1; j --)
                System.out.print("*");
            System.out.println();
        }
    }
}
