package brute_force;
import java.util.Scanner;

public class boj_18310 {
    //이거 완전탐색 맞나?
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] house = new int[N];
        for(int i = 0; i < N; i ++)
            house[i] = scanner.nextInt();

        int min = Integer.MAX_VALUE;
        int min_i = N;
        //모든 경우의 수 체크
        for(int i = 0; i < N; i ++)
        {
            int position = house[i];
            int sum = 0;
            for(int j = 0; j < N; j ++)
                sum += Math.abs(position - house[j]);
            if(sum < min && min_i < house[i]){
                min = sum;
                min_i = house[i];
            }
        }
        System.out.println(min_i);
    }
}
