package perm_combi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
처음에 부분집합 생각했었음. 종류별로 입을때, 안입을때 나열한뒤 각각 계산해서 더할라했는데
생각해보니까 그냥 경우의수 문제넹.

종류별로 count해서, 곱하자 ex 상의 3, 하의 2이면
3 * 2 - 1
입지 않는 경우의 수 빼기
 */
public class boj_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();

                if (hashMap.get(type) == null)
                    hashMap.put(type, 1);
                else
                    hashMap.put(type, hashMap.get(type) + 1);
            }

            int result = 1;
            for(int num : hashMap.values()){
                result *= (num + 1);
            }

            System.out.println(result-1);
        }
    }

}
