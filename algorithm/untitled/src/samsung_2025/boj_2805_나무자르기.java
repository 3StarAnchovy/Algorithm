package samsung_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {
    static int N, M;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long result = bs();
        System.out.println(result);
    }

    //설정할수 있는 높이의 최대값 구해보기
    private static long bs() {
        long start = 0; // arr[0]; // 나무 중 작은 거
        long end = arr[N - 1]; // arr[N-1]; // 나무 중 큰 거

        while(start <= end) {
            long mid = (start + end) / 2;
            long tree = cutTree(mid);

            if(tree < M) { //목표수보다 적게 얻었어. 많이 얻어야돼 높이 낮춰
                end = mid - 1;
            } else  {  //목표수보다 많이 얻었어. 높이 높혀
                start = mid + 1;
            }
        }

        return start;
    }

    private static long cutTree(long m) {
        long sum = 0;
        for(int tree : arr) {
            sum += Math.max(tree - m, 0);
        }
        return sum;
    }
}

/*
나무 m미터 필
나무를 필요한 만큼 집으로 가져가려고함
적어도 m미터의 나무를 집에 가져가기 위해 설정할수있는 최대값 구하기
 */