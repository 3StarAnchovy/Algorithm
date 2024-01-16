package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1259_팰린드롬수_입출력최적화 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            String answer = "yes";
            if (input.equals("0"))
                break;

            int size = input.length();
            int half_size = size / 2;

            for (int i = 0; i < half_size; i++) {
                if (input.charAt(i) != input.charAt(size-i-1))
                    answer="no";
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
