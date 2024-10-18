package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1283_단축키지정 {
    static int N;
    static HashMap<Character, Integer> hashMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i ++) {
            boolean flag = false;
            String s = br.readLine();
            String[] sArr = s.split(" ");

            for(int j = 0; j < sArr.length; j ++) {
                String word = sArr[j];
                if(j != 0){
                    sb.append(" ");
                }
                if(hashMap.get(Character.toLowerCase(word.charAt(0))) == null) { //지정된 단축키가 없을 떄
                    flag = true;
                    hashMap.put(Character.toLowerCase(word.charAt(0)),1);
                    sb.append("[").append(word.charAt(0)).append("]");
                    sb.append(word.substring(1));
                } else { //지정된 단축키가 있을 떄
                    sb.append(word);
                    continue;
                }
                sb.append("\n");
            }

            if(!flag) { //1번 2번이 해당 안된 경우
                //대소문 구분없이 싹다 뒤져
                sb.append("hi\n");
                for(int j = 0; j < sArr.length; j ++) {
                    String word = sArr[j];
                    if(j != 0){
                        sb.append(" ");
                    }
                    for(int k = 0; k < word.length(); k ++) {
                        char c = word.charAt(k);
                        if(hashMap.get(Character.toLowerCase(c)) == null) { //지정된 단축키가 없을 때
                            hashMap.put(Character.toLowerCase(c),1);
                            sb.append(word.substring(0, k-1));
                            sb.append("[").append(word.charAt(k)).append("]");
                            sb.append(word.substring(k, word.length()));

                        }
                        else { //지정된 단축키가 있을 떄
                            sb.append(word);
                            continue;
                        }
                    }
                }
            } else {
                continue;
            }

        }

        System.out.print(sb);
    }
}

/*
총 N개의 옵션이 있따.

1. 먼저 하나의 옵션에 대해 왼쪽에서부터 오른쪽으로 첫글자가 이미 단축키로 지정되어있는지 살펴본다
    단축키로 지정안되있으면 단축키로 지정함
2.만약 모든 단어의 첫글자가 이미 지정되있으면, 왼쪽부터 보면서 그걸로 단축키 지정함

3. 어떤것도 지정할수 없으면, 그냥 놔두며 대소문자를 구분하지 않는다
4. 위 규칙을 처음부터 n개까지 적용한다.
 */

/*
step1 입력받기

입력받을때마다,

해쉬 체크하기
    앞에 대가리가 키일때
        있어 ? -> 다음 단어로 넘어가
        없어 ? -> 해쉬에 키 밸류 박고, StringBuilder에 추가하고 continue
 */