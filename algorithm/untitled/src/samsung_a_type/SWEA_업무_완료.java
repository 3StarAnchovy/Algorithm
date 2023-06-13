package samsung_a_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_업무_완료 {
    static int[] memo;
    static int[] time;
    static boolean cycle;
    static ArrayList<Integer>[] pre;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++)
        {
            int N = Integer.parseInt(br.readLine());

            time = new int[N + 1];
            pre = new ArrayList[N + 1];
            for(int i = 1; i <= N; i ++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                time[i] = Integer.parseInt(st.nextToken());
                pre[i] = new ArrayList<>();
                int M = Integer.parseInt(st.nextToken());
                for(int j = 0; j < M; j ++)
                {
                    pre[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            cycle = false;
            int minTotalTime = Integer.MAX_VALUE;

            ex:
            for(int help = 1; help <= N; help ++)
            {
                memo = new int[N + 1];
                visited = new boolean[N + 1];

                int help_time = 0;
                for(int i = 1; i <= N; i ++)
                {
                    visited[i] = true;
                    int iTime = check(i,help);
                    visited[i] = false;

                    if(cycle)
                    {
                        minTotalTime = -1;
                        break ex;
                    }
                    if(help_time < iTime) help_time = iTime;
                }
                if(minTotalTime > help_time) minTotalTime = help_time;
            }

            sb.append("#").append(tc).append(" ").append(minTotalTime).append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int check(int idx, int help) {
        if(cycle) return -1;
        if(memo[idx] >0) return memo[idx];

        int max_time = 0;
        for(int i = 0; i < pre[idx].size(); i ++)
        {
            if(visited[pre[idx].get(i)])
            {
                cycle = true;
                return 0;
            }

            visited[pre[idx].get(i)] = true;
            int workTime = check(pre[idx].get(i),help);
            if(max_time < workTime) max_time = workTime;
            visited[pre[idx].get(i)] = false;
        }

        return memo[idx] = max_time + (idx == help ? time[idx]/2 : time[idx]);
    }

}
