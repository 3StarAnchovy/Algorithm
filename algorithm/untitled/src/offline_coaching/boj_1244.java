package offline_coaching;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1244 {
    static int[] arr;
    static int swi;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        swi = scanner.nextInt();

        arr = new int[swi + 1];
        for(int i = 1; i < swi + 1;i ++)
            arr[i] = scanner.nextInt();

        int cnt = scanner.nextInt();
        for(int i = 0; i < cnt; i ++)
        {
            int t = scanner.nextInt();
            int t_num = scanner.nextInt();
            if(t == 1) {
                man(t_num);
            }
            else {
                woman(t_num);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void man(int num)
    {
        for(int i = 1; i < swi + 1; i ++)
        {
            if((i / num) == 0)
            {
                if(arr[i] == 0)
                    arr[i] = 1;
                else
                    arr[i] = 0;
            }
        }
    }

    public static void woman(int num)
    {
        int i = 1;
        //인덱스 벗어나는거 체킹
        while(arr[num - i] >= 1 && arr[num + i] <= swi)
        {
            //양쪽으로 체킹
            if (arr[num - i] == 0 && arr[num + i] == 0)
            {
                arr[num - i] = 1;
                arr[num + i] = 1;
            }
            else if (arr[num - i] == 1 && arr[num + i] == 1)
            {
                arr[num - i] = 0;
                arr[num + i] = 0;
            }
            else
                break;
            i ++;
        }
    }
}
