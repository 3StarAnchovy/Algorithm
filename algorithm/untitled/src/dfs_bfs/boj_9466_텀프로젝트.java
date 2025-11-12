package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9466_텀프로젝트 {
    static int T, N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] end;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];
            visited = new boolean[N + 1];
            end = new boolean[N + 1];
            cnt = 0;

            // step 1 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // step 2 dfs
            for (int i = 1; i <= N; i++) {
                dfs(i);
            }

            sb.append(N - cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int now) {
        if (visited[now])
            return;

        int nxt = arr[now];
        visited[now] = true;

        if (!visited[nxt]) {
            dfs(nxt);
        } else if (visited[nxt] && !end[nxt]) {
            cnt++;
            for (int i = nxt; i != now; i = arr[i]) {
                cnt ++;
            }
        }

        end[now] = true;
    }

    /*
    팀원수엔 제한 없음, 모든 학생들이 동일한 팀의 팀원인 경우 등 한팀만있을수도있음
    모든 학생들은 프로젝트를 함께하고 싶은 학생 선택 (한명만
    순환구조일때 팀 생성됨
     */
    // step 1 입력

    // step 2 dfs

    // 들어가면 방문처리

    // 방문처리 되어있는데 end처리 안되있는거?
    // nxt 기준으로 카운팅하기
    // 사이클 끝 다음은 무조건 시작임
    // 사이클은 무조건 끝이고, 재귀의 탈출은 사이클임

    // 마지막에 end 처리 (앞으로 안쓸거)
}
