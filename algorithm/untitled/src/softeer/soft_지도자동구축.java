package softeer;

import java.io.*;
import java.util.*;

//점화식 문제
public class soft_지도자동구축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0)
            System.out.println(4);
        else {
            int result = 1;
            while (N-- > 0) {
                result = result * 4;
            }
            result = (int)Math.sqrt(result);
            result = (result + 1) * (result + 1);
            System.out.println(result);
        }
    }
}
