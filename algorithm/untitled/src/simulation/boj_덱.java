package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class boj_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();

            //arrayDeque.add(1);
            if (input.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                arrayDeque.addFirst(num);
            } else if (input.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                arrayDeque.addLast(num);
            } else if (input.equals("pop_front")) {
                Integer num = arrayDeque.pollFirst();
                if (num == null)
                    System.out.println(-1);
                else
                    System.out.println(num);
            } else if (input.equals("pop_back")) {
                Integer num = arrayDeque.pollLast();
                if (num == null)
                    System.out.println(-1);
                else
                    System.out.println(num);
            } else if (input.equals("size")) {
                System.out.println(arrayDeque.size());
            } else if (input.equals("empty")) {
                if (arrayDeque.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            } else if (input.equals("front")) {
                Integer num = arrayDeque.peekFirst();
                if (num == null)
                    System.out.println("-1");
                else
                    System.out.println(num);
            } else if (input.equals("back")) {
                Integer num = arrayDeque.peekLast();
                if (num == null)
                    System.out.println("-1");
                else
                    System.out.println(num);
            }

            //System.out.println("현황" + arrayDeque.toString());
        }
    }
}
