package recursive;

import java.util.Scanner;

public class boj_10870 {
    public static int recursive(int n)
    {
        if(n >= 2)
            return recursive(n - 1) + recursive(n - 2);
        return n;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(recursive(n));
    }
}
