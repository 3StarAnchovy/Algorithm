package samsung_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1913_달팽이 {
    static int N,result;
    static int[][] arr;
    static boolean[][] visited;
    static int[] delta_i = {1,0,-1,0}; //하우상좌
    static int[] delta_j = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];
        dfs(0,0,0,0);
    }
    private static void printArr() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int cnt, int d, int i, int j) {
        if(cnt == N*N) {
            printArr();
            for(int r = 0; r < N; r ++) {
                for(int c = 0; c < N; c ++) {
                    if(arr[r][c] == result) {
                        int rr = r + 1;
                        int cc = c + 1;
                        System.out.print(rr + " " + cc);
                        return;
                    }
                }
            }
            return;
        }

        visited[i][j] = true;
        arr[i][j] = N*N - cnt;

        int ni = i + delta_i[d];
        int nj = j + delta_j[d];
        if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
            dfs(cnt + 1,d,ni,nj);
        } else {
            //방향 바꿔서 넘기기
            int nd = (d + 4 + 1) % 4;
            ni = i + delta_i[nd];
            nj = j + delta_j[nd];
            dfs(cnt + 1, nd, ni, nj);
        }


    }
}
