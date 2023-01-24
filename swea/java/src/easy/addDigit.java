package easy;
import java.util.Scanner;

public class addDigit {
    public static void main(String args[])
    {
        int input;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();

        int sum = 0;
        while(input != 0)
        {
            sum += input % 10;
            input /= 10;
        }
        System.out.println(sum);
    }
}
