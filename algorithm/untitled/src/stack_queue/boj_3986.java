package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_3986 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for(int n = 0; n < N; n ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            stack = new Stack<>();
            if (s.length() % 2 != 0) continue;

            stack.push(s.charAt(0));

            for(int i = 1; i < s.length(); i ++) {
                char b = s.charAt(i);

                if(!stack.isEmpty() && stack.peek() == b)
                    stack.pop();
                else {
                    stack.push(b);
                }
            }

            if(stack.isEmpty()) result++;
        }

        System.out.println(result);
    }
}

/*

 */
