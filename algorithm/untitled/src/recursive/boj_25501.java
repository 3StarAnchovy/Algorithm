package recursive;

import java.util.Scanner;

public class boj_25501 {
    public static int recursion(String s, int l, int r, int[] n){
        n[0] ++;

        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1, n);
    }
    public static int isPalindrome(String s, int[] n){
        return recursion(s, 0, s.length()-1, n);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int[] n = new int[1];
        for(int i = 1; i <= T; i ++)
        {
            String input = scanner.next();
            int ispail = isPalindrome(input,n);
            System.out.println(ispail + " " + n[0]);
            n[0] = 0;
        }
    }
}
