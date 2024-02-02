package simulation;

//포켓몬 개수 N이랑 맞춰야하는 문제 개수 M 줌
// 이름 : 번호 해쉬 하나
// 번호 : 이름 해쉬 하나
// 입력 끝나고 입력값이 String인지, int인지 체킹하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620_포켓몬스터이다솜 {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> stringKey = new HashMap<>();
        HashMap<Integer, String> intKey = new HashMap<>();

        //input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            stringKey.put(name, i);
            intKey.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            char check = input.charAt(0);

            if ('0' <= check && check <= '9') {
                sb.append(intKey.get(Integer.parseInt(input))).append('\n');
            } else {
                sb.append(stringKey.get(input)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
