package recursive;

import java.util.Scanner;

public class boj_11729 {
    public static void recursive(int n, int start, int dep, int mid)
    {
        if(n != 1)
        {
            recursive(n - 1, start, mid, dep);
            System.out.println(start + " " + dep);
            recursive(n - 1,mid, dep, start);
            return;
        }
        System.out.println(start + " " + dep);
    }

    public static void main(String[] args)
    {
        //recursive(n) = recursive(n - 1) + 1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((int) Math.pow(2,n) - 1);
        recursive(n,1,3,2);
    }
}
