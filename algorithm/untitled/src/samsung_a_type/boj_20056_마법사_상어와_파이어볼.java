package samsung_a_type;

import java.util.*;


/*
문제 해석
파이어볼은 위치, 질량, 방향, 속력 가지고 있음
파이어볼이 자신의 방향, 속력만큼 이동함
이동 후
    같은 칸 파이어볼이 모두 합쳐짐
    파이어볼이 네개로 나누어지고 이때 질량 속력 방향은
        질량 질량 합 / 5
        속력 속력 합 / 합쳐진 파이어볼 개수
        합쳐지는 파이어볼의 방향이 모두 홀수이거나 짝수면 0 2 4 6, 그렇지 않으면 1,3,5,7
    질량이 0이면 파이어볼은 소멸됨

    k번의 이동 명령 후 남아있는 파이어볼 질량 합 추출
 */

/*
문제 접근 -> 개빡구현
이동 구현()
이동 후 sideEffect 구현
합 추출 구현
 */
public class boj_20056_마법사_상어와_파이어볼 {
    static int N;
    static int M;
    static int K;

    static int[] delta_i = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] delta_j = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Fireball implements Comparable<Fireball> {
        int i;
        int j;
        int m; // 질량
        int s; // 속도
        int d; // 방향
        int idx; // 논리적 위치
        int cnt = 1;

        public Fireball(int i, int j, int m, int s, int d, int idx) {
            this.i = i;
            this.j = j;
            this.m = m;
            this.s = s;
            this.d = d;
            this.idx = idx;
        }

        @Override
        public int compareTo(Fireball o) {
            return this.idx - o.idx;
        }
    }

    static List<Fireball> fireballList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // map 사이즈
        M = scanner.nextInt(); // 파이어볼 개수
        K = scanner.nextInt(); // 명령 횟수

        for (int i = 0; i < M; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int m = scanner.nextInt();
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            fireballList.add(new Fireball(r, c, m, s, d, (r * N) + c));
        }

        for (int i = 0; i < K; i++) {
            //step1 이동 구현
            System.out.println("before");
            print();
            moveFireball();
            //step2 사이드 이펙트 구현
            System.out.println("after");
            print();
            System.out.println("side effect");
            sideEffect();
            print();
        }
        //step3 질량 추출
        System.out.println(getSum());
    }

    private static int getSum() {
        int sum = 0;
        for (Fireball o : fireballList)
            sum += o.m;
        return sum;
    }
    //그냥 갈아엎자ㅅㅂ..
    //같은 idx인거 체크. idx 같은거는 큐에 담자, 하나씩비교하다가 다른거 나오면 큐에 있는거 연산, 방향 연산 때문에 큐 쓰는게 편할거같다.
    private static void sideEffect() {
        Collections.sort(fireballList);
        Queue<Fireball> same_pos = new ArrayDeque<>();

        int size = fireballList.size();
        for (int i = 0; i < size - 1; i++) {
            //같은 위치에 있는거 전부다 큐에 몰아넣음
            if (fireballList.get(i).idx == fireballList.get(i + 1).idx) {
                same_pos.add(fireballList.get(i));
                System.out.println(fireballList);
                fireballList.remove(i);
                i--;
                size --;
                System.out.println(i + " " + size);
                //큐에 있는것들은 리스트에서 다 지우고,
            }
            else if (!same_pos.isEmpty()) {
                System.out.println("hi");
                combine(same_pos);
            }

            if(i == fireballList.size() - 2 && !same_pos.isEmpty())
            {
                same_pos.add(fireballList.get(i + 1));
                fireballList.remove(i + 1);
                System.out.println("test");
                combine(same_pos);
            }
        }
    }

    //압축 후, 퍼뜨리기
    private static void combine(Queue<Fireball> same) {
        int m_sum = 0;
        int s_sum = 0;
        int r = 0;
        int c = 0;
        boolean isOdd = true;
        boolean isEven = true;
        int q_size = same.size();

        while (!same.isEmpty()) {
            Fireball fb = same.poll();
            r = fb.i;
            c = fb.j;
            m_sum += fb.m;
            s_sum += fb.s;

            if (fb.cnt % 2 == 0)
                isOdd = false;
            else
                isEven = false;
        }

        m_sum = m_sum / 5;
        s_sum = s_sum / q_size;

        // 질량이 0 인경우 -> 이새끼 삭제
        if (m_sum == 0) {
            System.out.println("hi");
            return;
        }
        //혼합인 경우
        if (isEven || isOdd) {
            //1,3,5,7
            for (int d = 1; d <= 7; d += 2) {
                fireballList.add(new Fireball(r, c, m_sum, s_sum, d, (r * N) + c));
            }
        } else {
            for (int d = 0; d < 7; d += 2) {
                fireballList.add(new Fireball(r, c, m_sum, s_sum, d, (r * N) + c));
            }
        }
    }

    private static void moveFireball() {
        for (Fireball fireball : fireballList) {
            int ni = (fireball.i + delta_i[fireball.d] * fireball.s + N) % N; //여기 고쳐야됨..어..시발 이거 음수뜰수도 있겠다. 일단 이따 고치자
            int nj = (fireball.j + delta_j[fireball.d] * fireball.s + N) % N;
            int idx = (ni * N) + nj;
            fireball.i = ni;
            fireball.j = nj;
            fireball.idx = idx;
        }
    }

    private static void print() {
        for (Fireball fireball : fireballList) {
            System.out.print(fireball.idx + " ");
        }
        System.out.println();
    }
}
