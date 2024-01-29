package softeer;

import java.io.*;
import java.util.*;

public class soft_비밀메뉴 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        String input = "";
        for(int i = 0; i < M; i ++){
            input += st.nextToken();
        }

        st = new StringTokenizer(br.readLine()," ");
        String ctrl ="";
        for(int i = 0; i < N; i ++){
            ctrl+= st.nextToken();
        }

        if(ctrl.contains(input))
            System.out.println("secret");
        else System.out.println("normal");
    }
}
