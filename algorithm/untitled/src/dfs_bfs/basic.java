package dfs_bfs;

import java.util.ArrayList;

public class basic
{
    public static void pritEdge(ArrayList<ArrayList<Integer>> graph)
    {
        for(int i = 1; i < graph.size(); i ++)
        {
            ArrayList<Integer> node = graph.get(i);
            System.out.print("node" + "[" + i + "] : ");
            for(int j = 0; j < node.size(); j ++)
                System.out.print(node.get(j) + " -> ");
            System.out.println();
        }
    }
    public static void inputEdge(ArrayList<ArrayList<Integer>> graph, int x, int y)
    {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    public static void main(String[] args)
    {
        int n = 5; // 정점 개수

        // 그래프를 표현할 ArrayList, 다차원 리스트로 할당
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //노드 할당, 편의성을 위해 0번째는 비워놓음
        for(int i = 0; i <= n; i ++)
            graph.add(new ArrayList<Integer>());

        //입력
        inputEdge(graph,1,2);
        inputEdge(graph,1,3);
        inputEdge(graph,1,4);
        inputEdge(graph,2,3);
        inputEdge(graph,2,5);
        inputEdge(graph,3,4);
        inputEdge(graph,4,5);
        //출력
        pritEdge(graph);
    }
}