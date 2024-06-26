package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305_주유소 {
    static int N;
    static int[] distance;
    static int[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distance = new int[N - 1];
        city = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int now = city[0];
        for (int i = 0; i < N - 1; i++) {
            sum += (long)distance[i] * now;
            if (now > city[i + 1]) {
                now = city[i + 1];
            }
        }

        System.out.println(sum);
    }
}
/*
어떤 나라의 N개의 도시가 있다.

제일 왼쪽에서 오른쪽으로 이동할건데 길이가 다름
1k랑 1l 도시마다 주요소 리터당 가격은 다를 수 있음.
제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소 비용 계산
 */