package stack_queue;

/*
스택 문제
if( '(')
    push
else pop
    pop이 false 뱉으면 no 출력하고 return
print yes
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Stack<Integer> stack = new Stack<>();
            String input = br.readLine();
            boolean flag = false;
            A:
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(')
                    stack.push(1);
                else if (stack.isEmpty() || stack.pop() != 1) {
                    flag = true;
                    break A;
                }
            }
            
            if(flag || !stack.isEmpty())
                sb.append("NO").append('\n');
            else
                sb.append("YES").append('\n');
        }

        System.out.print(sb);
    }
}
