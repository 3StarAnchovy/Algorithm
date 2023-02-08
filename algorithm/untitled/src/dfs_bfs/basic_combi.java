package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class basic_combi {
    static int[] arr; //요소 정보
    static int N; // 전체 요소의 개수
    static int R; // 뽑을 요소의 개수
    static int[] picked;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        picked = new int[R];
        for (int i = 0; i < N; i++)
            arr[i] = i + 1;
        System.out.println("원본 요소 : " + Arrays.toString(arr));

        loopCombination();
    }

    //for문을 활용한 조합(Combination)
    private static void loopCombination() {
        for (int i = 0; i < N; i++) {
            //1번째 요소의 인덱스 선택
            for (int j = i + 1; j < N; j++) {
                //2번째 요소의 인덱스 선택
                for (int k = j + 1; k < N; k++) {
                    System.out.printf("뽑은 요소 정보 : %d, %d, %d\n", arr[i], arr[j], arr[k]);
                }
            }
        }
    }

    private static void recursiveCombi(int cnt, int start)
    {
        if(cnt == R)
        {
            System.out.println(Arrays.toString(picked));
            return ;
        }
        // i : 현재 선택할 요소의 인덱스 후보군
        for(int i = start; i < N; i ++)
        {
            //요소 선택
            picked[cnt] = arr[i];

            //다음 요소 선택은 재귀 호출
            recursiveCombi(cnt + 1, start + 1);
        }
    }
}
