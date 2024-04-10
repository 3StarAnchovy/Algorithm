package baisic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_2575_임스뭐시기 {
    static int N;
    static Set<String> set = new HashSet<>();
    static char game;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        game = st.nextToken().charAt(0);

        for(int i = 0; i < N; i ++){
            set.add(br.readLine());
        }

        if(game == 'Y')
            System.out.println(set.size());
        else if(game == 'F')
            System.out.println(set.size()/2);
        else
            System.out.println(set.size()/3);
    }
}
