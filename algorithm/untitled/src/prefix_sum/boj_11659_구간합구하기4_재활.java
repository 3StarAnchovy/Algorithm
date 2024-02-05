package prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11659_구간합구하기4_재활 {
    private static int N,M;
    private static int[] arr; //구간들의 합을 담을 배열 인덱스가 의미하는것 i = i까지의 구간합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i <= N; i ++){ //메모이제이션
            int input = Integer.parseInt(st.nextToken());
            arr[i] = arr[i - 1] + input;
        }

        for(int i = 0; i < M; i ++){
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = arr[end] - arr[start - 1];
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
