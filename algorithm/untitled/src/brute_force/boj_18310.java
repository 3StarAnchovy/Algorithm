package brute_force;
import java.util.Arrays;
import java.util.Scanner;

public class boj_18310 {
    //이거 완전탐색 맞나?
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] house = new int[N];

        //input
        for(int i = 0; i < N; i ++)
            house[i] = scanner.nextInt();

        //정렬, 중앙값으로 최소거리 도출
        // nlogn
        Arrays.sort(house);
        System.out.println(house[(N - 1) / 2]);
    }
}
