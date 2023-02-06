package dfs_bfs;

public class basic_2 {
    public static void printEdge(int[][] graph)
    {
        for(int i = 0; i < graph.length; i ++)
        {
            for(int j = 0; j < graph[i].length ;j ++)
                System.out.print(graph[i][j] + " ");
            System.out.println();
        }
    }

    public static void inputEdge(int[][] graph, int x, int y)
    {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public static void main(String[] args)
    {
        int n = 5; //정점의 개수

        //그래프를 표현할 2차원 배열 할당
        int[][] graph = new int[n + 1][n + 1];

        //입력
        inputEdge(graph, 1,2);
        inputEdge(graph,1,3);
        inputEdge(graph,1,4);
        inputEdge(graph,2,3);
        inputEdge(graph,2,5);
        inputEdge(graph,3,4);
        inputEdge(graph,4,5);
        //출력

        printEdge(graph);
    }
}
