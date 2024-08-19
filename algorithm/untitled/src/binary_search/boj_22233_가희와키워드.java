package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_22233_가희와키워드 {
    static int N, M;
    //static HashMap<String, Integer> memoMap = new HashMap<>();
    static HashSet<String> memoSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String keyword = br.readLine();
            //memoMap.put(keyword, memoMap.getOrDefault(keyword, 0) + 1);
            memoSet.add(keyword);
        }

        for(int i = 0; i < M; i ++){
            String input = br.readLine();
            String[] arr = input.split(",");

            for(int j = 0; j < arr.length; j ++){
                String keyword = arr[j];
                memoSet.remove(keyword);
            }

            sb.append(memoSet.size()).append("\n");
        }

        System.out.print(sb);
    }
}

/*
가희는 블로그를 운영하고있음
키워드느 모두 다르며 총 N개가 존재함
최대 10개의 키워드에 대해서 글을 작성함
메모장에 있었던 키워드는 글쓰면 지워짐
블로그 글 쓰고 메모장에 키워드 얼마나 남았을까?
 */
