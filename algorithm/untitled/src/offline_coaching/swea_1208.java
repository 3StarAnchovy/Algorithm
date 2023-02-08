package offline_coaching;

import java.util.Scanner;

public class swea_1208 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        for(int T = 1; T <= 10; T ++)
        {
            int[] arr = new int[100];
            //input
            int dump = scanner.nextInt();
            for(int i = 0; i < 100; i ++)
                arr[i] = scanner.nextInt();

            int result_max = 0;
            int result_min = 0;
            while(dump != 0)
            {
                int max = 0;
                int min = 101;
                int max_idx = -1;
                int min_idx = -1;
                //완전탐색 시행
                for(int i = 0; i < 100; i ++)
                {
                    //max, min 찾기
                    if(max < arr[i]) {
                        max = arr[i];
                        max_idx = i;
                    }
                    if(min > arr[i]) {
                        min = arr[i];
                        min_idx = i;
                    }
                }

                if(max - min > 1)
                {
                    arr[max_idx] --;
                    arr[min_idx] ++;
                }
                dump --;
                result_max = max;
                result_min = min;
                //만약에 max와 min의 차이가 1 이내라면 시행하지 않는다
                //max -1, min + 1 해주기
            }
            System.out.println("#" + T + " " + (result_max-result_min));
        }
    }
}
