package easy;
import java.util.Scanner;
import java.lang.Math;

public class Avg {
    public static void main(String[] args)
    {
        int T;

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for(int k = 1; k <= T; k ++)
        {
            int sum = 0;
            for(int i = 0; i < 10; i ++)
            {
                double input = scanner.nextInt();
                sum += input;
            }
            System.out.println("#" + k + " " + (int)Math.round(sum/10.0));
        }
    }
}
