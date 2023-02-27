package disjoint;

import java.util.Arrays;
import java.util.Scanner;

public class baisic {
    static int[] arr;
    static int N;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        arr = new int[N + 1];
        makeSet();

        unionSet(1,2);
        unionSet(2,3);

        System.out.println(Arrays.toString(arr));
    }

    private static boolean unionSet(int a, int b)
    {
        int rootA = findSet(a);
        int rootB = findSet(b);

        //대표자가 같다면 이미 포함관계이므로 false 반환
        if(rootB == rootA)
            return false;

        arr[rootB] = rootA;
        return true;
    }
    /*
    입력받은 요소의 대표자를 반환해주는 함수
     */
    private static int findSet(int a)
    {
        if(a == arr[a])
            return a;
        //일반적인 대표자 반환
        //return findSet(arr[a]);

        //path_compression
        return arr[a] = findSet(arr[a]);
    }

    //각 요소를 대표로 하는 집합 생성
    // value -> 대표자, index -> 요소
    private static void makeSet() {
        for(int i = 1; i < N + 1; i ++)
            arr[i] = i;
    }
}
