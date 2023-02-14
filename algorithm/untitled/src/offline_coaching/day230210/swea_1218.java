package offline_coaching.day230210;

import java.util.Scanner;
import java.util.Stack;

public class swea_1218 {
    static String front = "{[(";
    static String rear = "}])";
    static char[] input;

    public static void main(String[] args)
    {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc ++)
        {
            int n = scanner.nextInt();
            input = new char[n + 1];
            String sInput = scanner.next();
            //입력 바꿔야함
            for(int i = 0; i < n; i ++)
            {
                input[i] = scanner.next().charAt(0);
                if(input[i] == '{' || input[i] == '[' || input[i] == '(')
                    stack.push(input[i]);
            }

            int result = 1;
            //action
            for(int i = 0; i < n; i ++)
            {
                switch (input[i]) {
                    case '}':
                        if(stack.pop() != '{')
                            result = 0;
                        break;
                    case ']':
                        if(stack.pop() != '[')
                            result = 0;
                        break;
                    case ')':
                        if(stack.pop() != '(')
                            result = 0;
                        break;
                }
            }
            if(stack.size() != 0)
                result = 0;
            System.out.println("#" + tc + " " + result);
        }
    }
}
