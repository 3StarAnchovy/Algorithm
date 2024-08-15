package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class boj_20920_영단어암기는괴로워 {
    static int N, M;
    static HashMap<String, Integer> hash = new HashMap<>();
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() >= M) {
                hash.put(word, hash.getOrDefault(word, 0) + 1);
            }
        }

        list = new ArrayList<>(hash.keySet());

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (!hash.get(o1).equals(hash.get(o2))) {
                    return hash.get(o2) - hash.get(o1);
                } else {
                    if (o1.length() != o2.length())
                        return o2.length() - o1.length();
                    else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i ++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}

/*
단어 순서는 다음과 같은 우선순위를 가지고 있음
자주 나오는 단어는 앞에 배치함
해당 단어의 길이가 길수록 앞에 배치함
알파벳 사전 순으로 앞에 배치함

M개 이상인 단어들만 외울거임
 */