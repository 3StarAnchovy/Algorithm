package easy;
import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T;

        T = scanner.nextInt();
        for(int k = 1; k <=T; k ++)
        {
            int max = 0;
            for(int i = 0; i < 10; i++)
            {
                int input = scanner.nextInt();
                if(max < input)
                    max = input;
            }
            System.out.println("#" + k + " " + max);
        }
    }
}
