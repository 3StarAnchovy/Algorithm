//package dfs_bfs;
//
//import java.util.Scanner;
//
//public class boj_3344 {
//    static int N;
//    static int[] map;
//    static boolean[] visited;
//
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//
//        N = scanner.nextInt();
//        map = new int[N];
//        visited = new boolean[N];
//        for(int i = 0; i < N; i ++)
//        {
//            NQueen_Dfs(0,i);
//        }
//    }
//
//    private static void NQueen_Dfs(int cnt,int pos)
//    {
//        if(cnt == N)
//            return;
//        for(int j = 0; j < N; j ++)
//        {
//            //i가 true이면 i행, i열 못놓음
//            //대각 체크 어케함?
//            if(!visited[j] && checkQueen(j))
//            {
//                map[pos] = j;
//                visited[pos] = true;
//                NQueen_Dfs(cnt + 1, pos + 1);
//                visited[i] = false;
//            }
//        }
//    }
//
//    private static boolean checkQueen(int i)
//    {
//        //행에 둘수 있나 ?
//
//        //열에 둘 수 있나?
//
//        //대각선 둘 수 있나? 기울기 체킹, 근데 분모가 0이면?
//    }
//}
