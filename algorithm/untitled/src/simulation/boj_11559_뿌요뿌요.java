package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11559_뿌요뿌요 {
    static int[] delta_i = {-1, 1, 0, 0};
    static int[] delta_j = {0, 0, -1, 1};

    static class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        visited = new boolean[12][6];

        //init
        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int sum = 0;
        while(isPuyo()){
            sum ++;
            grounding();
            break;
        }

        System.out.println(sum);
    }
    private static void grounding(){
        return;
    }

    private static boolean isPuyo(){
        boolean flag = false;

        for(int i = 0; i < 12; i ++){
            for(int j = 0; j < 12; j ++){
                if(map[i][j] != '.'){
                    //int num = bfs();
                    // if(num >= 4){
                    //     flag = true;
                    // }
                }
            }
        }
        return flag;
    }

}

/*
step 0 상하좌우 4개 있음? 체킹하기
step1
    상하좌우 4개면 터치기 (bfs)
step2
    블록 내리기
step3
    몇번 반복했는지 뱉기
 */

/*
필드에 여러가지 색깔의 뿌요를 넣는다. 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올때까지 "아래"로 떨어진다.
뿌요를 놓고난 후, 같은 색 뿌요가 4개이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. -> 이때 1연쇄가 시작된다.
뿌요들이 없어지고 나서 위에 다른뿌요들이 있따면 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
아래로 떨어지고 나서 다시 같은 색의 뿌요들이 있으면 또 터지는데, 이걸 반복할때마다 1연쇄씩 늘어난다.
"터질수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야하고, 여러 그룹이 터지더라도 한번의 연쇄가 추가된다."

연쇄가 몇번 연속으로 일어날지 계산하여 남규를 도와주자.!!
 */
