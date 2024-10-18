package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj_2607_비슷한단어 {
    static String[] s;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        s = new String[cnt];

        for(int i = 0; i < cnt; i ++) {
            s[i] = br.readLine();
        }

        char[] first = s[0].toCharArray();
        Arrays.sort(first);
        for(int i =1; i < cnt; i ++) {
            char[] cArr = s[i].toCharArray();
            Arrays.sort(cArr);


        }
    }
}

/*
두개의 단어가 같은 종류의 문자로 이루어져있음
같은 문자는 같은 개수만큼 있음

같은 구성임 ㅇㅇ

같은 구성이거나, 한단어에서 문자를 더하거나빼거나바꾸어서 같은 구성을 갖는 단어 찾기
 */