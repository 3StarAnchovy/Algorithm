package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1406_에디터 {
    static String word;
    static int num;
    static Stack<Character> right = new Stack<>();
    static LinkedList<Character> left = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            left.push(word.charAt(i));
        }
        num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char command = st.nextToken().charAt(0);
            if(st.hasMoreTokens()){
                char alpha = st.nextToken().charAt(0);
                right.push(alpha);
            }
            if (command == 'L') {
                if (right.isEmpty())
                    continue;
                left.add(right.pop());
            } else if (command == 'D') {
                if(left.isEmpty()) continue;
                right.push(left.pollFirst());
            } else if (command == 'B') {
                if(left.isEmpty()) continue;
                left.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()){

        }
    }

    /*
    커서는 문장의 맨 앞
    문장의 맨 뒤, 중간의 임의의 곳에 위치한다. 길이가 L인 문자열이 현재 편집기에 입력되어있으면,
    L +1 가지 경우가 있네..?

    모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램
    명려어가 수행되기 전에 커서는 맨 뒤에 있음.
     */
}
