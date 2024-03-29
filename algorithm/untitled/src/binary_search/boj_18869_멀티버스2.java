package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_18869_멀티버스2 {
    static int N, M;
    static int[][] origin;
    static int[][] copy;
    static HashMap<Integer, Integer>[] hashMaps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N][M];
        copy = new int[N][M];
        hashMaps = new HashMap[N];
        for (int i = 0; i < N; i++) {
            hashMaps[i] = new HashMap<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                copy[i][j] = origin[i][j];
            }
        }

        //좌표 압축
        for (int i = 0; i < N; i++) {
            int rank = 0;
            Arrays.sort(copy[i]);
            for (int j = 0; j < M; j++) {
                if (hashMaps[i].get(copy[i][j]) == null) {
                    hashMaps[i].put(copy[i][j], rank);
                    rank++;
                }
            }
        }

        //랭킹 같은거 찾기
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                boolean flag = true;
                for (int k = 0; k < M; k++) {
                    if (!Objects.equals(hashMaps[i].get(origin[i][k]), hashMaps[j].get(origin[j][k]))) {
                        flag = false;
                        break;
                    }
                }
                if(flag) result ++;

            }
        }

        System.out.println(result);

        // for(int i = 0; i < N; i ++){
        //     for(int j = 0; j < M; j ++){
        //         System.out.print(hashMaps[i].get(origin[i][j]) + " ");
        //     }
        //     System.out.println();
        // }
    }
}
/*
좌표 압축

랭킹 같은거 찾기
 */