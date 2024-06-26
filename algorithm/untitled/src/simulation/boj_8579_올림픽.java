package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_8579_올림픽 {
    static int N, K;

    static class Pos implements Comparable<Pos>{
        int num, gold, silver, bronze;
        int rate;

        public Pos(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Pos o){
            if(o.gold == this.gold){
                if(o.silver == this.silver){
                    return o.bronze - this.bronze;
                }else {
                    return o.silver - this.silver;
                }
            }
            else{
                return o.gold - this.gold;
            }
        }
    }
    static List<Pos> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine()," ");
            list.add(new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        list.get(0).rate = 1;

        int answer = 1;
        for(int i = 1; i < list.size(); i ++){
            Pos pr = list.get(i - 1);
            Pos now = list.get(i); // now + 1은 국가 번호임
            if(pr.gold == now.gold && pr.silver == now.silver && pr.bronze == now.bronze){
                now.rate = pr.rate;
            } else {
                now.rate = i + 1;
            }
            if(now.num  == K)
                answer = now.rate;
        }

        System.out.println(answer);


    }
}

/*
금메달 수가 더 많은 나라
금메달 수가 같으면, 은메달 수가 더 많은 나라
금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라

만약 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수
 */