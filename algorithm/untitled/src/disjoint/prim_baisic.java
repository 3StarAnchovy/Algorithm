package disjoint;

import java.util.Arrays;
import java.util.Scanner;

public class prim_baisic {
    static int N; // 정점 개수
    static int matrix[][];
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        matrix = new int[N][N];
        for(int i = 0; i < N; i ++)
        {
            for(int j = 0; j < N; j ++)
                matrix[i][j] = scanner.nextInt(); // 가중치 입력
        }
        
        int cost = getMST();
        System.out.println(cost);
    }

    private static int getMST() {
        int cost = 0;
        int cnt = 0;

        //minEdge : 트리에서 해당 정점까지(index) 이동하는데에 드는 최소 비용(value)
        int[] minEdge = new int[N];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        boolean[] isInTree = new boolean[N];

        while(cnt < N)
        {
            //step 1.
            //트리에서 정점까지 이동하는데 최소 비용드는거 찾기.
            int minWeight = Integer.MAX_VALUE;
            int minVertex = -1;
            for(int v = 0; v < N; v++)
            {
                if(!isInTree[v] && minEdge[v] < minWeight)
                {
                    minVertex = v;
                    minWeight = minEdge[v];
                }
            }

            //step 2.
            // 트리에 최소비용 정점 추가
            isInTree[minVertex] = true;
            cost += minWeight;
            cnt ++;

            //step 3
            //minEdge 갱신
            for(int to = 0; to < N; to ++)
            {
                if(!isInTree[to] && matrix[minVertex][to] != 0)
                    minEdge[to] = Math.min(minEdge[to], matrix[minVertex][to]);
            }
        }

        return cost;
    }
}
