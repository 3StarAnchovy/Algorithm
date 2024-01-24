package softeer;

import java.io.*;
import java.util.*;


/*
step1 클래스 init 하기

class room
string name
int[19]; // 9 ~ 18 -> 내가쓸거 9 ~17까지만
9의 값이 1이다. = 9-10까지 먹힌거
9의 값이 0이다. = 0-10까지 빈 회의실

step2 입력받기
입력 받으면 클래스 할당하기
이름 맞춰서 배열 체킹하기.
14 16이면. 14부터 15까지 체킹하기

step3 출력하기
이름순으로 정렬하기
가능한거 표시하기
*/

public class soft_회의실예약 {
    private static int N;
    private static int M;

    private static class Room implements Comparable<Room> {
        String name;
        int[] time;

        public Room(String name) {
            this.name = name;
            this.time = new int[19];
        }

        public int compareTo(Room o){
            return this.name.compareTo(o.name);
        }
    }

    private static Room[] roomList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        roomList = new Room[N];
        //st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < N; i++) {
            roomList[i] = new Room(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                if (roomList[j].name.equals(input)) {
                    for (int t = start; t < end; t++)
                        roomList[j].time[t] = 1;
                }
            }
        }

        Arrays.sort(roomList);

        StringBuilder sb = new StringBuilder();
        //출력
        for (int i = 0; i < N; i++) {
            sb.append("Room ").append(roomList[i].name).append(":\n");
            boolean flag = false;
            for (int t = 9; t < 18; t++) {
                if (roomList[i].time[t] == 0) {
                    flag = true;
                    break;
                }

            }

            if (flag) {

                int start;
                int end;
                int cnt = 0;
                StringBuilder info = new StringBuilder();
                for (int t = 9; t < 18; t++) {
                    if (roomList[i].time[t] == 0) {
                        cnt++;
                        start = t;
                        while(t < 18 && roomList[i].time[t] == 0){
                            t ++;
                        }
                        end = t ;
                        info.append(start == 9 ? "09" : start).append('-').append(end).append('\n');
                    }
                }

                sb.append(cnt).append(" available:").append('\n').append(info);
            } else {
                sb.append("Not available").append('\n');
            }
            if(i < N - 1 )
                sb.append("-----").append('\n');
        }

        System.out.print(sb);
    }
}
