package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_19637_if문좀대신써줘 {
    static int N, M;
    static int[] arr;
    static HashMap<Integer, String> name = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String value = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            name.put(i, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(name.get(binarySearch(num))).append("\n");
        }
        System.out.print(sb);
    }

    private static int binarySearch(int num) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num > arr[mid]) {
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return start;
    }
}

/*
전투력 10,000이하의 캐릭터는 weak
초과에 100,000이하의 캐릭터는 노멀
초과에 1000000 이하의 캐릭터는 스트롱

n * m 만해도 1초 넘어감
이분탐색 조져보자

입력값의 최소값 -> 맨처음 나오는거
최대값 -> 맨 뒤에 나오는거

중간 재끼고
 */
