package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1535_안녕 {
    static int N;
    static int[] L;
    static int[] J;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        L = new int[N + 1];
        J = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i <= N; i ++){
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i <= N; i ++){
            J[i] = Integer.parseInt(st.nextToken());
        }
    }
}

/*
사람 총 n명 1 ~ n
i번 사람에게 인사하면 L[i]만큼 체력을 잃고, J[i]만큼 얻음 각각 최대 1번만 말할수 있어

최대한 기쁨을 느끼고싶음. 체력 100임
 */
