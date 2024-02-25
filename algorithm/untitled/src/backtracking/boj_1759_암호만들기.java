package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다.
즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.

// 오름 차순
// 모음 체킹
// 조합
 */
public class boj_1759_암호만들기 {
    static int L, C;
    static char[] arr;
    static char[] picked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        picked = new char[L];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        getCombi(0, 0, 0, 0);
        System.out.println(sb);
    }

    private static boolean isMo(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }

    private static void getCombi(int cnt, int start, int moCnt, int jaCnt) {
        if (cnt == L) {
            if(moCnt > 0 && jaCnt > 1){
                for(int i = 0; i < L; i ++)
                    sb.append(picked[i]);
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            picked[cnt] = arr[i];
            getCombi(cnt + 1, i + 1, isMo(arr[i]) ? moCnt + 1 : moCnt, isMo(arr[i]) ? jaCnt : jaCnt + 1);
        }
    }
}
