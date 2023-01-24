package easy;
import java.util.Arrays;
import java.util.Scanner;

public class MidNumber {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] inputArray = new int[N];
        int mid;

        for(int i = 0; i < N; i ++)
            inputArray[i] = scanner.nextInt();
        Arrays.sort(inputArray);
        System.out.println(inputArray[(N - 1)/ 2]);
    }
}
