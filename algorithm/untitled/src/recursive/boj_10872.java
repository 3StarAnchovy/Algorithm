package recursive;
import java.util.Scanner;

public class boj_10872 {
	public static int recur(int N)
	{
		if(N == 0)
			return 1;
		else
			return (N * recur(N - 1));
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		System.out.println(recur(N));
	}
}
